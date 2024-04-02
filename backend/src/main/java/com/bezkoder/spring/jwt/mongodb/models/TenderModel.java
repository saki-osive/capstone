package com.bezkoder.spring.jwt.mongodb.models;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tender")
public class TenderModel {

    @Id
    private String id;

    @DBRef
    private User tenderCreator;

    private String name;
    private String scopeOfWork;
    private String referenceNumber;
    private String referenceDate;
    private String typeOfBiddingSystem;
    private String type;
    private String formOfContract;
    private String numberOfCover;
    private String category;
    private String accountTypeHead;
    private String numberOfBidOpeners;
    private String allowReBidSubmission;
    private String allowWithdrawalOfBids;
    private String bidSecurityEnabled;
    private String allowOfflineSubmission;
    private String allowTechnicalEvaluation;
    private String venue;
    private String preBitMeetingDate;
    private String dueDateForBidSubmission;
    private String unPricedBidOpeningDate;
    private String contactName;
    private String email;
    private String phoneNumber;
    private String shouldAllowMultiCurrency;
    private String paymentMode;
    private String tenderFileDocumentPath;
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

    public User getTenderCreator() {
        return tenderCreator;
    }

    public void setTenderCreator(User tenderCreator) {
        this.tenderCreator = tenderCreator;
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

    public String getTypeOfBiddingSystem() {
        return typeOfBiddingSystem;
    }

    public void setTypeOfBiddingSystem(String typeOfBiddingSystem) {
        this.typeOfBiddingSystem = typeOfBiddingSystem;
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

    public String getNumberOfBidOpeners() {
        return numberOfBidOpeners;
    }

    public void setNumberOfBidOpeners(String numberOfBidOpeners) {
        this.numberOfBidOpeners = numberOfBidOpeners;
    }

    public String getAllowReBidSubmission() {
        return allowReBidSubmission;
    }

    public void setAllowReBidSubmission(String allowReBidSubmission) {
        this.allowReBidSubmission = allowReBidSubmission;
    }

    public String getAllowWithdrawalOfBids() {
        return allowWithdrawalOfBids;
    }

    public void setAllowWithdrawalOfBids(String allowWithdrawalOfBids) {
        this.allowWithdrawalOfBids = allowWithdrawalOfBids;
    }

    public String getBidSecurityEnabled() {
        return bidSecurityEnabled;
    }

    public void setBidSecurityEnabled(String bidSecurityEnabled) {
        this.bidSecurityEnabled = bidSecurityEnabled;
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

    public String getDueDateForBidSubmission() {
        return dueDateForBidSubmission;
    }

    public void setDueDateForBidSubmission(String dueDateForBidSubmission) {
        this.dueDateForBidSubmission = dueDateForBidSubmission;
    }

    public String getUnPricedBidOpeningDate() {
        return unPricedBidOpeningDate;
    }

    public void setUnPricedBidOpeningDate(String unPricedBidOpeningDate) {
        this.unPricedBidOpeningDate = unPricedBidOpeningDate;
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

    public String getTenderFileDocumentPath() {
        return tenderFileDocumentPath;
    }

    public void setTenderFileDocumentPath(String tenderFileDocumentPath) {
        this.tenderFileDocumentPath = tenderFileDocumentPath;
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
