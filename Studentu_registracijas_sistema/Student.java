package studentregistration;

public class Student {

    private String name;
    private String surname;
    private String email;
    private String personalCode;
    private String registrationDate;

    public Student(String name, String surname, String email,
                   String personalCode, String registrationDate) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toCsv() {
        return name + "," +
               surname + "," +
               email + "," +
               personalCode + "," +
               registrationDate;
    }
}