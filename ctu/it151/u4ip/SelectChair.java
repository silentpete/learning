
// need JOptionPane to print to screen
import javax.swing.JOptionPane;

// Create a Chair object blueprint with setters and getters
class Chair {
    // values ideas
    int legs; // 1, 3, 4
    String seat; // small, medium, large
    String material; // wood, plastic, metal

    int getLegs() {
        return legs;
    }

    String getSeat() {
        return seat;
    }

    String getMaterial() {
        return material;
    }

    void setLegs(int legsReturned) {
        legs = legsReturned;
    }

    void setSeat(String seatReturned) {
        seat = seatReturned;
    }

    void setMaterial(String materialReturned) {
        material = materialReturned;
    }

    Chair(int a, String b, String c) {
        legs = a;
        seat = b;
        material = c;
    }
}

class SelectChair {
    /*
    Since we were going to print the chair more than once, turned into a method
    available to the SelectChair class.
    Also use a getter.
    */
    public static void printChair(Chair someChair) {
        JOptionPane.showMessageDialog(null, "Num Legs: " + someChair.getLegs() + "\n" + "Seat Size: "
                + someChair.getSeat() + "\n" + "Material: " + someChair.getMaterial());
    }

    // Create a method for getting an String that checks the reply is not empty
    public static String getStringInput(String question) {
        String reply = "";

        while (reply.isEmpty()) {
            reply = JOptionPane.showInputDialog(question);
            if (reply.isEmpty()) {
                System.out.println("value empty");
            }
        }

        return reply;
    }

    // Create a method for getting an int that checks the reply is not empty or contains letters
    public static int getIntInput(String question) {
        String replyString = "";
        int replyInt = 0;

        while (replyString.isEmpty()) {
            replyString = JOptionPane.showInputDialog(question);
            if (replyString.isEmpty()) {
                System.out.println("value empty");
            }
            if (replyString.matches("(.*)[a-zA-Z]+(.*)")) {
                System.out.println("found letters in value");
                replyString = "";
            }
        }

        replyInt = Integer.parseInt(replyString);

        return replyInt;
    }

    public static void popupMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static double computeAverageSales() {
        double totalPrice = 0.0, itemPrice, averageSales;
        int counter = 0;
        String anotherItem = "y";
        while (anotherItem.equalsIgnoreCase("y")) {
            itemPrice = Double.parseDouble(JOptionPane.showInputDialog("What is the item price for item " + (counter + 1) + "?"));
            totalPrice = totalPrice + itemPrice;
            counter++;
            anotherItem = JOptionPane.showInputDialog("Do you want to enter another item price? [y/n]");
        }
        averageSales = totalPrice / counter;
        return averageSales;
    }

    public static double computeShippingCharges() {
        double totalCost = 0.0, shippingCharge;
        int counter = 0;
        String anotherItem = "y";
        while (anotherItem.equalsIgnoreCase("y")) {
            shippingCharge = Double.parseDouble(JOptionPane.showInputDialog("What is the shipping cost for item " + (counter + 1) + "?"));
            totalCost = totalCost + shippingCharge;
            counter++;
            anotherItem = JOptionPane.showInputDialog("Do you want to enter another item shipping cost? [y/n]");
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int legsInit = 0;
        String seatInit = "";
        String materialInit = "";

        popupMessage("Welcome to the limited chair store!");

        legsInit = getIntInput("How many legs would you like on your chair?");
        seatInit = getStringInput("What size seat would you like on your chair?");
        materialInit = getStringInput("What material would you like your chair made of?");

        // Initialize a new chair object
        Chair c1 = new Chair(legsInit, seatInit, materialInit);

        // to use printChair, requires passing in a chair object
        printChair(c1);

        if (legsInit == 2) {
            int fourLegs = 4;
            popupMessage("Sorry, you can't have 2 legs" + "\n" + "Changing to " + fourLegs);
            // use a setter to change the legs num on object
            c1.setLegs(fourLegs);
            printChair(c1);
        }

        double averageSales = computeAverageSales();
        double shippingCharges = computeShippingCharges();
        String optionalMessage = "";
        if (averageSales > 200) {
            optionalMessage = " (significant revenue)";
        }
        JOptionPane.showMessageDialog(null, "Average Sales: " + averageSales + optionalMessage + "\n" +
                                            "Shipping Costs: " + shippingCharges);


        // print to cli
        System.out.println("Final Selected Chair Program Results");
        System.out.println("Num Legs: " + c1.getLegs());
        System.out.println("Seat Size: " + c1.getSeat());
        System.out.println("Material: " + c1.getMaterial());
        System.out.println("");
        System.out.println("Cost and Shipping Program Results");
        System.out.println("Average Sales: " + averageSales);
        System.out.println("Shipping Costs: " + shippingCharges);
    }
}
