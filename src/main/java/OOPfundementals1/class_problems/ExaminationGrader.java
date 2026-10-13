package OOPfundementals1.class_problems;

import java.util.*;

interface Question {
    double calculateScore(String correctAnswer, String studentAnswer, double points);
    String getType();
}

class MCQ implements Question {

    public double calculateScore(String correctAnswer, String studentAnswer, double points) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TF implements Question {

    public double calculateScore(String correctAnswer, String studentAnswer, double points) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    public String getType() {
        return "TF";
    }
}

class Essay implements Question {

    public double calculateScore(String correctAnswer, String studentAnswer, double points) {

        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0.0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            // Split input while keeping quoted strings together
            List<String> parts = new ArrayList<>();

            java.util.regex.Matcher matcher =
                    java.util.regex.Pattern
                            .compile("\"([^\"]*)\"|(\\S+)")
                            .matcher(line);

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    parts.add(matcher.group(1));
                } else {
                    parts.add(matcher.group(2));
                }
            }

            String type = parts.get(0);
            String questionText = parts.get(1);
            String correctAnswer = parts.get(2);
            String studentAnswer = parts.get(3);
            double points = Double.parseDouble(parts.get(4));

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ();
            } else if (type.equals("TF")) {
                question = new TF();
            } else {
                question = new Essay();
            }

            double score = question.calculateScore(
                    correctAnswer,
                    studentAnswer,
                    points
            );

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}