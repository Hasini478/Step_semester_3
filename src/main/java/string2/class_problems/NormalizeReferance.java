package string2.class_problems;
import java.util.Scanner;

public class NormalizeReferance {

    static String normalizeReference(String raw) {
        raw = raw.trim();

        String first3 = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return first3 + rest;
    }

    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Format the reference
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(reference.substring(0, 3));
        result.append("] DATE: ");

        result.append(reference.substring(3, 5));
        result.append("/");
        result.append(reference.substring(5, 7));
        result.append("/");
        result.append(reference.substring(7, 9));

        result.append(" | SEQ: ");
        result.append(reference.substring(9, 14));

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter reference: ");
        String raw = sc.nextLine();

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));
    }
}