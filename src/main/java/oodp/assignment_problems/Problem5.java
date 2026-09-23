package oodp.assignment_problems;

import java.util.Arrays;

class Candidate {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }
}

class Problem5 {

    static boolean isEligible(double cgpa) {
        return cgpa >= 8.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static int compareTo(Candidate other) {
        return 0;
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {

            if (isEligible(c.getCgpa()) ||
                    isEligible(c.getCgpa(), c.getCodingScore())) {

                shortlisted[count] = c;
                count++;
            }
        }

        Candidate[] result =
                Arrays.copyOf(shortlisted, count);

        Arrays.sort(result, (a, b) -> {

            double scoreA =
                    a.getCgpa() * 10 + a.getCodingScore();

            double scoreB =
                    b.getCgpa() * 10 + b.getCodingScore();

            return Double.compare(scoreB, scoreA);
        });

        String output = "";

        for (int i = 0; i < result.length; i++) {

            Candidate c = result[i];

            double composite =
                    c.getCgpa() * 10 + c.getCodingScore();

            output += (i + 1) + ". "
                    + c.getName()
                    + " (" + composite + ")";

            if (i < result.length - 1) {
                output += " | ";
            }
        }

        return output;
    }

    static void main() {

        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(
                shortlistAndRank(candidates)
        );
    }
}
