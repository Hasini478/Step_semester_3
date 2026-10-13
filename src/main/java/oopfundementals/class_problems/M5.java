package oopfundementals.class_problems;

class M5 {

    static class AttendanceSheet {

        private String[] students;

        AttendanceSheet(int size) {
            students = new String[size];
        }

        public void markPresent(String name) {

            // Check for duplicate
            for (int i = 0; i < students.length; i++) {

                if (name.equals(students[i])) {
                    return;
                }
            }

            // Add new student
            for (int i = 0; i < students.length; i++) {

                if (students[i] == null) {
                    students[i] = name;
                    return;
                }
            }
        }

        public int getPresentCount() {

            int count = 0;

            for (int i = 0; i < students.length; i++) {

                if (students[i] != null) {
                    count++;
                }
            }

            return count;
        }

        public boolean isPresent(String name) {

            for (int i = 0; i < students.length; i++) {

                if (name.equals(students[i])) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {

        AttendanceSheet sheet =
                new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(
                "Present count = "
                        + sheet.getPresentCount()
        );

        System.out.println(
                "Ben present = "
                        + sheet.isPresent("Ben")
        );

        System.out.println(
                "Chen present = "
                        + sheet.isPresent("Chen")
        );
    }
}
