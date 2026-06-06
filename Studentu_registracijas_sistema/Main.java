package studentregistration;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println();
            System.out.println("register");
            System.out.println("show");
            System.out.println("remove");
            System.out.println("edit");
            System.out.println("exit");

            System.out.print("Command: ");

            String command = scanner.nextLine();

            switch (command.toLowerCase()) {

                case "register":

                    try {

                        System.out.print("Vards: ");
                        String name = scanner.nextLine();

                        if (!Validator.validName(name)) {
                            throw new RuntimeException("Nepareizs vards!");
                        }

                        System.out.print("Uzvards: ");
                        String surname = scanner.nextLine();

                        if (!Validator.validName(surname)) {
                            throw new RuntimeException("Nepareizs uzvards!");
                        }

                        System.out.print("E-pasts: ");
                        String email = scanner.nextLine();

                        if (!Validator.validEmail(email)) {
                            throw new RuntimeException("Nepareizs e-pasts!");
                        }

                        System.out.print("Personas kods: ");
                        String personalCode = scanner.nextLine();

                        if (!Validator.validPersonalCode(personalCode)) {
                            throw new RuntimeException("Nepareizs personas kods!");
                        }

                        Student student =
                                new Student(
                                        name,
                                        surname,
                                        email,
                                        personalCode,
                                        LocalDateTime.now().toString()
                                );

                        manager.register(student);

                        System.out.println("Students pievienots!");

                    } catch (RuntimeException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case "show":

                    manager.showStudents();
                    break;

                case "remove":

                    System.out.print("Personas kods: ");
                    String pk = scanner.nextLine();

                    manager.remove(pk);

                    System.out.println("Students dzests.");
                    break;

                case "edit":

                    System.out.print("Personas kods: ");
                    String code = scanner.nextLine();

                    Student student =
                            manager.findStudent(code);

                    if (student == null) {

                        System.out.println("Students nav atrasts.");
                        break;
                    }

                    System.out.print("Jauns vards: ");
                    student.setName(scanner.nextLine());

                    System.out.print("Jauns uzvards: ");
                    student.setSurname(scanner.nextLine());

                    System.out.print("Jauns e-pasts: ");
                    student.setEmail(scanner.nextLine());

                    new FileHandler().saveStudents(
                            manager.getStudents()
                    );

                    System.out.println("Students atjaunots.");
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Nepareiza komanda!");
            }
        }
    }
}