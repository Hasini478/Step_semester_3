package ClassesandObject.class_problems;

class M2 {

    static class MessWallet {

        private double balance;

        public MessWallet(double balance) {

            if (balance < 0) {
                this.balance = 0;
                System.out.println("Negative opening balance. Set to 0.");
            } else {
                this.balance = balance;
            }
        }

        public void topUp(double amount) {

            if (amount <= 0) {
                System.out.println("Top-up amount must be positive.");
            } else {
                balance = balance + amount;
            }
        }

        public void deduct(double amount) {

            if (amount <= 0) {
                System.out.println("Deduct amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                balance = balance - amount;
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {

        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        wallet.deduct(150);

        System.out.println("Balance: " + wallet.getBalance());
    }
}
