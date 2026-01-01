package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {


    private InputValidator() {
        // prevent object creation
    }

    public static int readInt(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            throw new InvalidInputException("Please enter a valid number");
        }
    }

    public static String readString(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        return scanner.nextLine();
    }

    public static int validateRange(int inputValue, int min, int max) {

        if (inputValue < min || inputValue > max) {
            throw new InvalidInputException(
                    "Input must be between " + min + " and " + max
            );
        }
        return inputValue;
    }

    public static void validateId(int id) {
        if (id < 0) {
            throw new InvalidInputException("ID cannot be negative");
        }
    }

}
