package com.company._4warsztat.resultSet;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {
    public static List<Customer> mapToCustomers(ResultSet resultSet) {
        List<Customer> result = new ArrayList<>();
        try {
//            pobieranie danych az do ostatniego rekordu
            while (resultSet.next()) {
// nazwy kolumn musza sie zgadzać z tym co jest w bazie danych
                result.add(new Customer(
                        resultSet.getString("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        LocalDate.parse(resultSet.getString("date_of_birth")),
                        resultSet.getString("telephone_number")
                        ));

//                mozna pobrac dane z kolumn po ich id kolejno zaczynając od 1
//                result.add(new Customer(
//                        resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getString(5),
//                        resultSet.getDate(6).toLocalDate(),   <- inny sposob zapisu Daty
//                        resultSet.getString(7)
//                ));
            }
        } catch (Exception e) {
            System.err.println("Error while mapping resultSet to Customer list: " + e.getMessage());
        }
        return result;
    }
}
