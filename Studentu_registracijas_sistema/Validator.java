package studentregistration;

public class Validator {

    public static boolean validName(String value) {
        return value.matches("[A-Za-zĀ-Žā-ž]{3,}");
    }

    public static boolean validEmail(String value) {
        return value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean validPersonalCode(String value) {
        return value.matches("\\d{11}");
    }
}