// Assignment 3 Goals
// A Fully Documented Program to load the data creating a sorted linked list.
// A Test Plan to show how the program runs and can be executed.
// A screen shot showing that the program loaded the data. After all data is loaded perform a Print All showing the sorted list.

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

    // run to sort the linked list
    public void sortLinkedListByFirstNames() {
        String leftName;
        String[] firstNamesAry = getFirstNames();
        int numOfNames = firstNamesAry.length;
        for (int value1 = 0; value1 < numOfNames; value1++) {
            for (int value2 = value1 + 1; value2 < numOfNames; value2++) {
                // returns 0 if equal
                // returns less than 0 if value2 is greater
                // returns greater than 0 if value2 is less
                // if value1 comes back greater, swap the values
                if (firstNamesAry[value1].compareTo(firstNamesAry[value2]) > 0) {
                    // save the greater name
                    leftName = firstNamesAry[value1];
                    // set the value1 to what value2 is (the lesser value name)
                    firstNamesAry[value1] = firstNamesAry[value2];
                    // set value2 to the greater name
                    firstNamesAry[value2] = leftName;
                }
            }
        }

        LinkedList tmpLL = new LinkedList();

        for (int i = 0; i < numOfNames; i++) {
            String findName = firstNamesAry[i];
            for (int x = 0; x < numOfNames; x++) {
                String linkedListNodeData = getLinkedListNodeData(x);
                if (linkedListNodeData.contains(findName)) {
                    tmpLL.addLast(linkedListNodeData);
                }
            }
        }

        linkedList = tmpLL;
    }

    public void getNewContributorInfo() {
        setFirstName();
        setLastName();
        setCountry();
        setPhone();
        setContribution();
        setID();
        addContributorToLinkedList();
    }

    // print all the collected info in the linked list
    public void printContributorInfo() {
        System.out.println("\nPrint Contributor Info");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("- " + linkedList.get(i));
        }
    }

    // ask console for first name of new contributor
    private void setFirstName() {
        System.out.println("What is the contributors first name?");
        firstName = scanner.next();
    }

    // gets the first names out of all the linked list node data
    public String[] getFirstNames() {
        String[] names = new String[linkedList.size()];
        for (int i = 0; i < linkedList.size(); i++) {
            names[i] = getDataFirstName(getLinkedListNodeData(i));
        }

        return names;
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
        id = id++;
    }

    // add the new contributor info to the linked list
    private void addContributorToLinkedList() {
        linkedList.addLast(firstName + "," + lastName + "," + country + "," + phone + "," + contribution + "," + id);
    }

    private String getLinkedListNodeData(int index) {
        String linkedListNodeData = (String) linkedList.get(index);
        return linkedListNodeData;
    }

    private int getDataID(String linkedListNodeData) {
        String[] data = linkedListNodeData.split(",");

        return Integer.parseInt(data[5]);
    }

    private String getDataFirstName(String linkedListNodeData) {
        String[] nameElement = linkedListNodeData.split(",");
        return nameElement[0];
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

        // SORT
        System.out.println("\nSort linked-list");
        ci.sortLinkedListByFirstNames();

        // PRINT ALL INFO SO FAR
        ci.printContributorInfo();

        // MANUALLY ADD TO LINKED LIST
        System.out.println("\nManually add contributor to linked-list");
        ci.getNewContributorInfo();
        ci.sortLinkedListByFirstNames();

        // PRINT ALL INFO SO FAR
        ci.printContributorInfo();

        // CREATE HASHTABLE WITH 5 BUCKETS
        // int buckets = 5;
        // Hashtable ht = new Hashtable();
        // for (int i = 0; i < buckets; i++) {
        //     ht.put(i, new LinkedList());
        // }

        // LOAD HASHTABLE BUCKETS WITH ID's
        // ci.loadHashtable(ht);

        // PRINT BUCKETS
        // System.out.println("\nPrint Bucket Info");
        // for (int i = 0; i < buckets; i++) {
        //     System.out.println("bucket " + i + ": " + ht.get(i));
        // }

    }
}
