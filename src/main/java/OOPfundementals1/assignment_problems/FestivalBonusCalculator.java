package OOPfundementals1.assignment_problems;

import java.util.*;

interface Employee {
    double calculateBonus(double salary);
}

class FullTime implements Employee {

    public double calculateBonus(double salary) {
        return salary * 0.10;
    }
}

class PartTime implements Employee {

    public double calculateBonus(double salary) {
        return salary * 0.05;
    }
}

class Intern implements Employee {

    public double calculateBonus(double salary) {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Employee> employees = new HashMap<>();

        employees.put("FULLTIME", new FullTime());
        employees.put("PARTTIME", new PartTime());
        employees.put("INTERN", new Intern());

        int n = sc.nextInt();

        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = employees.get(type);

            double bonus = employee.calculateBonus(salary);

            System.out.printf("%s: %.2f%n", name, bonus);

            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}
