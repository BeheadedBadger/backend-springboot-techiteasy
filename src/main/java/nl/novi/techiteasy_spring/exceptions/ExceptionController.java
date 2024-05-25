package nl.novi.techiteasy_spring.exceptions;

import java.util.ArrayList;

public class ExceptionController {

    public static String outOfBounds() {
         return "The specified id cannot be found.";
    }

    public static String empty() {
        return "The list is empty. Please add tvs first.";
    }
}
