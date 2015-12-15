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
    private String sampleUpdateSql = "update CUSTOMER_LIST set TOTAL_ORDER = TOTAL_ORDER + ? , BALANCE_ORDER = BALANCE_ORDER + ? where CUSTOMER = ? AND INSTITUTE = ?";

    public DontDelete() {

    }

    public void connectDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxidatabase", "root", "nt");

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

    // TABLE 1 CREATE
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

    // TABLE 1 INSERT
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

    // TABLE 1 GET
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

    //TABLE 2 CREATE
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

    //TABLE 2 INSERT
    public void insertDriverInfo(DriverInfoDB ob) {
        String sql = "INSERT INTO DRIVER_INFO "
                + "VALUES('" + ob.getDriverID() + "','" + ob.getCarRegNo() + "','" + ob.getEmail() + "','" + ob.getName() + "','" + ob.getPassword() + "','"
                + ob.getMobileNo() + "','" + ob.getLanguage() + "','" + ob.getCreditCardNo() + "','" + ob.getCvv() + "','" + ob.getExpirationDate() + "','" + ob.getAddress() + "','" + ob.getDrivingLicense() + "','" + ob.getCarModel() + "');";
        update(sql);
    }

    //TABLE 2 GET
    public ObservableList<DriverInfoDB> getDriverInfo(String sql) {                //103
        ObservableList<DriverInfoDB> row = FXCollections.observableArrayList();
        try {
            resultSet = statement.executeQuery(sql);
            metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                DriverInfoDB ob = new DriverInfoDB(
                        resultSet.getString("DRIVER_ID"),
                        resultSet.getString("CAR_REG_NO"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("NAME"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("MOBILE_NO"),
                        resultSet.getString("LANGUAGE"),
                        resultSet.getString("CREDIT_CARD_NO"),
                        resultSet.getString("CVV"),
                        resultSet.getTimestamp("EXPIRATION_DATE"),
                        resultSet.getString("ADDRESS"),
                        resultSet.getString("DRIVING_LICENSE"),
                        resultSet.getString("CAR_MODEL")
                );
                row.addAll(ob);
            }

        } catch (Exception e) {

        }
        return row;

    }

    //TABLE 3 CREATE
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

    //TABLE 3 INSERT
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

    //TABLE 3 GET
    public ObservableList<TourInfoDB> getTourInfo(String sql) {                //103
        ObservableList<TourInfoDB> row = FXCollections.observableArrayList();
        try {
            resultSet = statement.executeQuery(sql);
            metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                TourInfoDB ob = new TourInfoDB(
                        resultSet.getInt("TOUR_ID"),
                        resultSet.getString("USER_ID"),
                        resultSet.getString("DRIVER_ID"),
                        resultSet.getString("CAR_REG_NO"),
                        resultSet.getTimestamp("START_TIME"),
                        resultSet.getString("FINAL_DESTINATION"),
                        resultSet.getString("PICK_UP_POINT")
                );
                row.addAll(ob);
            }

        } catch (Exception e) {

        }
        return row;

    }

    //TABLE 4 CREATe
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

    //TABLE 4 INSERT
    public void insertDriverStatus(DriverStatusDB ob) {
        String sql = "INSERT INTO DRIVER_STATUS ("
                + "DRIVER_ID, "
                + "CAR_REG_NO, "
                + "DRIVER_LOCATION, "
                + "DRIVER_STATUS)"
                + " VALUES('" + ob.getDriverID() + "','" + ob.getCarRegNo() + "','" + ob.getDriverLocation() + "','" + ob.getDriverStatus() + "');";
        update(sql);
    }

    //TABLE 4 GET
    public ObservableList<DriverStatusDB> getDriverStatus(String sql) {                //103
        ObservableList<DriverStatusDB> row = FXCollections.observableArrayList();
        try {
            resultSet = statement.executeQuery(sql);
            metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                DriverStatusDB ob = new DriverStatusDB(
                        resultSet.getString("DRIVER_ID"),
                        resultSet.getString("CAR_REG_NO"),
                        resultSet.getString("DRIVER_LOCATION"),
                        resultSet.getString("DRIVER_STATUS"),
                        resultSet.getInt("TOUR_ID"),
                        resultSet.getString("USER_ID")
                );
                row.addAll(ob);
            }

        } catch (Exception e) {

        }
        return row;

    }

    //TABLE 5 CREATE
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

    //TABLE 5 INSERT
    public void insertUserStatus(UserStatusDB ob) {
        String sql = "INSERT INTO USER_STATUS ("
                + "USER_ID, "
                + "USER_LOCATION, "
                + "USER_STATUS)"
                + " VALUES('" + ob.getUserID() + "','" + ob.getUserLocation() + "','" + ob.getUserStatus() + "');";
        update(sql);
    }

    //TABLE 5 GET
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

    //TABLE 6 CREATE
    public void createMeterInfo() {
        String sql = "CREATE TABLE IF NOT EXISTS METER_INFO( "
                + "TOUR_ID INT NOT NULL , "
                + "DRIVER_ID VARCHAR(50) NOT NULL, "
                + "CAR_REG_NO VARCHAR(50) NOT NULL , "
                + "GENERATED_CODE VARCHAR(50) , "
                + "TOUR_DISTANCE DOUBLE NOT NULL, "
                + "IDLE_TIME DOUBLE NOT NULL, "
                + "AMOUNT DOUBLE NOT NULL, "
                + "END_TIME DATETIME NOT NULL, "
                + "PRIMARY KEY (TOUR_ID) ,"
                + "FOREIGN KEY (TOUR_ID) REFERENCES TOUR_INFO(TOUR_ID) ON DELETE CASCADE ON UPDATE CASCADE )";
        update(sql);

    }

    //TABLE 6 INSERT
    public void insertMeterInfo(MeterInfoDB ob) {
        String sql = "INSERT INTO METER_INFO "
                + "VALUES(" + ob.getTourID() + ",'" + ob.getDriverID() + "','" + ob.getCarRegNo() + "','" + ob.getGeneratedCode() + "',"
                + ob.getTourDistance() + "," + ob.getIdleTime() + "," + ob.getAmount() + ",'" + ob.getEndTime() + "');";
        update(sql);
    }

    //TABLE 6 GET
    public ObservableList<MeterInfoDB> getMeterInfo(String sql) {                //103
        ObservableList<MeterInfoDB> row = FXCollections.observableArrayList();
        try {
            resultSet = statement.executeQuery(sql);
            metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                MeterInfoDB ob = new MeterInfoDB(
                        resultSet.getInt("TOUR_ID"),
                        resultSet.getString("DRIVER_ID"),
                        resultSet.getString("CAR_REG_NO"),
                        resultSet.getString("GENERATED_CODE"),
                        resultSet.getDouble("TOUR_DISTANCE"),
                        resultSet.getDouble("IDLE_TIME"),
                        resultSet.getDouble("AMOUNT"),
                        resultSet.getTimestamp("END_TIME")
                );
                row.addAll(ob);
            }

        } catch (Exception e) {

        }
        return row;

    }

    //TABLE 7 CREATE
    public void createTourPayment() {
        String sql = "CREATE TABLE IF NOT EXISTS TOUR_PAYMENT( "
                + "TOUR_ID INT NOT NULL , "
                + "USER_ID VARCHAR(50) NOT NULL, "
                + "GENERATED_CODE VARCHAR(50), "
                + "PAYMENT_TYPE VARCHAR(50) NOT NULL, "
                + "AMOUNT DOUBLE NOT NULL, "
                + "PRIMARY KEY (TOUR_ID) ,"
                + "FOREIGN KEY (TOUR_ID) REFERENCES TOUR_INFO(TOUR_ID) ON DELETE CASCADE ON UPDATE CASCADE )";
        update(sql);

    }

    //TABLE 7 INSERT
    public void insertTourPayment(TourPaymentDB ob) {
        String sql = "INSERT INTO TOUR_PAYMENT "
                + "VALUES(" + ob.getTourID() + ",'" + ob.getUserID() + "','" + ob.getGeneratedCode() + "','" + ob.getPaymentType() + "'," + ob.getAmount() + ");";
        update(sql);
    }

    //TABLE 7 GET
    public ObservableList<TourPaymentDB> getTourPayment(String sql) {                //103
        ObservableList<TourPaymentDB> row = FXCollections.observableArrayList();
        try {
            resultSet = statement.executeQuery(sql);
            metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                TourPaymentDB ob = new TourPaymentDB(
                        resultSet.getInt("TOUR_ID"),
                        resultSet.getString("USER_ID"),
                        resultSet.getString("GENERATED_CODE"),
                        resultSet.getString("PAYMENT_TYPE"),
                        resultSet.getDouble("AMOUNT")
                );
                row.addAll(ob);
            }

        } catch (Exception e) {

        }
        return row;

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

    public void update3StringDB(String sql, String input1, String input2, String input3, String key) throws SQLException {

        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, input1);
            preparedStmt.setString(2, input2);
            preparedStmt.setString(3, input3);
            preparedStmt.setString(4, key);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void update3StringDB(String sql, String input1, int input2, String input3, String key1, String key2) {
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, input1);
            preparedStmt.setInt(2, input2);
            preparedStmt.setString(3, input3);
            preparedStmt.setString(4, key1);
            preparedStmt.setString(5, key2);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void update2StringDB(String sql, String input1, String input2, String key1, String key2) throws SQLException {

        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, input1);
            preparedStmt.setString(2, input2);
            preparedStmt.setString(3, key1);
            preparedStmt.setString(4, key2);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void update4StringDB(String sql, String input1, String input2, String input3, int input4, String key) throws SQLException {

        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, input1);
            preparedStmt.setString(2, input2);
            preparedStmt.setString(3, input3);
            preparedStmt.setInt(4, input4);
            preparedStmt.setString(5, key);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void updateUserSearchTaxi(String input1, String input2, String input3, String key) throws SQLException {
        String sql = "update USER_STATUS set USER_LOCATION =  ? , USER_STATUS =  ? , FINAL_DESTINATION = ? where USER_ID = ? ";
        update3StringDB(sql, input1, input2, input3, key);

    }

    public void updateUserGotTaxi(String input1, String input2, String input3, int input4, String key) throws SQLException {
        String sql = "update USER_STATUS set USER_STATUS =  ? , DRIVER_ID = ? , CAR_REG_NO = ? , TOUR_ID = ?  where USER_ID = ? ";
        update4StringDB(sql, input1, input2, input3, input4, key);

    }

    public void updateTaxiSearchUser(String input1, String input2, String key1, String key2) throws SQLException {
        String sql = "update DRIVER_STATUS set DRIVER_STATUS = ? , DRIVER_LOCATION = ? where DRIVER_ID = ? AND CAR_REG_NO = ? ";
        update2StringDB(sql, input1, input2, key1, key2);

    }

    public void updateTaxiGotUser(String input1, int input2, String input3, String key1, String key2) {
        String sql = "update DRIVER_STATUS set DRIVER_STATUS = ? , TOUR_ID = ? , USER_ID = ? where DRIVER_ID = ? AND CAR_REG_NO = ? ";
        update3StringDB(sql, input1, input2, input3, key1, key2);

    }

}
