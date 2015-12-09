/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.sql.Timestamp;

/**
 *
 * @author razon
 */
public class UserInfoDB {

    private String userID;
    private String email;
    private String name;
    private String password;
    private String mobileNo;
    private String language;
    private String creditCardNo;
    private String cvv;
    private Timestamp expirationDate;
    private String postalCode;
    private String userVerification;

    public UserInfoDB(String userID, String email, String name, String password, String mobileNo, String language, String creditCardNo, String cvv, Timestamp expirationDate, String postalCode, String userVerification) {
        this.userID = userID;
        this.email = email;
        this.name = name;
        this.password = password;
        this.mobileNo = mobileNo;
        this.language = language;
        this.creditCardNo = creditCardNo;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.postalCode = postalCode;
        this.userVerification = userVerification;
    }

    public UserInfoDB() {
    }

    public UserInfoDB(String userID, String email, String name, String password, String mobileNo, String language, String creditCardNo, String cvv, Timestamp expirationDate, String postalCode) {
        this.userID = userID;
        this.email = email;
        this.name = name;
        this.password = password;
        this.mobileNo = mobileNo;
        this.language = language;
        this.creditCardNo = creditCardNo;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.postalCode = postalCode;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getUserVerification() {
        return userVerification;
    }

    public void setUserVerification(String userVerification) {
        this.userVerification = userVerification;
    }


}
