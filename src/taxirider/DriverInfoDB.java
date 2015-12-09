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
public class DriverInfoDB {
    private String driverID;
    private String carRegNo;
    private String email;
    private String name;
    private String password;
    private String mobileNo;
    private String language;
    private String creditCardNo;
    private String cvv;
    private Timestamp expirationDate;
    private String address;
    private String drivingLicense;
    private String carModel;

    public DriverInfoDB(String driverID, String carRegNo, String email, String name, String password, String mobileNo, String language, String creditCardNo, String cvv, Timestamp expirationDate, String address, String drivingLicense, String carModel) {
        this.driverID = driverID;
        this.carRegNo = carRegNo;
        this.email = email;
        this.name = name;
        this.password = password;
        this.mobileNo = mobileNo;
        this.language = language;
        this.creditCardNo = creditCardNo;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.address = address;
        this.drivingLicense = drivingLicense;
        this.carModel = carModel;
    }

    public DriverInfoDB() {
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getCarRegNo() {
        return carRegNo;
    }

    public void setCarRegNo(String carRegNo) {
        this.carRegNo = carRegNo;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    
}
