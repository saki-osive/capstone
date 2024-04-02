package com.bezkoder.spring.jwt.mongodb.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @Size(max = 120)
  private String password;

  @DBRef
  private Set<Role> roles = new HashSet<>();

  private String companyName;
  private String gailVendorCode;
  private String gailTenderRef;
  private String language;
  private String telephone;
  private String mobile;
  private String address;
  private String gstNumber;
  private String country;
  private String gstCertificatePath;

  private String firstName;
  private String lastName;
  private String primaryContact;
  private String secondaryContact;
  private String userStatus;

  public User() {
  }

  public User(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getGailVendorCode() {
    return gailVendorCode;
  }

  public void setGailVendorCode(String gailVendorCode) {
    this.gailVendorCode = gailVendorCode;
  }

  public String getGailTenderRef() {
    return gailTenderRef;
  }

  public void setGailTenderRef(String gailTenderRef) {
    this.gailTenderRef = gailTenderRef;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getGstNumber() {
    return gstNumber;
  }

  public void setGstNumber(String gstNumber) {
    this.gstNumber = gstNumber;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getGstCertificatePath() {
    return gstCertificatePath;
  }

  public void setGstCertificatePath(String gstCertificatePath) {
    this.gstCertificatePath = gstCertificatePath;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPrimaryContact() {
    return primaryContact;
  }

  public void setPrimaryContact(String primaryContact) {
    this.primaryContact = primaryContact;
  }

  public String getSecondaryContact() {
    return secondaryContact;
  }

  public void setSecondaryContact(String secondaryContact) {
    this.secondaryContact = secondaryContact;
  }

  public String getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }
}
