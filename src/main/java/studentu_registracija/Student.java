package studentu_registracija;

public class Student {

    private String firstName;
    private String lastName;
    private String email;
    private String personalCode;
    private String registrationDate;

    public Student(String firstName, String lastName, String email,
                   String personalCode, String registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationDate = registrationDate;
    }

    public String toCsv() {
        return String.join(",", firstName, lastName, email, personalCode, registrationDate);
    }

    public static Student fromCsv(String line) {
        String[] data = line.split(",");
        return new Student(data[0], data[1], data[2], data[3], data[4]);
    }

    public String getPersonalCode() { return personalCode; }
    public String getEmail() { return email; }

    public String[] toTableRow() {
        return new String[]{firstName, lastName, email, personalCode, registrationDate};
    }
}
