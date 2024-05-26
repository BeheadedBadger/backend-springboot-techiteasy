package nl.novi.techiteasy_spring.exceptions;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class ExceptionController {

    public static String outOfBounds() {
         return "The specified id cannot be found.";
    }

    public static String empty() {
        return "The list is empty. Please add tvs first.";
    }

    public static String recordsNotFound() {
        return RecordNotFoundException.getMessage();
    }
}
