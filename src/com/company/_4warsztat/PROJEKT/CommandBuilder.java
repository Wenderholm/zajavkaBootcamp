package com.company._4warsztat.PROJEKT;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CommandBuilder {

    Optional<Command> buildCommand(final String line) {
//        podzielenie zapytania po znaku ;
        String[] split = line.split(";");
// command type bedzie CREATE,READ,UPDATE,DELETE,READ ALL, DELETE ALL jako pierwszy element split
        String commandType = split[0];
// sprwadzenie czy podana linnia z komendą zawiera odpowiedni typo komendy jeżęli nie to wyświetl błąd
        if (!Command.Type.valuesAsList().contains(commandType)) {
            System.err.printf("User provided unknown command: [%s]%n", commandType);
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
        List<String> stringCommandWithParamsExtracted = Arrays.asList(split).subList(1, split.length);
        var parametersMap = stringCommandWithParamsExtracted.stream()
                .map(item -> item.split("="))
//                w tym miejscu chcemy pominąć SORT poniewaz ta mapa służy do tworzenia toDoItem a tam sort nie ma
//                bierzemy param[0] -> SORT = PRIORITY,DESC <- param[1]
//                .filter(param-> !ToDoItem.Field.SORT.name().equals(param[0]))
                .collect(Collectors.toMap(itemSplit -> itemSplit[0], itemSplit -> itemSplit[1]));

//        operacje na samym SORT wyszukujemy jakie kolwiek sortowanie bo wszytkie będą takie same
//        Optional<String[]> sorting = stringCommandWithParamsExtracted.stream()
//                .map(item -> item.split("="))
//                .filter(param -> ToDoItem.Field.SORT.name().equals(param[0]))
//                .findAny();

        List<String> sortingParams = Optional.ofNullable(parametersMap.get(ToDoItem.Field.SORT.name()))
                .map(params -> List.of(params.split(",")))
                .orElse(Collections.emptyList());


        ToDoItem toDoItem = buildToDoItem(parametersMap);
        return Optional.of(new Command(
                Command.Type.from(commandType),
                toDoItem,
                findSortingField(sortingParams),
                findSortingDir(sortingParams)));
    }

    private ToDoItem.Field findSortingField(List<String> sortingParams) {
        if (sortingParams.isEmpty()) {
            return ToDoItem.Field.NAME;
        }
        try {
            return ToDoItem.Field.valueOf(sortingParams.get(0));
        } catch (Exception e) {
            System.err.printf("Sorting field is not specified. Default: [%s]%n", ToDoItem.Field.NAME);
            return ToDoItem.Field.NAME;
        }
    }

    private Command.SortDir findSortingDir(List<String> sortingParams) {
//        ustawiamy ze program zawsze bedzie sortowała domyslnie do czasu podania innej wartości sortowania niz ASC
        if (sortingParams.isEmpty()) {
            return Command.SortDir.ASC;
        }
        try {
            return Command.SortDir.valueOf(sortingParams.get(1));
        } catch (Exception e) {

            System.err.printf("Sorting dir is not specified. Default: [%s]%n", Command.SortDir.ASC);
//        ustawiamy domyslne sortowanie rosnąco jezeli kotos nie poda parametru ASC albo DESC
            return Command.SortDir.ASC;
        }
    }

    private ToDoItem buildToDoItem(Map<String, String> parametersMap) {
        ToDoItem toDoItem = new ToDoItem();
        Optional.ofNullable(parametersMap.get(ToDoItem.Field.NAME.name()))
                .ifPresent(toDoItem::setName);
        Optional.ofNullable(parametersMap.get(ToDoItem.Field.DESCRIPTION.name()))
                .ifPresent(toDoItem::setDescription);
        Optional.ofNullable(parametersMap.get(ToDoItem.Field.DEADLINE.name()))
                .ifPresent(param -> toDoItem.setDeadline(LocalDateTime.parse(param, ToDoItem.DATE_FORMAT)));
        Optional.ofNullable(parametersMap.get(ToDoItem.Field.PRIORITY.name()))
                .ifPresent(param -> toDoItem.setPriority(Integer.valueOf(param)));
        return toDoItem;
    }
}
