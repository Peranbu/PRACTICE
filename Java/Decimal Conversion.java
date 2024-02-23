import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = scanner.nextInt();
        // Convert to octal, hexadecimal, and binary
        String octal = Integer.toOctalString(decimalNumber);
        String hexadecimal = Integer.toHexString(decimalNumber);
        String binary = Integer.toBinaryString(decimalNumber);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hexadecimal);
        System.out.println("Binary: " + binary);
        scanner.close();
    }
}
