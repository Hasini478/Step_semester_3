package DataStructures.assignment_problems;

class Attendance {
    public int[] attendanceSummary(int[] days) {
        int present = 0, count = 0, longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                count++;
                longest = Math.max(longest, count);
            } else {
                count = 0;
            }
        }

        return new int[]{present, longest};
    }
}
