// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
import java.util.*;

// Contributor is used for Zoo collection and processing methods.
// - loadCsvFile
// - getNewContributorInfo
class Contributor {
    // properties
    String firstName;
    String lastName;
    String country;
    String phone;
    int contribution;
    int id;

    Scanner scanner = new Scanner(System.in);

    // constructors
    // public Contributor(String firstName, String lastName, String country, String phone, int contribution, int id) {
    //   firstName = firstName;
    //   lastName = lastName;
    //   country = country;
    //   phone = phone;
    //   contribution = contribution;
    //   id = id;
    // }
    // methods
    public void getNewContributorInfo(LinkedList ll) {
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
        contribution = scanner.nextInt();
    }

    // set the ID
    private void setID() {
        id++;
    }

    // add the new contributor info to the linked list
    private void addContributorToLinkedList(LinkedList ll) {
        ll.addLast(firstName + "," + lastName + "," + country + "," + phone + "," + contribution + "," + id);
    }

    public void removeContributorFromLinkedList(LinkedList ll) {
        if (ll.size() == 0) {
            System.out.println("\nNo Elements to remove");
            return;
        }
        System.out.println("Which contributor would you like to remove?");
        for (int i = 0; i < ll.size(); i++) {
            System.out.println((i+1) + ". " + ll.get(i));
        }

        int rmContributor = scanner.nextInt();
        System.out.println("removing " + rmContributor);
        ll.remove(rmContributor - 1);
    }
}
