// High Level Implementation Instructions:

//     Sorted Linked list
//     Sorted using Insertion sort
//     Hash bucket of size 5 with a collision solution using a linked list (no need to order)
//     A Search Algorithm based on ID and Contributor Name.
//         The Contributor Name Algorithm needs to be implemented using the Sequential Search

// Contributor functions/methods:

//     Input constructor: //to accept a string for the name and additional information for each contributor (this should call the Add constructor to implement the sorted list)
//     Print constructor: //to print out the contributor data
//     Print All constructor: //to print the entire list of contributor names
//     Add constructor: //to traverse the Linked list and find the proper location for adding the instance
//     Search constructor: //the Search algorithm to implement is Sequential Search

// Each hash bucket collision item will have the following information:

//     ID: Integer; //identifier key for future needs
//     Contributor Address: Pointer; //a pointer to the address of the contributor instance in the sorted linked list

// Hash bucket functions/methods:

//     Input constructor: //to accept a string for the name and additional information for each contributor (you will only need the ID portion of the input data)
//     Hash Function constructor: //Hint: You only have 5 Hash buckets so the function can be very a simple calculation
//     Pop constructor
//     Push constructor
//     Print constructor: //to show the information of the contributor based on a given ID

// Deliverables:

//     The design saved in a Key Assignment Draft that does not include any actual code and will be submitted as the deliverable in the next discussion board.
//     A fully documented program to load the data creating a sorted linked list.
//     A test plan to show how the program runs and can be executed.
//     A screenshot showing that the program loaded the data, and after all data is loaded perform the following:
//         Print All showing the sorted list.
//         Contributor information for Georg Pipps
//         Contributor information for ID 25

import java.util.*;

class U4IP {
    public static void main(String[] args) {
        // CREATE LINKED LIST USING UTIL.LINKEDLIST SHOWN IN TEACHER EXAMPLE
        LinkedList ll = new LinkedList();
        Contributor c = new Contributor();
        MyHelpers help = new MyHelpers();
        MyHashHelpers hashHelp = new MyHashHelpers();
        Scanner scanner = new Scanner(System.in);

        String prompt =
        "\nPlease select an action:\n"
        + "1. Print out all contributor information\n"
        + "2. Add a new contributor\n"
        + "3. Remove a contributor\n"
        + "4. Print out one contributor info\n"
        + "5. Print out all contributor info\n"
        + "6. Print out ID hashtable\n"
        + "9. Exit program";

        // load the contributors.csv file
        String csv = "contributors.csv";
        help.loadCsvFile(csv, ll);

        // Sort
        // TODO: create our own sort I guess
        Collections.sort(ll);

        // How many buckets in the Hashtable
        int buckets = 5;
        // Create A Hashtable of Linked List buckets
        Hashtable llht = new Hashtable();
        for (int i = 0; i < buckets; i++) {
            llht.put(i, new LinkedList());
        }
        // load the contributors ID's into the hashtable
        hashHelp.loadHashtable(llht, ll);

        boolean loop = true;
        while (loop) {
            System.out.println(prompt);
            String answer = scanner.next();
            int result = Integer.parseInt(answer);
            switch (result) {
            case 1:
                help.printLLAllContributorInfo(ll);
                break;
            case 2:
                c.addNewContributor(ll);
                hashHelp.addIDToHashtable(llht, c.getFirstName(), c.getLastName(), c.getCountry(), c.getPhone(), c.getContribution(), c.getID());
                break;
            case 3:
                if (!help.checkLLEmpty(ll)) {
                    System.out.println("\nWhich contributor would you like to remove?");
                    help.printLLAllWNum(ll);
                    int rmContributor = scanner.nextInt();
                    String contribInfo = (String) ll.get(rmContributor-1);
                    Contributor tmpc = new Contributor(contribInfo.split(","));
                    System.out.println("\nremoving: " + tmpc.getFirstName());
                    help.popContributorFromLinkedList(ll, contribInfo);
                    hashHelp.popIDFromHashtable(llht, tmpc.getID());
                }
                break;
            case 4:
                help.printContributorFromLinkedList(ll);
                break;
            case 5:
                help.printContributorsFromLinkedList(ll);
                break;
            case 6:
                hashHelp.printHashtable(llht);
                break;
            case 7:
                if (!hashHelp.checkHTEmpty(llht)) {
                    System.out.println("\nWhich ID would you like to remove?");
                    hashHelp.printHashtableOneNumPerLine(llht);
                    int rmID = scanner.nextInt();
                    hashHelp.popIDFromHashtable(llht, rmID);
                    String cInfo = help.findContributorInfoByID(ll, rmID);
                    if (cInfo.isEmpty()) {
                        System.out.println("Could not find ID in Linked List");
                        return;
                    }
                    help.popContributorFromLinkedList(ll, cInfo);
                }
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
