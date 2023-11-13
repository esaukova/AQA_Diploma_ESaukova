package ru.netology.data;

import lombok.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    public SQLHelper() {
    }

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(System.getProperty("db.url"), "app", "pass");
    }

    @SneakyThrows
    public static String getStatusCreditRequestEntity() {
        try (val conn = getConnection();
             val countStmt = conn.createStatement()) {
            val sql = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
            val resultSet = countStmt.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("status");
            }
        }
        return null;
    }

    @SneakyThrows
    public static String getStatusPaymentEntity() {
        try (val conn = getConnection();
             val countStmt = conn.createStatement()) {
            val sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
            val resultSet = countStmt.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("status");
            }
        }
        return null;
    }

    @SneakyThrows
    public static void cleanDB() {
        var connection = getConnection();
        runner.update(connection, "DELETE FROM credit_request_entity");
        runner.update(connection, "DELETE FROM order_entity");
        runner.update(connection, "DELETE FROM payment_entity");
    }


}