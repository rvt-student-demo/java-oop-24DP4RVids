package studentregistration;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private final String fileName = "data/students.csv";

    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 5) {

                    students.add(new Student(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("CSV file not found.");
        }

        return students;
    }

    public void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(fileName))) {

            for (Student student : students) {
                bw.write(student.toCsv());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}