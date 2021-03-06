import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Neelam Kaur) 
 * @version 1 (10/10/2021)
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */ 
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        
        if (product == null)
        {
            
        }
        else{
            product.increaseQuantity(amount);
            System.out.println("NOT FOUND");
        }
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product : stock)
        {
         if(product.getID() == productID)   
         return product;
        }
        return null;
        
    }
    
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int quantity)
    {
        System.out.println("Selling Quantitites of Stock\n");
        
        Product product = findProduct(productID);
        int stockQuantity = product.getQuantity();
        
        if(product != null) 
        {
            if(stockQuantity > 0)
            {
                if(stockQuantity > quantity)
                {
                    product.decreaseQuantity(quantity);
                    System.out.println("Selling" + quantity + "" + product.getID());
                
                }
                else
                {
                    System.out.println("All stock is sold !!");
                    System.out.println("Selling" + stockQuantity + "" + product.getID());
                    product.decreaseQuantity(stockQuantity);
                }
            }
            else
            {
                System.out.println("Selling none of" + product.getID());
            }
        }
        else
        {
            // printout message
        }
    }
    
    public void search(String phrase)
    {
        if(phrase.contains("Samsung"))
        {
            System.out.println("List Of product starting With Samsung");
        }
        else
        {
            
        }
    }

    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Neelam's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}