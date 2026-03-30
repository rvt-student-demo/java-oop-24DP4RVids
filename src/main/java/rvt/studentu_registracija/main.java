package rvt.studentu_registracija;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationService service = new RegistrationService();

        while (true) {
            System.out.println("\nIzvēlies darbību: register | show | remove | exit");
            String cmd = sc.nextLine();

            try {
                switch (cmd) {
                    case "register":
                        System.out.print("Vārds: ");
                        String name = sc.nextLine();
                        System.out.print("Uzvārds: ");
                        String surname = sc.nextLine();
                        System.out.print("E-pasts: ");
                        String email = sc.nextLine();
                        System.out.print("Personas kods (xxxxxx-xxxxx): ");
                        String pk = sc.nextLine();

                        if (!Validator.isValidName(name) ||
                            !Validator.isValidName(surname) ||
                            !Validator.isValidEmail(email) ||
                            !Validator.isValidPersonalCode(pk)) {
                            System.out.println("❌ Nepareizi ievaddati!");
                            break;
                        }

                        service.register(new Student(
                                name, surname, email, pk,
                                RegistrationService.now()));

                        System.out.println("✅ Students reģistrēts!");
                        break;

                    case "show":
                        TablePrinter.print(service.getAll());
                        break;

                    case "remove":
                        System.out.print("Ievadi personas kodu: ");
                        service.remove(sc.nextLine());
                        System.out.println("🗑 Dzēsts (ja eksistēja)");
                        break;

                    case "exit":
                        System.out.println("👋 Programma apturēta");
                        return;
                }
            } catch (Exception e) {
                System.out.println("⚠️ Kļūda: " + e.getMessage());
            }
        }
    }
}