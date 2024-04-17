package com.lotlock.spring.jwt.mongodb.controllers;

import com.lotlock.spring.jwt.mongodb.events.Events;
import com.lotlock.spring.jwt.mongodb.models.Product;
import com.lotlock.spring.jwt.mongodb.models.ProductItem;
import com.lotlock.spring.jwt.mongodb.network.response.BaseResponse;
import com.lotlock.spring.jwt.mongodb.repository.ProductItemRepository;
import com.lotlock.spring.jwt.mongodb.repository.ProductRepository;
import com.lotlock.spring.jwt.mongodb.services.TransactionService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlefebure.spring.boot.minio.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TransactionService transactionService;

    @Autowired
    ProductItemRepository productItemRepository;

    @Autowired
    private MinioService minioService;

    private final String folderPath = "";

    @GetMapping("/all")
    public ResponseEntity<?> getAllDraftLots() {
        ResponseEntity<?> result = null;

        List<Product> allProducts = productRepository.findAll();
        result = new ResponseEntity<>(allProducts, HttpStatus.CREATED);

        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(@RequestParam(value = "technicalDoc",required = false) MultipartFile technicalDoc,
                                           @RequestParam(value = "financialDoc", required = false) MultipartFile financialDoc,
                                           @RequestParam("product") String productModelString) {

        ResponseEntity<?> result = null;

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {

            Product productModel = objectMapper.readValue(productModelString, Product.class);
            List<ProductItem> productItems = productModel.getProductItems();
            for (ProductItem item:productItems){
                item = productItemRepository.save(item);
            }

            //upload financial and tech docs to minio
            if (technicalDoc != null){
                Path technicalDocumentPath = Path.of(folderPath+technicalDoc.getOriginalFilename());
                minioService.upload(technicalDocumentPath, technicalDoc.getInputStream(), technicalDoc.getContentType());
                productModel.setTechnicalDocumentPath(folderPath+technicalDocumentPath.toString());
            }

            if (financialDoc != null){
                Path financialDocPath = Path.of(folderPath+financialDoc.getOriginalFilename());
                minioService.upload(financialDocPath, financialDoc.getInputStream(), financialDoc.getContentType());
                productModel.setFinancialDocumentPath(folderPath+financialDocPath.toString());
            }

            //save product
            Product _product = productRepository.save(productModel);

            transactionService.log("", Events.PRODUCT_CREATED,"",_product);
            result = ResponseEntity.ok(new BaseResponse("Product created successfully.",true,_product));

        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }

}
