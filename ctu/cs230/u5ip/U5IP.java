
// The design document that includes the recursion example.
// A fully documented program to load the data creating a sorted linked list.
// A test plan to show how the program runs and can be executed
// A screenshot showing that the program loaded the data, and after all data is loaded perform the following:
//     Print All showing the sorted list.
//     Contributor information for Georg Pipps
//     Contributor information for ID 25
//     An analysis of the differences in performance of the Sequential Search versus the Binary Search

import java.util.*;

class U5IP {
    public static void main(String[] args) {
        // CREATE LINKED LIST USING UTIL.LINKEDLIST SHOWN IN TEACHER EXAMPLE
        LinkedList ll = new LinkedList();

        // bring in my helpers
        MyHelpers help = new MyHelpers();

        // load the contributors.csv file
        String csv = "contributors.csv";
        help.loadCsvFile(csv, ll);

        // How many buckets in the Hashtable
        int buckets = 5;
        // Create A Hashtable of Linked List buckets
        Hashtable ht = new Hashtable();
        for (int i = 0; i < buckets; i++) {
            ht.put(i, new LinkedList());
        }

        // bring in my hash helpers
        MyHashHelpers hashHelp = new MyHashHelpers();

        // load the contributors ID's into the hashtable
        hashHelp.loadHashtable(ht, ll);

        // the program prompt
        String prompt = "\nPlease select an action:\n"
        + "1. Print out all contributor information\n"
        + "2. Add a new contributor\n"
        + "3. Remove a contributor by record\n"
        + "4. Print out one contributor info\n"
        + "5. Print out all contributor info\n"
        + "6. Print out ID hashtable\n"
        + "7. Remove contributor by ID\n"
        + "8. Find contributor by name [first or last]\n"
        + "9. Find contributor by ID\n"
        + "99. Exit program";

        // create a scanner to be used for the program inputs
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println(prompt);
            int result = scanner.nextInt();
            switch (result) {
            case 1:
                help.printLLAllContributorInfo(ll);
                break;
            case 2:
                Contributor c = new Contributor();
                c.setNewContributor();
                help.setHigestID(ll, c.getID());
                if (help.zeroCheck(c.getID())) {
                    int num = help.setIDHighestAvail();
                    c.setID(num);
                }
                help.addContributorSortedByLine(ll, c.getFirstName(), c.getLastName(), c.getCountry(), c.getPhone(),
                        c.getContribution(), c.getID());
                hashHelp.addIDToHashtable(ht, c);
                break;
            case 3:
                if (!help.checkLLEmpty(ll)) {
                    System.out.println("\nWhich contributor would you like to remove?");
                    help.printLLAllWNum(ll);
                    int rmContributor = scanner.nextInt();
                    String contribInfo = (String) ll.get(rmContributor - 1);
                    Contributor tmpc = new Contributor(contribInfo.split(","));
                    System.out.println("\nremoving: " + tmpc.getFirstName());
                    help.popContributorFromLinkedList(ll, contribInfo);
                    hashHelp.popIDFromHashtable(ht, tmpc.getID());
                }
                break;
            case 4:
                help.printContributorFromLinkedList(ll);
                break;
            case 5:
                help.printContributorsFromLinkedList(ll);
                break;
            case 6:
                hashHelp.printHashtable(ht);
                break;
            case 7:
                if (!hashHelp.checkHTEmpty(ht)) {
                    System.out.println("\nWhich ID would you like to remove?");
                    hashHelp.printHashtableOneNumPerLine(ht);
                    int rmID = scanner.nextInt();
                    hashHelp.popIDFromHashtable(ht, rmID);
                    String cInfo = help.findContributorInfoByID(ll, rmID);
                    if (cInfo.isEmpty()) {
                        System.out.println("Could not find ID in Linked List");
                        break;
                    }
                    help.popContributorFromLinkedList(ll, cInfo);
                }
                break;
            case 8:
                System.out.println("\nWhich contributor are you looking for?");
                String findName = scanner.next();
                int nIndex = help.findContributorByName(ll, findName);
                help.printContributorInfo(ll, nIndex);
                break;
            case 9:
                System.out.println("\nWhich ID are you looking for?");
                int findID = scanner.nextInt();
                int iIndex = help.findContributorByID(ll, findID);
                help.printContributorInfo(ll, iIndex);
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
