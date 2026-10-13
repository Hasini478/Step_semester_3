package DataStructures.class_problems;


import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String word = sc.next();
            StringBuilder sb = new StringBuilder(word);
            String rev = sb.reverse().toString();

            if (word.equals(rev))
                System.out.println(rev + " - palindrome");
            else
                System.out.println(rev + " - not a palindrome");
        }

        sc.close();
    }
}
