package com.bezkoder.spring.jwt.mongodb.payload.request;

public class DownloadRequest {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
