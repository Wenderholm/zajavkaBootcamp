package com.company._4warsztat.PROJEKT;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> stringCommands = List.of(
                "DELETE ALL;",
                "CREATE;NAME=TASK1;DESCRIPTION=SOME DESCRIPTION1;DEADLINE=11.02.2021 20:10;PRIORITY=0",
                "CREATE;NAME=TASK2;DESCRIPTION=SOME DESCRIPTION2;DEADLINE=12.02.2021 20:10;PRIORITY=1",
                "CREATE;NAME=TASK3;DESCRIPTION=SOME DESCRIPTION3;DEADLINE=13.02.2021 20:10;PRIORITY=2",
                "CREATE;NAME=TASK4;DESCRIPTION=SOME DESCRIPTION4;DEADLINE=14.02.2021 20:10;PRIORITY=3",
                "CREATE;NAME=TASK5;DESCRIPTION=SOME DESCRIPTION5;DEADLINE=15.02.2021 20:10;PRIORITY=4",
                "UPDATE;NAME=TASK3;DESCRIPTION=SOME NEW DESCRIPTION;DEADLINE=14.02.2021 20:10;PRIORITY=10",
                "READ;NAME=TASK1",
                "READ ALL;",
                "DELETE;NAME=TASK4",
                "DELETE ALL;"
        );

        CommandBuilder commandbuilder = new CommandBuilder();

        List<Command> commands = stringCommands.stream()
                .map(item -> commandbuilder.buildCommand(item))
                .filter(elem -> elem.isPresent())
                .map(elem -> elem.get())
                .collect(Collectors.toList());

        for (Command command : commands) {
            System.out.println(command);
        }

        DatabaseRunner databaseRunner = new DatabaseRunner();
        commands.forEach(command -> databaseRunner.run(command));
    }
}
