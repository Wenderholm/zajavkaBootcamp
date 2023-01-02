package com.company._4warsztat.preparedStatement;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String address = "jdbc:postgresql://localhost:5432/zajavka";
        String dbUsername = "postgres";
        String dbPassword = "19Wend!88";

// usuniemy teraz użytkownika o nazwie ponizej ale mozemy go usunać dopiero jak usuniemy jego powiazanie
// w tabelach opinion oraz purchase. na koniec mozemy usunąć dopiero z customer
//        String username = "ntinner27";

//        SQL injection - nasza aplikacja nie jest zabepieczona przed wlamaniami np. jezeli wykonamy nasze zapytania
//        ponizej z takim użytkownikiem usuniemy wszystkie dane z naszych 3 tabel
//        String username = "whatever' or 1=1 or USER_NAME = 'whateverAgain";
//
//
//        String query1 = "DELETE FROM OPINION " +
//                "WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = '" + username + "');";
//        String query2 = "DELETE FROM PURCHASE " +
//                "WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = '" + username + "')";
//        String query3 = "DELETE FROM CUSTOMER WHERE USER_NAME = '" + username + "';";
//        try(
//                Connection connection = DriverManager.getConnection(address, username, dbPassword);
//                Statement statement = connection.createStatement();
//        ) {
//            int count1 = statement.executeUpdate(query1);
//            int count2 = statement.executeUpdate(query2);
//            int count3 = statement.executeUpdate(query3);
//
//            System.out.println("Changed: " + count1 + " rows");
//            System.out.println("Changed: " + count2 + " rows");
//            System.out.println("Changed: " + count3 + " rows");
//
//        } catch (SQLException e) {
//            System.err.print("Exception: " + e.getMessage());
//        }
//


//        inny sposób konkatenacji danych aby unikac sqlinjection to wykorzytsanie PREPAREDSTAEMEND

        String username = "ntinner27";
//        String username = "whatever' or 1=1 or USER_NAME = 'whateverAgain";

        String query1 = "DELETE FROM OPINION " +
                "WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = ?);";
        String query2 = "DELETE FROM PURCHASE " +
                "WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = ?);";
        String query3 = "DELETE FROM CUSTOMER WHERE USER_NAME = ?;";
        try (
                Connection connection = DriverManager.getConnection(address, dbUsername, dbPassword);
                PreparedStatement statement1 = connection.prepareStatement(query1);
                PreparedStatement statement2 = connection.prepareStatement(query2);
                PreparedStatement statement3 = connection.prepareStatement(query3);
        ) {
//            1 w setString oznacza wstawienie username na pozycji 1 czyli tam gdzie jest pierwszy ? w query1
            statement1.setString(1,username);
            statement2.setString(1,username);
            statement3.setString(1,username);

            int count1 = statement1.executeUpdate();
            int count2 = statement2.executeUpdate();
            int count3 = statement3.executeUpdate();

            System.out.println("Changed: " + count1 + " rows");
            System.out.println("Changed: " + count2 + " rows");
            System.out.println("Changed: " + count3 + " rows");

        } catch (SQLException e) {
            System.err.print("Exception: " + e.getMessage());
        }


    }
}
