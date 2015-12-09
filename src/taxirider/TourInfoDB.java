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
public class TourInfoDB {
    private int tourID;
    private String userID;
    private String driverID;
    private String carRegNo;
    private Timestamp startTime;
    private String finalDestination;
    private String pickUpPoint;

    public TourInfoDB() {
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(String finalDestination) {
        this.finalDestination = finalDestination;
    }

    public String getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public TourInfoDB(int tourID, String userID, String driverID, String carRegNo, Timestamp startTime, String finalDestination, String pickUpPoint) {
        this.tourID = tourID;
        this.userID = userID;
        this.driverID = driverID;
        this.carRegNo = carRegNo;
        this.startTime = startTime;
        this.finalDestination = finalDestination;
        this.pickUpPoint = pickUpPoint;
    }
}
