package rvt.studentu_registracija;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "students.csv";

    public static List<Student> readStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return students;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromCsv(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void writeStudents(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.toCsv());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}