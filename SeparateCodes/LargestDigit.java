import java.util.Scanner;

public class LargestDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Largest Digit: " + findLargestDigit(number));
    }

    public static int findLargestDigit(int n) {
        int largest = 0;
        while (n != 0) {
            int digit = n % 10;
            if (digit > largest) largest = digit;
            n /= 10;
        }
        return largest;
    }
}
