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
    JOptionPane.showMessageDialog(null, "Num Legs: " + someChair.getLegs() + "\n" +
                                        "Seat Size: " + someChair.getSeat() + "\n" +
                                        "Material: " + someChair.getMaterial() );
  }

  public static void main(String[] args) {
    int legsInit;
    String seatInit;
    String materialInit;

    JOptionPane.showMessageDialog(null, "Welcome to the limited chair store!");

    legsInit = Integer.parseInt(JOptionPane.showInputDialog("How many legs would you like on your chair?"));
    seatInit = JOptionPane.showInputDialog("What size seat would you like on your chair?");
    materialInit = JOptionPane.showInputDialog("What material would you like your chair made of?");

    // Initialize a new chair object
    Chair c1 = new Chair(legsInit, seatInit, materialInit);

    // to use printChair, requires passing in a chair object
    printChair(c1);

    if ( legsInit == 2) {
      int fourLegs = 4;
      JOptionPane.showMessageDialog(null, "Sorry, you can't have 2 legs" + "\n" + "Changing to "+ fourLegs);
      // use a setter to change the legs num on object
      c1.setLegs(fourLegs);
      printChair(c1);
    }

    // print to cli
    System.out.println("Final Selected Chair");
    System.out.println("Num Legs: " + c1.getLegs());
    System.out.println("Seat Size: " + c1.getSeat());
    System.out.println("Material: " + c1.getMaterial());
  }
}
