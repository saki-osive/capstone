package com.spring.minio.demo;


import com.jlefebure.spring.boot.minio.MinioException;
import com.jlefebure.spring.boot.minio.MinioService;

import io.minio.messages.Item;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController

@RequestMapping("/files")
public class MinioController {

    @Autowired
    private MinioService minioService;

    private String message ;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC= "kafka_Example";

    //Listing all files in the bucket
    @GetMapping("/")
    public List<Item> testMinio() throws MinioException {

        message = "reading file from minio";
        kafkaTemplate.send(TOPIC,message);
        return minioService.list();
    }

    //Uploading file to the bucket
    @PostMapping("/upload")
    public void addAttachement(@RequestParam("file") MultipartFile file) {

        Path path = Paths.get(file.getOriginalFilename());

        try {
            minioService.upload(path, file.getInputStream(), file.getContentType());
        } catch (MinioException e) {
            throw new IllegalStateException("The file cannot be upload on the internal storage. Please retry later", e);
        } catch (IOException e) {
            throw new IllegalStateException("The file cannot be read", e);
        }

        message = "uploading file :" + path;
        kafkaTemplate.send(TOPIC,message);
    }

    //Reading contents of the file
    @GetMapping("/{object}")
    public void getObject(@PathVariable("object") String object, HttpServletResponse response) throws MinioException, IOException {

        InputStream inputStream = minioService.get(Paths.get(object));

        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);

        // Set the content type and attachment header.
        response.addHeader("Content-disposition", "attachment;filename=" + object);
        response.setContentType(URLConnection.guessContentTypeFromName(object));

        // Copy the stream to the response's output stream.
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();

        message = "reading content of file : " + object;
        kafkaTemplate.send(TOPIC,message);
    }

    //Delete file from bucket
    @DeleteMapping("/delete/{object}")
    public String deleteFileFromBucket(@PathVariable("object") String object) throws MinioException {

        Path path = Paths.get(object);
        minioService.remove(path);

        message = "deleting file : " + object;
        kafkaTemplate.send(TOPIC,message);

        return "deleted file :" + object;
    }

}
