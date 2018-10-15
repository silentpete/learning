import java.util.Scanner;

// Assignment Goals
// A fully documented program to load the data implemented as a stack
// A test plan to show how the program runs and can be executed
// A screenshot showing that the program loaded the data, and after all data is loaded, perform a single pop of the stack

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class LinkedList {
    Node head;
    int count;

    // add an item to the end of the linked list
    public void appendToLinkedList(String data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    // add an item to the front of the linked list
    public void prependToLinkedList(String data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    // delete a an item from the linked list (note: item is still in memory though)
    public void deleteNodeWithValueFromLinkedList(String data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // set the count of the number of nodes
    public void setCount() {
        count = 0;
        if (head == null) return;

        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
    }

    // print everything in the linked list
    public void printLinkedListData() {
        setCount();
        if (head == null) return;

        System.out.println("");
        System.out.println("All Linked-List Data");

        Node current = head;
        for (int i = 0; i < count; i++) {
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("");
    }
}

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
        linkedList.appendToLinkedList(firstName+","+lastName+","+country+","+phone+","+contribution+","+id);
    }
}

class Start {
    public static void main(String[] args) {
        // properties
        String csvFile = "contributors.csv";
        String csvLine = "";
        // String cvsSeparator = ","; // need to use this later to seperate the items in each node, or same the node item as an array.

        // CREATE LINKED LIST
        LinkedList ll = new LinkedList();

        // READ IN CSV FILE
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((csvLine = br.readLine()) != null) {
                String contributor = csvLine;
                // add each line in csv file as linked list node item
                ll.appendToLinkedList(contributor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // PRINT ALL INFO SO FAR
        ll.printLinkedListData();

        // MANUALLY ADD TO LIST
        System.out.println("Add contributor to linked-list");
        ContributorInfo ci = new ContributorInfo(ll);
        ci.getNewContributorInfo();

        // PRINT ALL INFO SO FAR
        ll.printLinkedListData();

        // REMOVE A NODE
        System.out.println("pop Tim Murphy");
        ll.deleteNodeWithValueFromLinkedList("Tim,Murphy,USA,8285557865,200,25");

        // PRINT ALL INFO SO FAR
        ll.printLinkedListData();
    }
}
