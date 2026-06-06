package studentregistration;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;
    private FileHandler fileHandler;

    public StudentManager() {

        fileHandler = new FileHandler();
        students = fileHandler.loadStudents();
    }

    public void register(Student student) {

        for (Student s : students) {

            if (s.getEmail().equalsIgnoreCase(student.getEmail())) {
                throw new RuntimeException("E-pasts jau eksistē!");
            }

            if (s.getPersonalCode().equals(student.getPersonalCode())) {
                throw new RuntimeException("Personas kods jau eksistē!");
            }
        }

        students.add(student);
        fileHandler.saveStudents(students);
    }

    public void showStudents() {

        System.out.printf(
                "%-15s %-15s %-25s %-15s %-25s%n",
                "Vards",
                "Uzvards",
                "E-pasts",
                "Pers.kods",
                "Registracija"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (Student s : students) {

            System.out.printf(
                    "%-15s %-15s %-25s %-15s %-25s%n",
                    s.getName(),
                    s.getSurname(),
                    s.getEmail(),
                    s.getPersonalCode(),
                    s.getRegistrationDate()
            );
        }
    }

    public void remove(String personalCode) {

        students.removeIf(
                student -> student.getPersonalCode().equals(personalCode)
        );

        fileHandler.saveStudents(students);
    }

    public Student findStudent(String personalCode) {

        for (Student student : students) {

            if (student.getPersonalCode().equals(personalCode)) {
                return student;
            }
        }

        return null;
    }
}