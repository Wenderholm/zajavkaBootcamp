package com.company.wyjatkiTryCatch.exceptionRunTimeException;

public class Driver {
    private int age;

    public Driver(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
//    nie może być bardziej szczegołowo rzucany niż jest zadeklarownay w metodzie
//    mozemy zrobic throws DrivingException i throw new DrivingExeption
//    mozemy zrobic throws Exception i throw new DrivingExeption
    public void setAge(int age) throws Exception {
        if(age < 18){
            throw new DrivingToYoungException("You cannot drive below 18. Provided " + age + " years");
        }
        this.age = age;
    }

//    jezeli zamiast Exception wpiszemy RuntimeException to wtedy nie musimy rzucac wyjątku
//    bo jest to mniej rygorystyczne(nie sa sprawdzane na poziomie kompilaci czy zostały obsłuzone czy też nie)
//    niż Exception ktore musi byc obsłuzone
//    public void setAge(int age) throws RuntimeException {
//        if(age < 18){
//            throw new DrivingException("You cannot drive below 18");
//        }
//        this.age = age;
//    }
}
