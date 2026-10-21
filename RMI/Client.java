import java.rmi.Naming;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Lookup remote object
            Calculator obj = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Addition = " + obj.add(a, b));
            System.out.println("Subtraction = " + obj.subtract(a, b));

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}