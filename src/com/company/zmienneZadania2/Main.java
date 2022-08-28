package com.company.zmienneZadania2;

public class Main {
    public static void main(String[] args) {
//        zadanie 1  zliczanie znaków
        String text = "Something text";
        int txtLength = text.length();
        System.out.println(txtLength);

//       zadanie 2  sklejanie tekstu na rózne sposoby
        String s1 = "text1";
        String s2 = "text2";
        String s3 = "text3";
        String s4 = "text4";
        String s5 = "text5";

        String longText = s1 + s2 + s3 + s4 + s5;
        String longText2 = s1.concat(s2).concat(s3).concat(s4).concat(s5);
        String longText3 = String.format(" %s %s %s %s %s", s1,s2,s3,s4,s5);

        System.out.println(longText);
        System.out.println(longText2);
        System.out.println(longText3);

//        zadanie 3 podmiana znaków
        String a = "a";
        String x = "x";
        String exampleText = "Zdanie do zmaiany: Zajavka";

        String changedText = exampleText.replaceAll(a,x);
        System.out.println(changedText);

//        zadanie 4 sprawdzenie czy jest słowo
        boolean checkedWord = exampleText.contains("do");
        System.out.println(checkedWord);

//        zadanie 5 porównanie
        String textOne = "Java";
        String textTwo = "jAvA";
        System.out.println(textOne.equalsIgnoreCase(textTwo));

//        zadanie 6 wycinanie znaków
        String veryLongText = "SomeStringLongerThan10Signs";
        System.out.println(veryLongText.substring(3,8));


    }
}
