/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

/**
 *
 * @author razon
 */
public class TourPaymentDB {
    private int tourID;
    private String userID;
    private String generatedCode;
    private String paymentType;
    private double amount;
    public TourPaymentDB() {
    }

    public TourPaymentDB(int tourID, String userID, String generatedCode, String paymentType, double amount) {
        this.tourID = tourID;
        this.userID = userID;
        this.generatedCode = generatedCode;
        this.paymentType = paymentType;
        this.amount = amount;
    }


    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGeneratedCode() {
        return generatedCode;
    }

    public void setGeneratedCode(String generatedCode) {
        this.generatedCode = generatedCode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
