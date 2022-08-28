package com.company.objectProgram.overriding;

public class SubClass extends SuperClass{

//    w tym przypadku nadpisywanie metody domyślnej z SuperClass dopuszczalne jest z modyfikatorami default, protected oraz public
//    @Override
//    String defaultMethod(){
//        return "SubClass defaultMethod";
//    }

//    w tym przypadku nadpisywanie metody protected z SuperClass dopuszczalne jest z modyfikatorami protected oraz public
//    domyślny nie zadziala bo nie może klasa dziedzicząca zaweżac dostępu
//    @Override
//    protected String protectedMethod(){
//        return "SubClass protectedMethod";
//    }


//    w tym przypadku nadpisywanie metody public z SuperClass musi być tylko z modyfikatorem public
//    domyślny oraz protected nie zadziala bo nie może klasa dziedzicząca zaweżac dostępu
//    @Override
//    public String publicMethod(){
//        return "SubClass publicMethod";
//    }

//    metody wypisane jako
// super - wywowałnie metody z klasy nadrzędnej

    @Override
    String defaultMethod() {
        return super.defaultMethod();
    }

    @Override
    protected String protectedMethod() {
        return super.protectedMethod();
    }

    @Override
    public String publicMethod() {
        return super.publicMethod();
    }
}
