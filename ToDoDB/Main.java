package todoapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TodoDB db = new TodoDB();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nCommands:");
            System.out.println("add");
            System.out.println("list");
            System.out.println("remove");
            System.out.println("exit");

            System.out.print("Command: ");
            String cmd = scanner.nextLine();

            switch (cmd) {

                case "add":
                    System.out.print("Task: ");
                    String task = scanner.nextLine();
                    db.add(task);
                    break;

                case "list":
                    db.findAll();
                    break;

                case "remove":
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    db.removeById(id);
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Unknown command");
            }
        }
    }
}