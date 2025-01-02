import java.util.Scanner;

public class SumOfFirstN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();
        System.out.println("Sum of First N Numbers: " + sumOfFirstN(n));
    }

    public static int sumOfFirstN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
