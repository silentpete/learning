import java.util.Scanner;
/*
  The user should enter product ID, product name, and product price.
  After the user has entered all three values, the application should display
  this information to the user.
*/
class u1ip {
  public static void main(String args[]) {
    // create a new scanner called reader that takes system.in
    Scanner reader = new Scanner(System.in);

    // use system.out to print to the screen with a newline
    // then declare an int and asign from user input using the reader
    System.out.println("What is the product ID?");
    int productID = reader.nextInt();

    System.out.println("What is the product name?");
    String productName= reader.next();

    System.out.println("What is the product price?");
    double productPrice = reader.nextDouble();

    // display back to the users the values collected
    System.out.println("Product ID: " + productID);
    System.out.println("Product Name: " + productName);
    System.out.println("Product Price: " + productPrice);

    // ask if the values are correct
    System.out.println("Are these the correct values? [y/n]");
    String result = reader.next();

    // if received a "y" true, else false
    if ( result.equals("y") ) {
      System.out.println("cool");
    } else {
      System.out.println("that stinks");
    }

    // close the reader so it isn't left open
    reader.close();
  }
}
