package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

import java.util.Scanner;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    private InputValidator() {
        // prevent object creation
    }

    public static int readInt(String message) {
        System.out.println(message);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.next(); // clear buffer
            throw new InvalidInputException("Please enter a valid number");
        }
    }

    public static String readString(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public static int validateRange(int inputValue, int min, int max) {
        if (inputValue < min || inputValue > max) {
            throw new InvalidInputException(
                    "Input must be between " + min + " and " + max
            );
        }
        return inputValue;
    }
}
