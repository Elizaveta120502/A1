package com.A1.task3.presentation;

import com.A1.task3.database.ConnectionToDB;
import com.A1.task3.entity.Entity;
import com.A1.task3.logger.LoggerProvider;
import com.A1.task3.reader.ReadFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String [] args){
        try {
            List<Entity> newList = ReadFile.getInstance().
                    readFile("C:/A1/src/main/resources/logins.csv");
            LoggerProvider.getLOG().info(newList);
            ConnectionToDB.getInstance().
                    executionForLogins(newList, newList.size());
            newList = ReadFile.getInstance().
                    readFile("C:/A1/src/main/resources/postings.csv");
            ConnectionToDB.getInstance().
                    executionForPostings(newList, newList.size());
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
