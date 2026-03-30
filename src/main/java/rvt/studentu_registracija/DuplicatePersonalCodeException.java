package rvt.studentu_registracija;

public class DuplicatePersonalCodeException extends Exception {
    public DuplicatePersonalCodeException(String message) {
        super(message);
    }
}