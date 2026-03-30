package rvt.studentu_registracija;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class RegistrationService {

    private List<Student> students;

    public RegistrationService() {
        students = FileHandler.readStudents();
    }

    public void register(Student student)
            throws DuplicateEmailException, DuplicatePersonalCodeException {

        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(student.getEmail()))
                throw new DuplicateEmailException("E-pasts jau eksistē!");
            if (s.getPersonalCode().equals(student.getPersonalCode()))
                throw new DuplicatePersonalCodeException("Personas kods jau eksistē!");
        }
        students.add(student);
        FileHandler.writeStudents(students);
    }

    public void remove(String personalCode) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getPersonalCode().equals(personalCode)) {
                it.remove();
                break;
            }
        }
        FileHandler.writeStudents(students);
    }

    public List<Student> getAll() {
        return students;
    }

    public static String now() {
        return LocalDateTime.now().toString();
    }
}