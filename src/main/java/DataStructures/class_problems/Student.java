package DataStructures.class_problems;


class Member {
    String name;
    int[] marks;

    Member(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;
        for (int mark : marks)
            sum += mark;
        return sum / 3.0;
    }

    char grade() {
        double avg = average();

        if (avg >= 75)
            return 'B';
        else if (avg >= 60)
            return 'A';
        else if (avg >= 40)
            return 'D';
        else
            return 'F';
    }

    void display() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), average(), grade());
    }
}

public class Student {
    public static void main(String[] args) {
        Member s1 = new Member("Asha", new int[]{80, 90, 70});
        Member s2 = new Member("Ravi", new int[]{60, 55, 50});

        s1.display();
        s2.display();
    }
}
