import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter a number: ");
            double number = scanner.nextDouble();
            
            if (number < 0) {
                throw new IllegalArgumentException("Error: Cannot calculate the square root of a negative number.");
            }
            
            double result = Math.sqrt(number);
            System.out.println("Square root: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
