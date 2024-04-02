package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "bid")
public class Bid {

    @Id
    private String id;

    private String currency;
    private String technicalDocumentPath;
    private String financialDocumentPath;

    private String agreementAccepted;
    private String nameOfCompany;
    private String gstNumber;
    private String bidAmount;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    @DBRef
    private List<BidItem> bidItems;

    @DBRef
    private TenderModel tender;

    public List<BidItem> getBidItems() {
        return bidItems;
    }

    public void setBidItems(List<BidItem> bidItems) {
        this.bidItems = bidItems;
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

    public TenderModel getTender() {
        return tender;
    }

    public void setTender(TenderModel tender) {
        this.tender = tender;
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

    public String getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(String bidAmount) {
        this.bidAmount = bidAmount;
    }
}
