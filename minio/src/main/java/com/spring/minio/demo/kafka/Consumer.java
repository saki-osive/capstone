package com.spring.minio.demo.kafka;


import com.spring.minio.demo.MinioController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(MinioController.class);

    @KafkaListener(topics = "kafka_Example", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("### -> Consumed message -> %s", message));

    }


}
