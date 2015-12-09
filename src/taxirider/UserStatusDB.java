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
public class UserStatusDB {
    private String userID;
    private String userLocation;
    private String userStatus;
    private String finalDestination;
    private String driverID;
    private int tourID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(String finalDestination) {
        this.finalDestination = finalDestination;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public UserStatusDB(String userID, String userLocation, String userStatus, String finalDestination, String driverID, int tourID) {
        this.userID = userID;
        this.userLocation = userLocation;
        this.userStatus = userStatus;
        this.finalDestination = finalDestination;
        this.driverID = driverID;
        this.tourID = tourID;
    }

    public UserStatusDB(String userID, String userLocation, String userStatus) {
        this.userID = userID;
        this.userLocation = userLocation;
        this.userStatus = userStatus;
    }

    public UserStatusDB() {
    }
}
