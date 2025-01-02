import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if palindrome: ");
        int number = scanner.nextInt();
        System.out.println("Is Palindrome: " + isPalindrome(number));
    }

    public static boolean isPalindrome(int n) {
        return n == ReverseNumber.reverseNumber(n);
    }
}
