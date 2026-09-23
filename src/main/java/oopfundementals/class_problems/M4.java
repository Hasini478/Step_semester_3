package oopfundementals.class_problems;

class M4 {

    static class Locker {

        private String code;
        private final int lockerNumber;

        Locker(int lockerNumber, String code) {
            this.lockerNumber = lockerNumber;
            this.code = code;
        }

        public boolean changeCode(String currentCode,
                                  String newCode) {

            if (code.equals(currentCode)) {
                code = newCode;
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {

        Locker locker = new Locker(101, "1234");

        boolean result1 =
                locker.changeCode("1234", "5678");

        System.out.println(
                "Correct code change: " + result1
        );

        boolean result2 =
                locker.changeCode("0000", "9999");

        System.out.println(
                "Wrong code change: " + result2
        );
    }
}
