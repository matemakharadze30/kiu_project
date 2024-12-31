// BasicInterpreter.java
// Entry point for the BASIC interpreter project

import java.io.*;
import java.util.*;

public class BasicInterpreter {
    private static final Map<String, Integer> variables = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the BASIC Interpreter!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("BASIC> ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                executeCommand(command);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void executeCommand(String command) throws IOException {
        String[] tokens = command.trim().split(" ", 2);

        if (tokens.length == 0) {
            throw new IllegalArgumentException("Empty command");
        }

        String cmd = tokens[0].toLowerCase();
        String args = tokens.length > 1 ? tokens[1] : "";

        switch (cmd) {
            case "sum":
                handleSum(args);
                break;
            case "factorial":
                handleFactorial(args);
                break;
            case "gcd":
                handleGCD(args);
                break;
            case "reverse":
                handleReverse(args);
                break;
            case "prime":
                handlePrime(args);
                break;
            case "palindrome":
                handlePalindrome(args);
                break;
            case "largestdigit":
                handleLargestDigit(args);
                break;
            case "sumdigits":
                handleSumDigits(args);
                break;
            case "table":
                handleTable(args);
                break;
            case "fibonacci":
                handleFibonacci(args);
                break;
            case "let":
                handleLet(args);
                break;
            case "print":
                handlePrint(args);
                break;
            case "input":
                handleInput(args);
                break;
            case "run":
                handleRun(args);
                break;
            case "help":
                displayHelp();
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + cmd);
        }
    }

    private static void handleSum(String args) {
        int n = Integer.parseInt(args);
        System.out.println("Result: " + executeSumOfFirstN(n));
    }

    private static void handleFactorial(String args) {
        int n = Integer.parseInt(args);
        System.out.println("Result: " + executeFactorial(n));
    }

    private static void handleGCD(String args) {
        String[] numbers = args.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        System.out.println("Result: " + executeGCD(a, b));
    }

    private static void handleReverse(String args) {
        int n = Integer.parseInt(args);
        System.out.println("Result: " + executeReverseNumber(n));
    }

    private static void handlePrime(String args) {
        int n = Integer.parseInt(args);
        System.out.println("Result: " + executeIsPrime(n));
    }

    private static void handlePalindrome(String args) {
        int n = Integer.parseInt(args);
        System.out.println("Result: " + executeIsPalindrome(n));
    }

    private static void handleLargestDigit(String args) {
        int n = Integer.parseInt(args);
        System.out.println("Result: " + executeLargestDigit(n));
    }

    private static void handleSumDigits(String args) {
        int n = Integer.parseInt(args);
        System.out.println("Result: " + executeSumOfDigits(n));
    }

    private static void handleTable(String args) {
        int n = Integer.parseInt(args);
        executeMultiplicationTable(n);
    }

    private static void handleFibonacci(String args) {
        int n = Integer.parseInt(args);
        System.out.println("Result: " + executeNthFibonacci(n));
    }

    private static void handleLet(String args) {
        String[] parts = args.split("=");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Usage: LET varName=number");
        }
        String varName = parts[0].trim();
        int value = Integer.parseInt(parts[1].trim());
        variables.put(varName, value);
        System.out.println("Variable " + varName + " set to " + value);
    }

    private static void handlePrint(String args) {
        if (!variables.containsKey(args)) {
            throw new IllegalArgumentException("Variable not found: " + args);
        }
        System.out.println(args + " = " + variables.get(args));
    }

    private static void handleInput(String args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter value for " + args + ": ");
            int value = scanner.nextInt();
            variables.put(args, value);
            System.out.println("Variable " + args + " set to " + value);
        }
    }

    private static void handleRun(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                executeCommand(line);
            }
        }
    }

    private static void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("SUM N - Sum of first N numbers");
        System.out.println("FACTORIAL N - Factorial of N");
        System.out.println("GCD A B - GCD of A and B");
        System.out.println("REVERSE N - Reverse digits of N");
        System.out.println("PRIME N - Check if N is prime");
        System.out.println("PALINDROME N - Check if N is a palindrome");
        System.out.println("LARGESTDIGIT N - Largest digit in N");
        System.out.println("SUMDIGITS N - Sum of digits in N");
        System.out.println("TABLE N - Multiplication table of N");
        System.out.println("FIBONACCI N - Nth Fibonacci number");
        System.out.println("LET varName=N - Define a variable");
        System.out.println("PRINT varName - Print variable value");
        System.out.println("INPUT varName - Prompt user to set a variable");
        System.out.println("RUN filename - Execute commands from a file");
        System.out.println("HELP - Display this help message");
        System.out.println("EXIT - Exit the interpreter");
    }

    public static int executeSumOfFirstN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int executeFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int executeGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int executeReverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    public static boolean executeIsPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean executeIsPalindrome(int n) {
        return n == executeReverseNumber(n);
    }

    public static int executeLargestDigit(int n) {
        int largest = 0;
        while (n != 0) {
            int digit = n % 10;
            if (digit > largest) largest = digit;
            n /= 10;
        }
        return largest;
    }

    public static int executeSumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void executeMultiplicationTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
        }
    }

    public static int executeNthFibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
