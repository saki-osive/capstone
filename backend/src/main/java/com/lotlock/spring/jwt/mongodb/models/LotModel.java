package com.lotlock.spring.jwt.mongodb.models;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "lot")
public class LotModel {

    @Id
    private String id;

    @DBRef
    private User lotCreator;

    private String name;
    private String scopeOfWork;
    private String referenceNumber;
    private String referenceDate;
    private String typeOfProductSystem;
    private String type;
    private String formOfContract;
    private String numberOfCover;
    private String category;
    private String accountTypeHead;
    private String numberOfProductOpeners;
    private String allowReProductSubmission;
    private String allowWithdrawalOfProducts;
    private String productSecurityEnabled;
    private String allowOfflineSubmission;
    private String allowTechnicalEvaluation;
    private String venue;
    private String preBitMeetingDate;
    private String dueDateForProductSubmission;
    private String unPricedProductOpeningDate;
    private String contactName;
    private String email;
    private String phoneNumber;
    private String shouldAllowMultiCurrency;
    private String paymentMode;
    private String lotFileDocumentPath;
    private String sorFilePath;
    private Boolean approved;
    private Boolean draft;
    private String review;
    private String invitingOfficer;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getLotCreator() {
        return lotCreator;
    }

    public void setLotCreator(User lotCreator) {
        this.lotCreator = lotCreator;
    }

    public String getInvitingOfficer() {
        return invitingOfficer;
    }

    public void setInvitingOfficer(String invitingOfficer) {
        this.invitingOfficer = invitingOfficer;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getScopeOfWork() {
        return scopeOfWork;
    }

    public void setScopeOfWork(String scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(String referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getTypeOfProductSystem() {
        return typeOfProductSystem;
    }

    public void setTypeOfProductSystem(String typeOfProductSystem) {
        this.typeOfProductSystem = typeOfProductSystem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormOfContract() {
        return formOfContract;
    }

    public void setFormOfContract(String formOfContract) {
        this.formOfContract = formOfContract;
    }

    public String getNumberOfCover() {
        return numberOfCover;
    }

    public void setNumberOfCover(String numberOfCover) {
        this.numberOfCover = numberOfCover;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccountTypeHead() {
        return accountTypeHead;
    }

    public void setAccountTypeHead(String accountTypeHead) {
        this.accountTypeHead = accountTypeHead;
    }

    public String getNumberOfProductOpeners() {
        return numberOfProductOpeners;
    }

    public void setNumberOfProductOpeners(String numberOfProductOpeners) {
        this.numberOfProductOpeners = numberOfProductOpeners;
    }

    public String getAllowReProductSubmission() {
        return allowReProductSubmission;
    }

    public void setAllowReProductSubmission(String allowReProductSubmission) {
        this.allowReProductSubmission = allowReProductSubmission;
    }

    public String getAllowWithdrawalOfProducts() {
        return allowWithdrawalOfProducts;
    }

    public void setAllowWithdrawalOfProducts(String allowWithdrawalOfProducts) {
        this.allowWithdrawalOfProducts = allowWithdrawalOfProducts;
    }

    public String getProductSecurityEnabled() {
        return productSecurityEnabled;
    }

    public void setProductSecurityEnabled(String productSecurityEnabled) {
        this.productSecurityEnabled = productSecurityEnabled;
    }

    public String getAllowOfflineSubmission() {
        return allowOfflineSubmission;
    }

    public void setAllowOfflineSubmission(String allowOfflineSubmission) {
        this.allowOfflineSubmission = allowOfflineSubmission;
    }

    public String getAllowTechnicalEvaluation() {
        return allowTechnicalEvaluation;
    }

    public void setAllowTechnicalEvaluation(String allowTechnicalEvaluation) {
        this.allowTechnicalEvaluation = allowTechnicalEvaluation;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getPreBitMeetingDate() {
        return preBitMeetingDate;
    }

    public void setPreBitMeetingDate(String preBitMeetingDate) {
        this.preBitMeetingDate = preBitMeetingDate;
    }

    public String getDueDateForProductSubmission() {
        return dueDateForProductSubmission;
    }

    public void setDueDateForProductSubmission(String dueDateForProductSubmission) {
        this.dueDateForProductSubmission = dueDateForProductSubmission;
    }

    public String getUnPricedProductOpeningDate() {
        return unPricedProductOpeningDate;
    }

    public void setUnPricedProductOpeningDate(String unPricedProductOpeningDate) {
        this.unPricedProductOpeningDate = unPricedProductOpeningDate;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShouldAllowMultiCurrency() {
        return shouldAllowMultiCurrency;
    }

    public void setShouldAllowMultiCurrency(String shouldAllowMultiCurrency) {
        this.shouldAllowMultiCurrency = shouldAllowMultiCurrency;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getLotFileDocumentPath() {
        return lotFileDocumentPath;
    }

    public void setLotFileDocumentPath(String lotFileDocumentPath) {
        this.lotFileDocumentPath = lotFileDocumentPath;
    }

    public String getSorFilePath() {
        return sorFilePath;
    }

    public void setSorFilePath(String sorFilePath) {
        this.sorFilePath = sorFilePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }
}
