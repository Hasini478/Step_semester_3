package OOPfundementals1.assignment_problems;

import java.util.*;
import java.time.LocalDate;

interface Plan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class Basic implements Plan {

    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class Standard implements Plan {

    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class Premium implements Plan {

    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Plan> plans = new HashMap<>();

        plans.put("BASIC", new Basic());
        plans.put("STANDARD", new Standard());
        plans.put("PREMIUM", new Premium());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            Plan plan = plans.get(type);

            LocalDate renewalDate =
                    plan.calculateRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}