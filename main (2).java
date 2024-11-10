import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) {
        System.out.println("Hey there! Welcome to Ysa's Gadget Store!");
        Scanner scanner = new Scanner(System.in);
        
        String[] products = {
            "iPhone 11 - $18000.00", 
            "iPhone 12 - $26000.00",
            "iPhone 13 - $32999.00",
            "iPhone 14 - $44599.00",
            "iPhone 15 - $55789.00",
            "iPhone 16 - $79999.00"
        };
        
        double[] prices = {18000.00, 26000.00, 32999.00, 44599.00, 55789.00, 79999.00};
        
        String continueShopping;
        
        do { 
            double total = 0;
            String choice;
            String purchaseSummary = "";
            
            do {
                System.out.println("\nHere are whats in store for you:");
                for (int i = 0; i < products.length; i++) {
                    System.out.println((i + 1) + ". " + products[i]); 
                }
                System.out.print("Please enter the product you want to purchase (one product only):");
                int productNumber = scanner.nextInt();
                
                
                if (productNumber >= 1 && productNumber <= products.length) {
                    
                    String productName = products[productNumber - 1].split(" -")[0];
                    System.out.print("How many of " + productName + " do you want to buy? ");
                    int quantity = scanner.nextInt();
                    
                    double productTotal = prices[productNumber - 1] * quantity;
                    
                    total += productTotal;
                    
                    purchaseSummary += quantity + " x " + productName + "\n";
                } else {
                    System.out.print("Invalid product number :< please try again!");
                }
                
                System.out.print("Do you want to add another product? (yes/no): ");
                choice = scanner.next();
                
            } while (choice.equalsIgnoreCase("yes"));
            
            System.out.println("\nYour cart:");
            System.out.println(purchaseSummary);
            System.out.println("Total price of product/s: $" + total);
            
            
            System.out.print("\nPlease enter the amount of money you have: $");
            double userMoney = scanner.nextDouble();
            
            if (userMoney >= total) {
                double balance = userMoney - total;
                System.out.println("I received + userMoney. Your balance after the purchase is: $" + balance);
            } else {
                double deficit = total - userMoney;
                System.out.println("You do not have enough money. You need $" + deficit + " more to complete the purchase.");
            }
            
            
            System.out.print("\nDo you want to start a new purchase? (yes/no): ");
            continueShopping = scanner.next();
            
        } while (continueShopping.equalsIgnoreCase("yes"));
        
        System.out.println("Thank you for shopping at Ysa's, please come again!");
    }
}

