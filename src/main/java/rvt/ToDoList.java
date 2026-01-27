package rvt;

import java.util.ArrayList;
import java.util.Scanner;


class TodoList {
private ArrayList<String> tasks;


public TodoList() {
this.tasks = new ArrayList<>();
}


public void add(String task) {
tasks.add(task);
}


public void print() {
for (int i = 0; i < tasks.size(); i++) {
System.out.println((i + 1) + ": " + tasks.get(i));
}
}


public void remove(int number) {
tasks.remove(number - 1);
}
}


class UserInterface {
private TodoList list;
private Scanner scanner;


public UserInterface(TodoList list, Scanner scanner) {
this.list = list;
this.scanner = scanner;
}


public void start() {
while (true) {
System.out.print("Command: ");
String command = scanner.nextLine();


if (command.equals("stop")) {
break;
}


if (command.equals("add")) {
System.out.print("To add: ");
String task = scanner.nextLine();
list.add(task);
} else if (command.equals("list")) {
list.print();
} else if (command.equals("remove")) {
System.out.print("Which one is removed? ");
int number = Integer.valueOf(scanner.nextLine());
list.remove(number);
}
}
}
}
