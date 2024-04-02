package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.cloudVision.CloudVisionService;
import com.bezkoder.spring.jwt.mongodb.models.TenderModel;
import com.bezkoder.spring.jwt.mongodb.network.response.BaseResponse;
import com.bezkoder.spring.jwt.mongodb.payload.request.DownloadRequest;
import com.bezkoder.spring.jwt.mongodb.services.TransactionService;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.jlefebure.spring.boot.minio.MinioConfigurationProperties;
import com.jlefebure.spring.boot.minio.MinioException;
import com.jlefebure.spring.boot.minio.MinioService;
import io.minio.MinioClient;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/download")
public class DownloadController {

    @Autowired
    private MinioService minioService;

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioConfigurationProperties configurationProperties;

    @Autowired
    private CloudVisionService cloudVisionService;

    @Autowired
    TransactionService transactionService;

    @PostMapping("/document")
    public ResponseEntity<?> downloadFile(@Valid @RequestBody DownloadRequest downloadRequest) {
        ResponseEntity<?> result = null;

        try {
            Path documentPath = Path.of(downloadRequest.getFileName());

//
            String objectName = String.valueOf(documentPath);
            Integer expiry = 60*60*24*7;
            String bucketName = this.configurationProperties.getBucket();
            String signedUrl = minioClient.getPresignedObjectUrl(Method.GET,bucketName,objectName,expiry,null);

            System.out.println(signedUrl);

            result = ResponseEntity.ok(new BaseResponse("download success",true,signedUrl));



        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }

    @PostMapping("/ocr")
    public ResponseEntity<?> getOCRText(@Valid @RequestBody DownloadRequest downloadRequest) {
        Path documentPath = Path.of(downloadRequest.getFileName());
        ResponseEntity<?> result = null;
        try {
            InputStream inputStream = minioService.get(documentPath);

            BatchAnnotateImagesResponse response = cloudVisionService.detectTextInputString(inputStream);
//            String responseText = convertResponseToString(response);
            String responseText = "";
            if (response.getResponsesList().size() > 0){
                responseText = response.getResponsesList().get(0).getFullTextAnnotation().getText();
            }else {
                responseText = "Unable to process";
            }
//            result = ResponseEntity.ok(com.google.protobuf.util.JsonFormat.printer().print(response));

            result = ResponseEntity.ok(new BaseResponse("",true,responseText));

        } catch (MinioException | IOException e) {
            e.printStackTrace();
            result = ResponseEntity.badRequest().body(new BaseResponse("Failed",false));
        }

        return result;
    }

    private String convertResponseToString(BatchAnnotateImagesResponse response) {
        StringBuilder message = new StringBuilder();

        for (AnnotateImageResponse res : response.getResponsesList()) {

            for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                String desc = annotation.getDescription();
                message.append(desc);
            }
        }
        return message.toString();
    }
}
