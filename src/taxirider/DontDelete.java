/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author razon
 */
public class DontDelete {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private PreparedStatement preparedStatement;

    public DontDelete() {

    }

    public void connectDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxidatabase", "root", "123456");

            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("database connected_razon");
    }

    public void closeDatabase() {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            System.out.println("database closed_razon");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void createUserInfo() {
        String sql = "CREATE TABLE IF NOT EXISTS USER_INFO "
                + "(USER_ID VARCHAR(50) PRIMARY KEY NOT NULL ," //101
                + " EMAIL VARCHAR(50) UNIQUE NOT NULL , "
                + " NAME VARCHAR(50) NOT NULL , "
                + " PASSWORD VARCHAR(50) NOT NULL , "
                + " MOBILE_NO VARCHAR(50) UNIQUE NOT NULL , "
                + " LANGUAGE VARCHAR(50) , "
                + " CREDIT_CARD_NO VARCHAR(50) NOT NULL , "
                + " CVV VARCHAR(50) NOT NULL , "
                + " EXPIRATION_DATE DATETIME NOT NULL , "
                + " ADDRESS VARCHAR(255) NOT NULL, "
                + " USER_VERIFICATION VARCHAR(50) ) ";
        update(sql);

    }

    public void insertUserInfo(UserInfoDB ob) {
        String sql = "INSERT INTO USER_INFO ("
                + "USER_ID, "
                + "EMAIL, "
                + "NAME, "
                + "PASSWORD, "
                + "MOBILE_NO, "
                + "LANGUAGE, "
                + "CREDIT_CARD_NO, "
                + "CVV, "
                + "EXPIRATION_DATE, "
                + "ADDRESS)"
                + " VALUES('" + ob.getUserID() + "','" + ob.getEmail() + "','" + ob.getName() + "','" + ob.getPassword() + "','"
                + ob.getMobileNo() + "','" + ob.getLanguage() + "','" + ob.getCreditCardNo() + "','" + ob.getCvv() + "','" + ob.getExpirationDate() + "','" + ob.getPostalCode() + "');";
        update(sql);
    }

    public ObservableList<UserInfoDB> getUserInfo(String sql) {                //103
        ObservableList<UserInfoDB> row = FXCollections.observableArrayList();
        try {
            resultSet = statement.executeQuery(sql);
            metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                UserInfoDB ob = new UserInfoDB(
                        resultSet.getString("USER_ID"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("NAME"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("MOBILE_NO"),
                        resultSet.getString("LANGUAGE"),
                        resultSet.getString("CREDIT_CARD_NO"),
                        resultSet.getString("CVV"),
                        resultSet.getTimestamp("EXPIRATION_DATE"),
                        resultSet.getString("ADDRESS")
                );
                row.addAll(ob);
            }

        } catch (Exception e) {

        }
        return row;

    }

    public void createDriverInfo() {
        String sql = "CREATE TABLE IF NOT EXISTS DRIVER_INFO "
                + "(DRIVER_ID VARCHAR(50) NOT NULL ,"
                + "CAR_REG_NO VARCHAR(50) NOT NULL ,"
                + " EMAIL VARCHAR(50) NOT NULL , "
                + " NAME VARCHAR(50) NOT NULL , "
                + " PASSWORD VARCHAR(50) NOT NULL , "
                + " MOBILE_NO VARCHAR(50) NOT NULL , "
                + " LANGUAGE VARCHAR(50) , "
                + " CREDIT_CARD_NO VARCHAR(50) NOT NULL , "
                + " CVV VARCHAR(50) NOT NULL , "
                + " EXPIRATION_DATE DATETIME NOT NULL , "
                + " ADDRESS VARCHAR(255) NOT NULL, "
                + " DRIVING_LICENSE VARCHAR(255) NOT NULL, "
                + " CAR_MODEL VARCHAR(50),"
                + " PRIMARY KEY (DRIVER_ID , CAR_REG_NO ) ) ";
        update(sql);

    }

    public void insertDriverInfo(DriverInfoDB ob) {
        String sql = "INSERT INTO DRIVER_INFO "
                + "VALUES('" + ob.getDriverID() + "','" + ob.getCarRegNo() + "','" + ob.getEmail() + "','" + ob.getName() + "','" + ob.getPassword() + "','"
                + ob.getMobileNo() + "','" + ob.getLanguage() + "','" + ob.getCreditCardNo() + "','" + ob.getCvv() + "','" + ob.getExpirationDate() + "','" + ob.getAddress() + "','" + ob.getDrivingLicense() + "','" + ob.getCarModel() + "');";
        update(sql);
    }

    public void createTourInfo() {
        String sql = "CREATE TABLE IF NOT EXISTS TOUR_INFO "
                + "(TOUR_ID INT NOT NULL AUTO_INCREMENT,"
                + "USER_ID VARCHAR(50) NOT NULL ,"
                + "DRIVER_ID VARCHAR(50) NOT NULL ,"
                + "CAR_REG_NO VARCHAR(50) NOT NULL ,"
                + "START_TIME DATETIME NOT NULL , "
                + "FINAL_DESTINATION VARCHAR(50) , "
                + "PICK_UP_POINT VARCHAR(50) NOT NULL , "
                + "PRIMARY KEY (TOUR_ID ),"
                + "FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID) ON DELETE CASCADE ON UPDATE CASCADE ,"
                + "FOREIGN KEY ( DRIVER_ID, CAR_REG_NO) REFERENCES DRIVER_INFO( DRIVER_ID , CAR_REG_NO ) ON DELETE CASCADE ON UPDATE CASCADE) ";
        update(sql);

    }

    public void insertTourInfo(TourInfoDB ob) {
        String sql = "INSERT INTO TOUR_INFO ("
                + "USER_ID, "
                + "DRIVER_ID, "
                + "CAR_REG_NO, "
                + "START_TIME, "
                + "FINAL_DESTINATION, "
                + "PICK_UP_POINT)"
                + " VALUES('" + ob.getUserID() + "','" + ob.getDriverID() + "','" + ob.getCarRegNo() + "','" + ob.getStartTime() + "','" + ob.getFinalDestination() + "','" + ob.getPickUpPoint() + "');";
        update(sql);
    }

    public void createDriverStatus() {
        String sql = "CREATE TABLE IF NOT EXISTS DRIVER_STATUS( "
                + "DRIVER_ID VARCHAR(50) NOT NULL , "
                + "CAR_REG_NO VARCHAR(50) , "
                + "DRIVER_LOCATION VARCHAR(50) , "
                + "DRIVER_STATUS VARCHAR(50), "
                + "TOUR_ID INT, "
                + "USER_ID VARCHAR(50), "
                + "PRIMARY KEY (DRIVER_ID,CAR_REG_NO) ,"
                + "FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID) ON DELETE SET NULL ON UPDATE CASCADE ,"
                + "FOREIGN KEY ( DRIVER_ID, CAR_REG_NO) REFERENCES DRIVER_INFO( DRIVER_ID , CAR_REG_NO ) ON DELETE CASCADE ON UPDATE CASCADE,"
                + "FOREIGN KEY (TOUR_ID) REFERENCES TOUR_INFO(TOUR_ID) ON DELETE SET NULL ON UPDATE CASCADE )  ";
        update(sql);

    }

    public void insertDriverStatus(DriverStatusDB ob) {
        String sql = "INSERT INTO DRIVER_STATUS ("
                + "DRIVER_ID, "
                + "CAR_REG_NO, "
                + "DRIVER_LOCATION, "
                + "DRIVER_STATUS)"
                + " VALUES('" + ob.getDriverID() + "','" + ob.getCarRegNo() + "','" + ob.getDriverLocation() + "','" + ob.getDriverStatus() + "');";
        update(sql);
    }

    public void createUserStatus() {
        String sql = "CREATE TABLE IF NOT EXISTS USER_STATUS( "
                + "USER_ID VARCHAR(50) NOT NULL , "
                + "USER_LOCATION VARCHAR(50) , "
                + "USER_STATUS VARCHAR(50), "
                + "FINAL_DESTINATION VARCHAR(50), "
                + "DRIVER_ID VARCHAR(50) , "
                + "CAR_REG_NO VARCHAR(50) , "
                + "TOUR_ID INT, "
                + "PRIMARY KEY (USER_ID) ,"
                + "FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID) ON DELETE CASCADE ON UPDATE CASCADE ,"
                + "FOREIGN KEY ( DRIVER_ID, CAR_REG_NO) REFERENCES DRIVER_INFO( DRIVER_ID , CAR_REG_NO ) ON DELETE SET NULL ON UPDATE CASCADE,"
                + "FOREIGN KEY (TOUR_ID) REFERENCES TOUR_INFO(TOUR_ID) ON DELETE SET NULL ON UPDATE CASCADE )  ";
        update(sql);

    }

    public void insertUserStatus(UserStatusDB ob) {
        String sql = "INSERT INTO USER_STATUS ("
                + "USER_ID, "
                + "USER_LOCATION, "
                + "USER_STATUS)"
                + " VALUES('" + ob.getUserID() + "','" + ob.getUserLocation() + "','" + ob.getUserStatus() + "');";
        update(sql);
    }

    public ObservableList<UserStatusDB> getUserStatus(String sql) {                //103
        ObservableList<UserStatusDB> row = FXCollections.observableArrayList();
        try {
            resultSet = statement.executeQuery(sql);
            metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                UserStatusDB ob = new UserStatusDB(
                        resultSet.getString("USER_ID"),
                        resultSet.getString("USER_LOCATION"),
                        resultSet.getString("USER_STATUS"),
                        resultSet.getString("FINAL_DESTINATION"),
                        resultSet.getString("DRIVER_ID"),
                        resultSet.getInt("TOUR_ID")
                );
                row.addAll(ob);
            }

        } catch (Exception e) {

        }
        return row;

    }

    public void createMeterInfo() {
        String sql = "CREATE TABLE IF NOT EXISTS METER_INFO( "
                + "TOUR_ID INT NOT NULL , "
                + "DRIVER_ID VARCHAR(50) NOT NULL, "
                + "CAR_REG_NO VARCHAR(50) NOT NULL , "
                + "GENERATED_CODE VARCHAR(50) NOT NULL, "
                + "TOUR_DISTANCE DOUBLE NOT NULL, "
                + "IDLE_TIME DOUBLE NOT NULL, "
                + "AMOUNT DOUBLE NOT NULL, "
                + "END_TIME DATETIME NOT NULL, "
                + "PRIMARY KEY (TOUR_ID) ,"
                + "FOREIGN KEY (TOUR_ID) REFERENCES TOUR_INFO(TOUR_ID) ON DELETE CASCADE ON UPDATE CASCADE )";
        update(sql);

    }
    public void insertMeterInfo(MeterInfoDB ob) {
        String sql = "INSERT INTO METER_INFO "
                + "VALUES('" + ob.getTourID() + "','" + ob.getDriverID() + "','" + ob.getCarRegNo() + "','" + ob.getGeneratedCode() + "',"
                + ob.getTourDistance()+ "," + ob.getIdleTime() + "," + ob.getAmount() + ",'" + ob.getEndTime() + "');";
        update(sql);
    }


    public void createTourPayment() {
        String sql = "CREATE TABLE IF NOT EXISTS TOUR_PAYMENT( "
                + "TOUR_ID INT NOT NULL , "
                + "USER_ID VARCHAR(50) NOT NULL, "
                + "GENERATED_CODE VARCHAR(50) NOT NULL, "
                + "PAYMENT_TYPE VARCHAR(50) NOT NULL, "
                + "AMOUNT DOUBLE NOT NULL, "
                + "PRIMARY KEY (TOUR_ID) ,"
                + "FOREIGN KEY (TOUR_ID) REFERENCES TOUR_INFO(TOUR_ID) ON DELETE CASCADE ON UPDATE CASCADE )";
        update(sql);

    }

    public void update(String sql) {
        //connectDatabase();

        try {
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DontDelete.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        //closeDatabase();

    }

}
