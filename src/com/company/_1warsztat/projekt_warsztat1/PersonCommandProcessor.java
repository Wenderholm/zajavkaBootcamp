package com.company._1warsztat.projekt_warsztat1;

public class PersonCommandProcessor {

    private final CustomQueue<Person> customQueue;

    public PersonCommandProcessor(CustomQueue<Person> customQueue) {
        this.customQueue = customQueue;
    }

    public void processCommand(String command) {
        if(command.contains("ADD PERSON")){
            handleAddPerson(command, command.contains("VIP"));
        }else if(command.contains("LEAVE PERSON")){
            handleLeavePerson(command);
        }else if(command.contains("PROCESS")){
            handleProcess(command);
        }else{
            throw new RuntimeException("o co ci chodzi z komendą: " + command);
        }
    }

    private void handleAddPerson(String command, Boolean isVip) {
        System.out.println(command);
        Person incomingPerson = createIncomingPerson(command, isVip);
        if(isVip){
            customQueue.welcomeVip(incomingPerson);
        }else{
            customQueue.welcome(incomingPerson);
        }
    }

    private Person createIncomingPerson(String command, Boolean isVip) {
//        String personKey = command.substring(command.indexOf("(")+1, command.length()-1);
        String personKey = command
                .replace("ADD PERSON(","")
                .replace(isVip ? ",VIP)" : ")","");

        String[] split = personKey.split("_");

        if(isVip){
            if(split.length == 2){
                return new Person(split[0], split[1], customQueue.getAndIncrementCounter(personKey),isVip);
            } else{
                throw new IllegalArgumentException("Illegal argument " + command);
            }
        }else if(split.length == 2){
            return new Person(split[0], split[1], customQueue.getAndIncrementCounter(personKey));
        } else{
            throw new IllegalArgumentException("Illegal argument " + command);
        }
    }
    private void handleLeavePerson(String command) {
        System.out.println(command);
        Person person = createLeavingPerson(command);
        customQueue.leave(person);
    }

    private Person createLeavingPerson(String command) {
//        String personId = command.substring(command.indexOf("(")+1, command.length()-1);
        String personId = command
                .replace("LEAVE PERSON(","")
                .replace(")","");

        String[] splitId = personId.split("_");

        if(splitId.length == 2){
            return new Person(splitId[0], splitId[1],1);
        }else if(splitId.length == 3){
            return new Person(splitId[0], splitId[1],Integer.parseInt(splitId[2]));
        }else {
            throw new IllegalArgumentException("Illegal argument " + command);
        }
    }

    private void handleProcess(String command) {
        System.out.println(command);
        customQueue.enter();
    }
}
