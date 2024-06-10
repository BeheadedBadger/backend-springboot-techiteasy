package nl.novi.techiteasy_spring.exceptions;

public class InvalidBrandException extends RuntimeException {
    public InvalidBrandException() {
        super();
    }

    public InvalidBrandException(String message) {
        super(message);
    }
}

