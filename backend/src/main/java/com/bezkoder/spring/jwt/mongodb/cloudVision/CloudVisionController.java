package com.bezkoder.spring.jwt.mongodb.cloudVision;

import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.payload.request.ForgotPasswordRequest;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/vision")
public class CloudVisionController {

    @Autowired
    CloudVisionService cloudVisionService;

    @GetMapping("/process")
    public ResponseEntity<?> process() {
        ResponseEntity result = null;

        try {
            String filePath = "/Users/singh/Desktop/test2.png";
            BatchAnnotateImagesResponse response = cloudVisionService.detectText(filePath);
            result = ResponseEntity.ok(com.google.protobuf.util.JsonFormat.printer().print(response));
        } catch (IOException e) {
            e.printStackTrace();

        }
        return result;
    }
}
