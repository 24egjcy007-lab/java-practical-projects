import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {

        try {
            // Start the RMI Registry
            LocateRegistry.createRegistry(1099);

            // Create remote object
            Calculator obj = new CalculatorImpl();

            // Bind object with registry
            Naming.rebind("rmi://localhost:1099/CalculatorService", obj);

            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}