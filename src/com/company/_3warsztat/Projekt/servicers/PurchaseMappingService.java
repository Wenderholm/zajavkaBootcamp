package com.company._3warsztat.Projekt.servicers;

import com.company._3warsztat.Projekt.domain.Car;
import com.company._3warsztat.Projekt.domain.Location;
import com.company._3warsztat.Projekt.domain.Person;
import com.company._3warsztat.Projekt.domain.Purchase;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseMappingService {

    //    id,first_name,last_name,email,ip_address,color,car_vin,car_company,car_model,car_model_year,car_price,country,city,date
//    1,Marsh,Polon,mpolon0@google.de,155.43.28.214,#255a97,3D7TT2HT8BG370793,Chevrolet,Cobalt,2006,"€67487.58",Czech Republic,Bořetice,2020-09-03
    public static Purchase mapPurchase(String inputData) {
//        podzielony rzad po przecinku
        String[] row = inputData.split(",");
        long id = Long.parseLong(row[0]);
        String firstName = row[1];
        String lastName = row[2];
        String email = row[3];
        String ipAddress = row[4];
        String color = row[5];
        String vin = row[6];
        String company = row[7];
        String model = row[8];
        String model_year = row[9];
//        pomijamy pierwszy znak poniewaz jest to jakas waluta "€67487.58"
//        usunięcie znakow " i wstawienie pustych znaków
        BigDecimal price = new BigDecimal(row[10].replace("\"", "").substring(1));
        String country = row[11];
        String city = row[12];
        LocalDate date = LocalDate.parse(row[13]);

        return new Purchase(id,
                new Person(firstName, lastName, email, ipAddress)
                 , new Car(color, vin, company, model, model_year, price)
                , new Location(country, city),
                date);
    }

//    zapisanie danych jako CSV z purchase
    public static String toCsvRow(Purchase purchase) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                purchase.getId() ,
                purchase.getPerson().getFirstName(),
                purchase.getPerson().getLastName(),
                purchase.getPerson().getEmail(),
                purchase.getPerson().getIpAddress(),
                purchase.getCar().getColor(),
                purchase.getCar().getVin(),
                purchase.getCar().getCompany(),
                purchase.getCar().getModel(),
                purchase.getCar().getModel_year(),
                purchase.getCar().getPrice(),
                purchase.getLocation().getCountry(),
                purchase.getLocation().getCity(),
                purchase.getDate()
        );
    }



}

