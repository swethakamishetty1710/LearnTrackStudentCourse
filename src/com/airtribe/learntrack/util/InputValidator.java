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

    public static int validateRange(int value, int min, int max) {
        if (value < min || value > max) {
            throw new InvalidInputException(
                    "Input must be between " + min + " and " + max
            );
        }
        return value;
    }
}
