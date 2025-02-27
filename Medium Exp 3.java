import java.util.*;

class ATM {
    private static final int CORRECT_PIN = 1234;
    private double balance;

    public ATM(double balance) {
        this.balance = balance;
    }

    public void withdraw(int pin, double amount) throws IllegalArgumentException {
        if (pin != CORRECT_PIN) {
            throw new IllegalArgumentException("Error: Invalid PIN.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Error: Insufficient balance. Current Balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(3000);

        try {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            atm.withdraw(pin, amount);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final Balance: " + atm.getBalance());
            scanner.close();
        }
    }
}
