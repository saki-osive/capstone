package com.lotlock.spring.jwt.mongodb.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "product")
public class Product {

    @Id
    private String id;

    private String currency;
    private String technicalDocumentPath;
    private String financialDocumentPath;

    private String agreementAccepted;
    private String nameOfCompany;
    private String gstNumber;
    private String productAmount;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    @DBRef
    private List<ProductItem> productItems;

    @DBRef
    private LotModel lot;

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTechnicalDocumentPath() {
        return technicalDocumentPath;
    }

    public void setTechnicalDocumentPath(String technicalDocumentPath) {
        this.technicalDocumentPath = technicalDocumentPath;
    }

    public String getFinancialDocumentPath() {
        return financialDocumentPath;
    }

    public void setFinancialDocumentPath(String financialDocumentPath) {
        this.financialDocumentPath = financialDocumentPath;
    }

    public String getAgreementAccepted() {
        return agreementAccepted;
    }

    public void setAgreementAccepted(String agreementAccepted) {
        this.agreementAccepted = agreementAccepted;
    }

    public LotModel getLot() {
        return lot;
    }

    public void setLot(LotModel lot) {
        this.lot = lot;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }
}
