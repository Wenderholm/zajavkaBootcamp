package com.company._4warsztat.code;

import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String address = "jdbc:postgresql://localhost:5432/zajavka";
        String username = "postgres";
        String password = "19Wend!88";

        String query1 = "INSERT INTO PRODUCER (ID, PRODUCER_NAME, ADDRESS)"
               + "VALUES (4, 'Zajavka Group 4', 'Zajavkowa 15, Warszawa');";

        String query2 = "UPDATE PRODUCER SET ADDRESS = 'NOWY ADRES FIRMY' WHERE ID=1;";

        String query3 = "DELETE FROM PRODUCER WHERE ID = 2;";

        String query4 = "SELECT * FROM PRODUCER;";

//        I SPOSÓB Z EXECUTEUPDATE() - powinien być używany do insert, update, delete;
//        try(
//                Connection connection = DriverManager.getConnection(address, username, password);
//                Statement statement = connection.createStatement()
//                ) {
////            executeUpdate() -> wykonuje nam operacje i wypisuje int czyli cyfra ile wierszy zostało zmodyfikowanych
//            int i = statement.executeUpdate(query3);
//            System.out.println(i);
//        } catch (SQLException e) {
//            System.err.print("Exception: " + e.getMessage());
//        }
//

//        II SPOSÓB Z EXECUTEQUERY -  wykorzystywany powinien byc do odczywtywania danych
        try(
                Connection connection = DriverManager.getConnection(address, username, password);
                Statement statement = connection.createStatement();
//                to mozemy tu dodać poniewaz implementuje AutoCloseable
                ResultSet resultSet = statement.executeQuery(query4);
        ) {
            System.out.println(resultSet);
        } catch (SQLException e) {
            System.err.print("Exception: " + e.getMessage());
        }


    }
}
