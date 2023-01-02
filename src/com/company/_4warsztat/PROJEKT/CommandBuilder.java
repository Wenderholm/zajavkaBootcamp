package com.company._4warsztat.PROJEKT;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandBuilder {

    Optional<Command> buildCommand (final String line){
//        podzielenie zapytania po znaku ;
        String[] split = line.split(";");
// command type bedzie CREATE,READ,UPDATE,DELETE,READ ALL, DELETE ALL jako pierwszy element split
        String commandType = split[0];
// sprwadzenie czy podana linnia z komendą zawiera odpowiedni typo komendy jeżęli nie to wyświetl błąd
        if(!Command.Type.valuesAsList().contains(commandType)){
            System.err.printf("User provided unknown command: [%s]%n",commandType);
            return Optional.empty();
        }
//        stworzenie podlisty z pozostałych elementów zapytania czyli po wyciagnięciu CREATE z
//        NAME=TASK1;DESCRIPTION=SOME DESCRIPTION1;DEADLINE=11.02.2021 20:10;PRIORITY=0
//        jezeli mamy podzielone na mapy
//        NAME=TASK1
//        DESCRIPTION=SOME DESCRIPTION1
//        DEADLINE=11.02.2021 20:10
//        PRIORITY=0
//        mozemy inicjować pola w klasie ToDoItem
        var parametersMap = Arrays.asList(split).subList(1, split.length).stream()
                .map(item -> item.split("="))
                .collect(Collectors.toMap(itemSplit -> itemSplit[0], itemSplit -> itemSplit[1]));
        ToDoItem toDoItem = buildToDoItem(parametersMap);
        return Optional.of(new Command(Command.Type.from(commandType),toDoItem));
    }

    private ToDoItem buildToDoItem(Map<String, String> parametersMap) {
        ToDoItem toDoItem = new ToDoItem();
        Optional.ofNullable(parametersMap.get(ToDoItem.Field.NAME.name()))
                .ifPresent(toDoItem::setName);
        Optional.ofNullable(parametersMap.get(ToDoItem.Field.DESCRIPTION.name()))
                .ifPresent(toDoItem::setDescription);
        Optional.ofNullable(parametersMap.get(ToDoItem.Field.DEADLINE.name()))
                .ifPresent(param -> toDoItem.setDeadline(LocalDateTime.parse(param,ToDoItem.DATE_FORMAT)));
        Optional.ofNullable(parametersMap.get(ToDoItem.Field.PRIORITY.name()))
                .ifPresent(param -> toDoItem.setPriority(Integer.valueOf(param)));
        return toDoItem;
    }
}
