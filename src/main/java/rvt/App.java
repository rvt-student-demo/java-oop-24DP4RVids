package rvt;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Paths.get("data/data.csv"))) {

            scanner.nextLine();

    // we read the file until all lines have been read
            while (scanner.hasNextLine()) {
        // we read one line
                String row = scanner.nextLine();
                String[] parts = row.split( ",");
        // we print the line that we read
                System.out.println("Name " + parts[0]);
                System.out.println("Age" + parts[1]);
                System.out.println("ID" + parts[2]);
                System.out.println("Email" + parts[4]);
                System.out.println(Arrays.toString(parts));
        }
    }   catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
}
    }
}
