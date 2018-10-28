
import java.util.*;

// Contributor is used for Zoo collection and processing methods.
class Contributor {
    // properties
    private String firstName;
    private String lastName;
    private String country;
    private String phone;
    private Double contribution;
    private int id;

    Scanner scanner = new Scanner(System.in);

    // constructors
    public Contributor() {

    }

    public Contributor(String[] strAry) {
        this.firstName = strAry[0];
        this.lastName = strAry[1];
        this.country = strAry[2];
        this.phone = strAry[3];
        this.contribution = Double.parseDouble(strAry[4]);
        this.id = Integer.parseInt(strAry[5]);
    }

    public Contributor(String firstName, String lastName, String country, String phone, String contribution, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.phone = phone;
        this.contribution = Double.parseDouble(contribution);
        this.id = Integer.parseInt(id);
    }

    // methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public double getContribution() {
        return contribution;
    }

    public int getID() {
        return id;
    }

    public void addNewContributor(LinkedList ll) {
        System.out.println("\nCollecting New User Info");
        setFirstName();
        setLastName();
        setCountry();
        setPhone();
        setContribution();
        setID();
        addContributorToLinkedList(ll);
    }

    // ask console for first name of new contributor
    private void setFirstName() {
        System.out.println("What is the contributors first name?");
        firstName = scanner.next();
    }

    // ask console for last name of new contributor
    private void setLastName() {
        System.out.println("What is the contributors last name?");
        lastName = scanner.next();
    }

    // ask console for country of contributor
    private void setCountry() {
        System.out.println("What is the contributors country three digit code?");
        country = scanner.next();
    }

    // ask console for phone number of contributor
    private void setPhone() {
        System.out.println("What is the contributors phone number?");
        phone = scanner.next();
    }

    // ask console for contribution from contributor
    private void setContribution() {
        System.out.println("What is the contributors contribution dollar amount?");
        contribution = scanner.nextDouble();
    }

    // set the ID
    private void setID() {
        id++;
    }

    // add the new contributor info to the linked list
    private void addContributorToLinkedList(LinkedList ll) {
        ll.addLast(firstName + "," + lastName + "," + country + "," + phone + "," + contribution + "," + id);
    }

}
