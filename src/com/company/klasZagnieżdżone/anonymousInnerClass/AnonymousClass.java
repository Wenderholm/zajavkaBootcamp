package com.company.klasZagnieżdżone.anonymousInnerClass;

public class AnonymousClass {
    public static void main(String[] args) {
        AnonymousClass anonymousClass = new AnonymousClass();
        System.out.println(anonymousClass.callInnerInterface());
        System.out.println(anonymousClass.callAbstractClass());
    }

    private String callAbstractClass() {
//        klasa anonimowa
        Animal animal = new Animal() {
            @Override
            String whatsYourName() {
                return "My name is abstract class";
            }
        };
        return animal.whatsYourName();

    }

    private String callInnerInterface() {
//        KLASA ANONIMOWA
//        Singable singable = new Singable() {
//            @Override
//            public String singASong(String songName) {
//                return "I'm singing: " + songName;
//            }
//        };

//      KLASA ANONIMOWA ZAMIENIONA NA LAMBDA PONIEWAZ MAMY INTERFACE FUNKCYJNY
        Singable singable = songName -> "I'm singing: " + songName;
        return singable.singASong("My beautiful song ;>");
    }

//    w przypadku gdzie mamy dwie metody w interface nie użyjemy lambdy bo to nie jest interfejs funkcyjny
    private String callInnerInterfaceWithTwo(){
        Voiceable voiceable = new Voiceable() {
            @Override
            public String silentVoice() {
                return null;
            }

            @Override
            public String loudVoice() {
                return null;
            }
        };

        return voiceable.loudVoice();
    }


    interface Voiceable{
        String silentVoice();
        String loudVoice();
    }

    interface Singable{
        String singASong(String songName);
    }

    abstract class Animal{
        abstract String whatsYourName();
    }
}
