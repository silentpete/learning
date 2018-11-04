
import java.util.*;

// Contributor is used for Zoo collection and processing methods.
class Contributor {
    // fields
    private String firstName;
    private String lastName;
    private String country;
    private String phone;
    private Double contribution;
    private int id;

    Scanner scanner = new Scanner(System.in);

    // constructors
    public Contributor() {
        id = 0;
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
    // return the contributors firstname
    public String getFirstName() {
        return firstName;
    }

    // return the Contributors last name
    public String getLastName() {
        return lastName;
    }

    // return the Contributors country
    public String getCountry() {
        return country;
    }

    // return the Contributors phone
    public String getPhone() {
        return phone;
    }

    // return the Contributors contribution
    public double getContribution() {
        return contribution;
    }

    // return the Contributors id
    public int getID() {
        return id;
    }

    // combine all the steps to add a new Contributor
    public void setNewContributor() {
        System.out.println("\nCollecting New User Info");
        setFirstName();
        setLastName();
        setCountry();
        setPhone();
        setContribution();
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
    public void setID(int sid) {
        id = sid;
    }

}
