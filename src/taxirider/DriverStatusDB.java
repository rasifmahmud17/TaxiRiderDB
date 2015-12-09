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
public class DriverStatusDB {
    private String driverID;
    private String carRegNo;
    private String driverLocation;
    private String driverStatus;
    private int tourID;
    private String userID;
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

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
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

    public DriverStatusDB() {
    }

    public DriverStatusDB(String driverID, String carRegNo, String driverLocation, String driverStatus, int tourID, String userID) {
        this.driverID = driverID;
        this.carRegNo = carRegNo;
        this.driverLocation = driverLocation;
        this.driverStatus = driverStatus;
        this.tourID = tourID;
        this.userID = userID;
    }

}
