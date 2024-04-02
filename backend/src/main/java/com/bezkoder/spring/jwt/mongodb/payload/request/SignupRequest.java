package com.bezkoder.spring.jwt.mongodb.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {

    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> roles;

    private String password;

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

    public void setRoles(Set<String> roles) {
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
    
    public Set<String> getRoles() {
      return this.roles;
    }
    
    public void setRole(Set<String> roles) {
      this.roles = roles;
    }
}
