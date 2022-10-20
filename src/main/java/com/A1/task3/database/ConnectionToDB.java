package com.A1.task3.database;

import com.A1.task3.entity.Entity;
import com.A1.task3.entity.LoginEntity;
import com.A1.task3.entity.PostingEntity;
import com.A1.task3.logger.LoggerProvider;

import java.sql.*;
import java.util.List;

public class ConnectionToDB<T extends Entity> {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/a1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static final String HIGH_COMMA = "\'";
    private static final String COMMA = ",";


    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ConnectionToDB instance;

    public static ConnectionToDB getInstance() {
        if (instance == null) {
            instance = new ConnectionToDB();
        }
        return instance;
    }


    public boolean executionForLogins(List<LoginEntity> elementArray, int numberOfRecords) throws SQLException {
        openConnection();
        int i = 0;
        int numberOfColumns = 5;


        try {
            for (int j = 0; j < elementArray.size(); j ++) {
                String query = "insert into logins (id,application,app_account_name,is_active,job_title,department)" +
                        "values(" + ++i + "," + HIGH_COMMA + elementArray.get(j).getApplication() + HIGH_COMMA + "," + HIGH_COMMA +
                        elementArray.get(j).getAppAccountName() + HIGH_COMMA + ","
                        + Boolean.parseBoolean(String.valueOf
                        (elementArray.get(j).getIsActive())) + "," + HIGH_COMMA + elementArray.get(j).getJobTitle()
                        + HIGH_COMMA + "," + HIGH_COMMA + elementArray.get(j).getDepartment() + HIGH_COMMA + ");";

                LoggerProvider.getLOG().debug(query);
                statement.executeUpdate(query);
            }
        } finally {
            closeResources();
        }

        return true;
    }

    public boolean executionForPostings(List<PostingEntity> elementArray, int numberOfRecords) throws SQLException {
        openConnection();
        int i = 0;
        int numberOfColumns = 10;


        try {
            for (int j = 0; j < elementArray.size(); j ++) {
                String query = "insert into postings (Mat_Doc, item, docDate, pstngDate, materialDescription, quantity, BUn, amountLC, crcy, userName, logins_id)" +
                        "values("+ ++i + elementArray.get(j).getMatDoc() + COMMA +
                        elementArray.get(j).getItem() + COMMA +
                        HIGH_COMMA + elementArray.get(j).getDocDate() + HIGH_COMMA + COMMA +
                        HIGH_COMMA + elementArray.get(j).getPstngDate() + HIGH_COMMA + COMMA+
                        HIGH_COMMA + elementArray.get(j).getMaterialDescription() + HIGH_COMMA + COMMA+
                        elementArray.get(j).getQuantity() + COMMA +
                        HIGH_COMMA + elementArray.get(j).getBUn() + HIGH_COMMA + COMMA+
                        elementArray.get(j).getAmountLC() + COMMA +
                        HIGH_COMMA + elementArray.get(j).getCrcy() + HIGH_COMMA + COMMA+
                        HIGH_COMMA + elementArray.get(j).getUserName() + HIGH_COMMA  + COMMA + "null" +");";

                LoggerProvider.getLOG().debug(query);
                statement.executeUpdate(query);
            }
        } finally {
            closeResources();
        }

        return true;
    }


    private static void openConnection() {
        try {
            // opening database connection to MySQL server
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // getting Statement object to execute query
            statement = connection.createStatement();
        } catch (SQLException e) {
            LoggerProvider.getLOG().error("IOException occurred");
        }
    }

    private boolean closeResources() {
        try {
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
            LoggerProvider.getLOG().error("SQLException occurred");
            return false;
        }
        try {
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
            LoggerProvider.getLOG().error("SQLException occurred");
            return false;
        }
        return true;
    }
}

