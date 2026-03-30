package rvt;


import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class order {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(Paths.get("data/orders.csv"))){
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] parts = row.split( ",");

                System.out.println("OrderID " + parts[0]);
                System.out.println("Name" + parts[1]);
                System.out.println("Product" + parts[2]);
                System.out.println("Quantity" + parts[4]);
                System.out.println("Price" + parts[5]);
                System.out.println(Arrays.toString(parts));
            }

        }   catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

    }
}
}
