package com.company._4warsztat.resultSet;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String address = "jdbc:postgresql://localhost:5432/zajavka";
//        String address = "jdbc:postgresql://localhost:5432/zajavka"; <- baza do genereowania błedu SQLException e
        String dbUsername = "postgres";
        String dbPassword = "19Wend!88";

        String query = "SELECT * FROM CUSTOMER WHERE NAME LIKE ?;";
        String parametr = "%me%";

        try (
                Connection connection = DriverManager.getConnection(address, dbUsername, dbPassword);
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, parametr);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                List<Customer> customers = CustomerMapper.mapToCustomers(resultSet);
                customers.forEach(customer -> System.out.println("Customer: " + customer));
            }
        } catch (SQLException e) {
            System.err.printf("Error, sqlState: [%s], errorCode: [%s], message: [%s]%n",
                    e.getSQLState(),e.getErrorCode(),e.getMessage());
        }

    }
}
