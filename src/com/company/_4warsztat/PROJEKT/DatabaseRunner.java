package com.company._4warsztat.PROJEKT;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class DatabaseRunner {
    String URL = "jdbc:postgresql://localhost:5432/zajavka";
    String USERNAME = "postgres";
    String PASSWORD = "19Wend!88";

    private static final String SQL_INSERT = "INSERT INTO TODOLIST (NAME, DESCRIPTION, DEADLINE, PRIORITY) VALUES (?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE TODOLIST SET DESCRIPTION = ?, DEADLINE = ?, PRIORITY = ? WHERE NAME = ?;";
    private static final String SQL_READ_WHERE = "SELECT * FROM TODOLIST WHERE NAME = ?;";
    private static final String SQL_READ_ALL = "SELECT * FROM TODOLIST ORDER BY ?1 ?2;";
    private static final String SQL_GROUPED = "SELECT DATE(deadline) AS DATE, ARRAY_AGG(name) AS TASKS FROM TODOLIST " +
            "GROUP BY DATE(deadline) ORDER BY DATE DESC;";
    private static final String SQL_DELETE = "DELETE FROM TODOLIST WHERE NAME = ?;";
    private static final String SQL_DELETE_ALL = "DELETE FROM TODOLIST;";
    private static final String SQL_COMPLETED = "UPDATE TODOLIST SET STATUS = ? WHERE NAME = ?;";

    private final Map<Command.Type, Consumer<Command>> EXECUTION_MAP;

    {
        EXECUTION_MAP = Map.of(
                Command.Type.CREATE, this::runAdd,
                Command.Type.UPDATE, this::runEdit,
                Command.Type.READ, this::runRead,
                Command.Type.READ_ALL, this::runReadAll,
                Command.Type.DELETE_ALL, this::runDeletedAll,
                Command.Type.DELETE, this::runDeleted
        );
    }

    void run(final Command command) {
        System.out.println("##### RUNNING COMMAND ######");
//        ustawiamy wykonanie komendy zgodnie z podanym typem
//        jezeli np podamy typ bedzie CREATE to wykona sie runAdd
        Consumer<Command> commandConsumer = Optional.ofNullable(EXECUTION_MAP.get(command.getType()))
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Command: [%s] not supported", command.getType())
                ));
        commandConsumer.accept(command);
        System.out.println("##### FINISHED COMMAND ######");
    }


    private void runAdd(final Command command) {
//        zabezepieczenie jezeli komenda wejdzie inna niz CREATE to jej nie wykonamy
        if (!Command.Type.CREATE.equals(command.getType())) {
            throw new IllegalArgumentException(command.getType().getName());
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT)
        ) {
            statement.setString(1, command.getToDoItem().getName());
            statement.setString(2, command.getToDoItem().getDescription());
            statement.setTimestamp(3, Timestamp.valueOf(command.getToDoItem().getDeadline()));
            statement.setInt(4, command.getToDoItem().getPriority());
            int count = statement.executeUpdate();
            System.out.printf("Run [%s] successfully, modified [%s] rows %n", command.getType(), count);
        } catch (SQLException e) {
            System.err.printf("[%s] data error. Message: [%s]%n", command.getType(), e.getMessage());
        }
    }


    private void runEdit(final Command command) {
//        zabezepieczenie jezeli komenda wejdzie inna niz CREATE to jej nie wykonamy
        if (!Command.Type.UPDATE.equals(command.getType())) {
            throw new IllegalArgumentException(command.getType().getName());
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)
        ) {
//            "UPDATE TODOLIST SET DESCRIPTION = ?, DEADLINE = ?, PRIORITY = ?, WHERE NAME = ?;"
            statement.setString(1, command.getToDoItem().getDescription());
            statement.setTimestamp(2, Timestamp.valueOf(command.getToDoItem().getDeadline()));
            statement.setInt(3, command.getToDoItem().getPriority());
            statement.setString(4, command.getToDoItem().getName());
            int count = statement.executeUpdate();
            System.out.printf("Run [%s] successfully, modified [%s] rows %n", command.getType(), count);
        } catch (SQLException e) {
            System.err.printf("[%s] data error. Message: [%s]%n", command.getType(), e.getMessage());
        }
    }


    private void runRead(final Command command) {
//        zabezepieczenie jezeli komenda wejdzie inna niz CREATE to jej nie wykonamy
        if (!Command.Type.READ.equals(command.getType())) {
            throw new IllegalArgumentException(command.getType().getName());
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(SQL_READ_WHERE)
        ) {
//            "SELECT * FROM TODOLIST WHERE NAME = ?;"
            statement.setString(1, command.getToDoItem().getName());
            try (ResultSet resultSet = statement.executeQuery()) {
                List<ToDoItem> readItem = mapToToDoItem(resultSet);
                print(readItem);
                System.out.printf("Run [%s] successfully, read [%s] rows %n", command.getType(), readItem.size());
            }
            ;

        } catch (SQLException e) {
            System.err.printf("[%s] data error. Message: [%s]%n", command.getType(), e.getMessage());
        }
    }

    private void print(List<ToDoItem> readItem) {
        System.out.println("PRINTING TO DO LIST");
        String schema = "%-25s%-25s%-25s%-25s%n";
        System.out.printf(schema,
                ToDoItem.Field.NAME.name(),
                ToDoItem.Field.DESCRIPTION.name(),
                ToDoItem.Field.DEADLINE.name(),
                ToDoItem.Field.PRIORITY.name()
        );
        readItem.forEach(entry -> System.out.printf(schema,
                entry.getName(),entry.getDescription(),entry.getDeadline(),entry.getPriority()));
    }

    private List<ToDoItem> mapToToDoItem(ResultSet resultSet) throws SQLException {

        List<ToDoItem> result = new ArrayList<>();
        while (resultSet.next()) {
            ToDoItem toDoItem = new ToDoItem();
//            ToDoItem.Field.NAME.name() -> zwraca nazwe enuma
            toDoItem.setName(resultSet.getString(ToDoItem.Field.NAME.name()));
            toDoItem.setDescription(resultSet.getString(ToDoItem.Field.DESCRIPTION.name()));
            toDoItem.setDeadline(resultSet.getTimestamp(ToDoItem.Field.DEADLINE.name()).toLocalDateTime());
            toDoItem.setPriority(resultSet.getInt(ToDoItem.Field.PRIORITY.name()));
            result.add(toDoItem);
        }
        return result;
    }



    private void runReadAll(final Command command) {
        if (!Command.Type.READ_ALL.equals(command.getType())) {
            throw new IllegalArgumentException(command.getType().getName());
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(SQL_READ_ALL
                        .replace("?1",command.getSortBy().name())
                        .replace("?2",command.getSortDir().name()))
        ) {
//           wstawianie po czym chcemy sortowac i jaki rodzaj sortowania wstawian nam ' ' przy 'PRIORITY' oraz 'DESC'
//            aby obejsc ten problem modyfikujemy zapytanie sql read all
//            statement.setString(1, command.getSortBy().name());
//            statement.setString(2,command.getSortDir().name());
            try (ResultSet resultSet = statement.executeQuery()) {
                List<ToDoItem> readItem = mapToToDoItem(resultSet);
                print(readItem);
                System.out.printf("Run [%s] successfully, read [%s] rows %n", command.getType(), readItem.size());
            }


        } catch (SQLException e) {
            System.err.printf("[%s] data error. Message: [%s]%n", command.getType(), e.getMessage());
        }
    }
    private void runDeletedAll(final Command command) {
//        zabezepieczenie jezeli komenda wejdzie inna niz CREATE to jej nie wykonamy
        if (!Command.Type.DELETE_ALL.equals(command.getType())) {
            throw new IllegalArgumentException(command.getType().getName());
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL)
        ) {
            int count = statement.executeUpdate();
            System.out.printf("Run [%s] successfully, modified [%s] rows %n", command.getType(), count);
        } catch (SQLException e) {
            System.err.printf("[%s] data error. Message: [%s]%n", command.getType(), e.getMessage());
        }
    }


    private void runDeleted(final Command command) {
//        zabezepieczenie jezeli komenda wejdzie inna niz CREATE to jej nie wykonamy
        if (!Command.Type.DELETE.equals(command.getType())) {
            throw new IllegalArgumentException(command.getType().getName());
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(SQL_DELETE)
        ) {
//            "DELETE FROM TODOLIST WHERE NAME = ?;"
            statement.setString(1,command.getToDoItem().getName());
            int count = statement.executeUpdate();
            System.out.printf("Run [%s] successfully, modified [%s] rows %n", command.getType(), count);
        } catch (SQLException e) {
            System.err.printf("[%s] data error. Message: [%s]%n", command.getType(), e.getMessage());
        }
    }
}
