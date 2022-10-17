package com.company.JavaAPI_Optional_stringBuilder.zadania.zadanie2;

public class RozwiazanieZajecia {
    public static void main(String[] args) {
        RozwiazanieZajecia rz = new RozwiazanieZajecia();
        rz.run();
    }

    private void run() {
        StringBuilder sb = new StringBuilder("hello world! java bootcamp is good");
        upperCaseMethod(sb);
        System.out.println("upperCase sentence " + sb);
    }

    private void upperCaseMethod(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
//            okreslenie pierwszego znaku
            char current = sb.charAt(i);
//          określenie znaku poprzedniego w przypadku kiedy jest to znak 0 to jest to
            char previous = i == 0 ? '.' : sb.charAt(i-1);
            if(Character.isLetter(current) && !Character.isLetter(previous)){
                char toUpperCase = Character.toUpperCase(current);
                sb.replace(i,i+1, String.valueOf(toUpperCase));

            }

        }

    }
}
