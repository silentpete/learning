// Assignment Goals
// A fully documented program to load the Hash table with collisions being handled as a linked list, implemented as a Stack
// A test plan to show how the program runs and can be executed
// A screenshot showing that the program loaded the data, and after all data is loaded, shows the contents of the first Hash bucket (ideally this is Bucket 0)

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Node {
    // properties
    Node next;
    String data;

    // constructors
    public Node(String data) {
        this.data = data;
    }
}

class ContributorInfo {
    // properties
    LinkedList linkedList;
    String firstName;
    String lastName;
    String country;
    String phone;
    int contribution;
    int id = 1;
    Scanner scanner = new Scanner(System.in);

    // constructors
    public ContributorInfo(LinkedList ll) {
        linkedList = ll;
    }

    // methods
    public void loadCsvFile(String csvFile) {
        // properties
        // String csvFile = csvFile;
        String csvLine = "";
        // String cvsSeparator = ","; // need to use this later to seperate the items in each node, or same the node item as an array.

        // READ IN CSV FILE
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((csvLine = br.readLine()) != null) {
                String contributor = csvLine;
                // add each line in csv file as linked list node item
                linkedList.addLast(contributor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHashtable(Hashtable ht) {
        for (int i = 0; i < linkedList.size(); i++) {
            int id = getDataID(getLinkedListNodeData(i));
            int mod = id % 5;
            LinkedList lltmp = (LinkedList) ht.get(mod);
            lltmp.addLast(id);
        }
    }

    public void getNewContributorInfo() {
        getFirstName();
        getLastName();
        getCountry();
        getPhone();
        getContribution();
        setID();
        addContributorToLinkedList();
    }

    public void printContributorInfo() {
        System.out.println("\nPrint Contributor Info");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("- " + linkedList.get(i));
        }
    }

    // ask console for first name of new contributor
    private void getFirstName() {
        System.out.println("What is the contributors first name?");
        firstName = scanner.next();
    }

    // ask console for last name of new contributor
    private void getLastName() {
        System.out.println("What is the contributors last name?");
        lastName = scanner.next();
    }

    // ask console for country of contributor
    private void getCountry() {
        System.out.println("What is the contributors country three digit code?");
        country = scanner.next();
    }

    // ask console for phone number of contributor
    private void getPhone() {
        System.out.println("What is the contributors phone number?");
        phone = scanner.next();
    }

    // ask console for contribution from contributor
    private void getContribution() {
        System.out.println("What is the contributors contribution dollar amount?");
        contribution = scanner.nextInt();
    }

    // set the ID
    private void setID() {
        id = id++;
    }

    // add the new contributor info to the linked list
    private void addContributorToLinkedList() {
        linkedList.addLast(firstName + "," + lastName + "," + country + "," + phone + "," + contribution + "," + id);
    }

    private String getLinkedListNodeData(int index) {
        String linkedListItem = (String) linkedList.get(index);
        return linkedListItem;
    }

    private int getDataID(String linkedListData) {
        String[] data = linkedListData.split(",");
        // System.out.println("ID: " + data[5]);

        return Integer.parseInt(data[5]);
    }
}

class Start {
    public static void main(String[] args) {
        // CREATE LINKED LIST USING UTIL.LINKEDLIST SHOWN IN TEACHER EXAMPLE
        LinkedList ll = new LinkedList();

        // IMPORT CSV
        ContributorInfo ci = new ContributorInfo(ll);
        System.out.println("\nLoad CSV");
        ci.loadCsvFile("contributors.csv");

        // PRINT ALL INFO SO FAR
        ci.printContributorInfo();

        // MANUALLY ADD TO LINKED LIST
        System.out.println("\nManually add contributor to linked-list");
        ci.getNewContributorInfo();

        // PRINT ALL INFO SO FAR
        ci.printContributorInfo();

        // CREATE HASHTABLE WITH 5 BUCKETS
        int buckets = 5;
        Hashtable ht = new Hashtable();
        for (int i = 0; i < buckets; i++) {
            ht.put(i, new LinkedList());
        }

        // LOAD HASHTABLE BUCKETS WITH ID's
        ci.loadHashtable(ht);

        // PRINT BUCKETS
        System.out.println("\nPrint Bucket Info");
        for (int i = 0; i < buckets; i++) {
            System.out.println("bucket " + i + ": " + ht.get(i));
        }

    }
}
