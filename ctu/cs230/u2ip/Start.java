import java.util.Scanner;

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
    int id = 100;
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

    public void getNewContributorInfo() {
        getFirstName();
        getLastName();
        getCountry();
        getPhone();
        getContribution();
        setID();
        addContributorToLinkedList();
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
        linkedList.addLast(firstName+","+lastName+","+country+","+phone+","+contribution+","+id);
    }
}

class Start {
    public static void main(String[] args) {
        // CREATE LINKED LIST USING UTIL.LINKEDLIST SHOWN IN TEACHER EXAMPLE
        LinkedList ll = new LinkedList();

        ContributorInfo ci = new ContributorInfo(ll);

        // IMPORT CSV
        ci.loadCsvFile("contributors.csv");

        // PRINT ALL INFO SO FAR
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }

        Hashtable ht = new Hashtable();
        System.out.println(ht.size());
        ht.put(0, new LinkedList());
        System.out.println(ht.size());
        System.out.println(ht.);
        // CREATE HASH TABLE
        // Node[] hashtable = new Node[5];
        // for (int i = 0; i < hashtable.length; i++) {
        //     System.out.println("bucket " + i + ": " + hashtable[i]);
        // }

        // for (int i = 0; i < hashtable.length; i++) {
        //     Node tmp = new Node(Integer.toString(i));
        //     hashtable[i] = tmp;
        // }

        // for (int i = 0; i < hashtable.length; i++) {
        //     System.out.println("bucket " + i + ": " + hashtable[i]);
        // }

        // MANUALLY ADD TO LINKED LIST
        // System.out.println("Add contributor to linked-list");
        // ci.getNewContributorInfo();

        // PRINT ALL INFO SO FAR
        // ll.printLinkedListData();

        // REMOVE A NODE
        // System.out.println("pop Tim Murphy");
        // ll.deleteNodeWithValueFromLinkedList("Tim,Murphy,USA,8285557865,200,25");

        // PRINT ALL INFO SO FAR
        // ll.printLinkedListData();
    }
}
