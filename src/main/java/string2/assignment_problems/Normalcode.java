package string2.assignment_problems;

import java.util.Scanner;

public class Normalcode {

    static String normalizeCode(String raw) {
        raw = raw.trim();

        String first3 = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return first3 + rest;
    }

    static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        return "["
                + code.substring(0, 3)
                + "] YEAR: "
                + code.substring(3, 7)
                + " | CATALOG: "
                + code.substring(7, 13);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String raw = sc.nextLine();

        String code = normalizeCode(raw);

        System.out.println(validateAndFormat(code));
    }
}