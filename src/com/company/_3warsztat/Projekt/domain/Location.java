package com.company._3warsztat.Projekt.domain;

public class Location {
       private String country;
       private String city;

       public Location(String country, String city) {
              this.country = country;
              this.city = city;
       }

       @Override
       public String toString() {
              return "Location{" +
                      "country='" + country + '\'' +
                      ", city='" + city + '\'' +
                      '}';
       }

       public String getCountry() {
              return country;
       }

       public String getCity() {
              return city;
       }
}
