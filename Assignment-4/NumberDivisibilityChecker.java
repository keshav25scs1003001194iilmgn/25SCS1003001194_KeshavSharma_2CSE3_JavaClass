import java.util.Scanner;
public class NumberDivisibilityChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (n % 5 == 0) {
            System.out.println("The number is divisible by 5.");
            if (n % 10 == 0) {
                System.out.println("The number is also divisible by 10.");
            } else {
                System.out.println("The number is not divisible by 10.");
            }
        } else {
            System.out.println("The number is not divisible by 5.");
        }
    }
}
