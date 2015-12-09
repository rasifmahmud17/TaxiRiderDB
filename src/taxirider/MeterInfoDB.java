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
public class MeterInfoDB {
    private int tourID;
    private String driverID;
    private String carRegNo;
    private String generatedCode;
    private double tourDistance;
    private double idleTime;
    private double amount;
    private Timestamp endTime;

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
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

    public String getGeneratedCode() {
        return generatedCode;
    }

    public void setGeneratedCode(String generatedCode) {
        this.generatedCode = generatedCode;
    }

    public double getTourDistance() {
        return tourDistance;
    }

    public void setTourDistance(double tourDistance) {
        this.tourDistance = tourDistance;
    }

    public double getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(double idleTime) {
        this.idleTime = idleTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public MeterInfoDB(int tourID, String driverID, String carRegNo, String generatedCode, double tourDistance, double idleTime, double amount, Timestamp endTime) {
        this.tourID = tourID;
        this.driverID = driverID;
        this.carRegNo = carRegNo;
        this.generatedCode = generatedCode;
        this.tourDistance = tourDistance;
        this.idleTime = idleTime;
        this.amount = amount;
        this.endTime = endTime;
    }

    public MeterInfoDB() {
    }


}
