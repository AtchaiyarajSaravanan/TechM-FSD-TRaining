import java.util.*;

// Product class to represent a product in the warehouse
class Product {
    String id; // Product ID
    String name;  // Product name
    int quantity;// Quantity in stock
    String location;// Location in the warehouse (e.g., "A1-S2-B3")

    public Product(String id, String name, int quantity, String location) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }
}

// Order class to represent an order
class Order {
    String id;  // Order ID
    List<String> products; // List of product IDs in the order
    boolean isPriority; // true for high priority, false for standard

    public Order(String id, List<String> products, boolean isPriority) {
        this.id = id;
        this.products = products;
        this.isPriority = isPriority;
    }
}

// Warehouse class to manage inventory and process orders
class Warehouse {
    Map<String, Product> inventory = new HashMap<>(); // Stores products by ID
    Queue<Order> orderQueue = new LinkedList<>(); // Stores orders in a queue

    // Add a product to the inventory
    public void addProduct(Product product) {
        inventory.put(product.id, product);
        System.out.println("Added product: " + product.name + " (ID: " + product.id + ")");
    }

    // Add an order to the queue
    public void addOrder(Order order) {
        orderQueue.add(order);
        System.out.println("Added order: " + order.id + " (Priority: " + (order.isPriority ? "High" : "Standard") + ")");
    }

    // Process all orders in the queue
    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll(); // Get the next order
            System.out.println("\nProcessing order: " + order.id);

            // Check each product in the order
            for (String productId : order.products) {
                Product product = inventory.get(productId);

                if (product == null) {
                    System.out.println("Product " + productId + " not found in inventory.");
                } else if (product.quantity <= 0) {
                    System.out.println("Product " + product.name + " is out of stock.");
                } else {
                    // Reduce the quantity and fulfill the order
                    product.quantity--;
                    System.out.println("Fulfilled: " + product.name + " from " + product.location);
                }
            }
        }
    }
}

// Main class to run the warehouse simulation
public class Main {
    public static void main(String[] args) {
        // Create a warehouse
        Warehouse warehouse = new Warehouse();

        // Add some products to the warehouse
        warehouse.addProduct(new Product("P1", "Laptop", 5, "A1-S2-B3"));
        warehouse.addProduct(new Product("P2", "Mouse", 10, "A2-S3-B1"));
        warehouse.addProduct(new Product("P3", "Keyboard", 8, "A3-S1-B2"));

        // Create some orders
        List<String> order1Products = Arrays.asList("P1", "P2");
        List<String> order2Products = Arrays.asList("P3", "P2");
        List<String> order3Products = Arrays.asList("P1", "P3");

        Order order1 = new Order("O1", order1Products, true);  // High priority
        Order order2 = new Order("O2", order2Products, false); // Standard priority
        Order order3 = new Order("O3", order3Products, true);  // High priority

        // Add orders to the warehouse
        warehouse.addOrder(order1);
        warehouse.addOrder(order2);
        warehouse.addOrder(order3);

        // Process all orders
        warehouse.processOrders();
    }
}