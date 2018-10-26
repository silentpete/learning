import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    // methods
    public void loadCsvFile(String csv, LinkedList ll) {
        // properties
        String csvLine = "";

        // read in csv file
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            while ((csvLine = br.readLine()) != null) {
                String contributor = csvLine;
                // add each line in csv file as linked list node item
                ll.addLast(contributor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

class MyHelpers {
    public void printLL(LinkedList ll) {
        System.out.println("\nContributor Information");
        if (ll.size() == 0) {
            System.out.println("(empty)");
        }
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }
    }

    // public void insertionSortLL(LinkedList ll) {
    //     LinkedList tmpLL = new LinkedList();
    //     (String) linkedList.get(index);
    // }

    // public void hashtableOfIDs() {}
}

class MyU4IPProgram {
    public static void main(String[] args) {
        String csv = "contributors.csv";
        // CREATE LINKED LIST USING UTIL.LINKEDLIST SHOWN IN TEACHER EXAMPLE
        LinkedList ll = new LinkedList();
        Contributor c = new Contributor();
        MyHelpers help = new MyHelpers();
        Scanner scanner = new Scanner(System.in);

        String prompt =
        "\nPlease select an action:\n"
        + "1. Print out the contributor information\n"
        + "2. Add a new contributor\n"
        + "3. Remove a contributor\n"
        + "9. Exit program";

        c.loadCsvFile(csv, ll);
        Collections.sort(ll);
        boolean loop = true;
        while (loop) {
            System.out.println(prompt);
            String answer = scanner.next();
            int result = Integer.parseInt(answer);
            switch (result) {
            case 1:
                help.printLL(ll);
                break;
            case 2:
                c.getNewContributorInfo(ll);
                break;
            case 3:
                c.removeContributorFromLinkedList(ll);
                break;
            default:
                System.out.println("\nExiting!");
                loop = false;
                break;
            }
        }
        scanner.close();

    }
}
