package rvt.studentu_registracija;

import java.util.List;

public class TablePrinter {

    public static void print(List<Student> students) {
        System.out.printf("%-15s %-15s %-25s %-15s %-25s%n",
                "Vārds", "Uzvārds", "E-pasts", "PK", "Reģ. datums");
        System.out.println("------------------------------------------------------------------------------------");

        for (Student s : students) {
            String[] row = s.toTableRow();
            System.out.printf("%-15s %-15s %-25s %-15s %-25s%n",
                    row[0], row[1], row[2], row[3], row[4]);
        }
    }
}