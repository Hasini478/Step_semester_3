package string2.class_problems;

import java.util.Scanner;

public class PhoneNumber {

    static String maskPhoneNumber(String phone) {

        // Check length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get last 4 digits
        String last4 = phone.substring(6);

        // Build masked number
        StringBuilder result = new StringBuilder("XXXXXX");
        result.insert(6, "-");
        result.append(last4);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));
    }
}