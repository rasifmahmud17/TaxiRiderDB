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
    
    
    public void createUserStatus() {
        String sql = "CREATE TABLE IF NOT EXISTS USER_STATUS( "
                + "USER_ID VARCHAR(50) NOT NULL , "
                + "USER_LOCATION VARCHAR(50) , "
                + "USER_STATUS VARCHAR(50), "
                + "FINAL_DESTINATION VARCHAR(50), "
                + "DRIVER_ID VARCHAR(50) , "
                + "TOUR_ID VARCHAR(50), "
                + "PRIMARY KEY (USER_ID) ,"
                + "FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID)) ";
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
