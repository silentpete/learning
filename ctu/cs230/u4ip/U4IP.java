
// The design saved in a Key Assignment Draft that does not include any actual code and will be submitted as the deliverable in the next discussion board.
// A fully documented program to load the data creating a sorted linked list.
// A test plan to show how the program runs and can be executed.
// A screenshot showing that the program loaded the data, and after all data is loaded perform the following:
//     Print All showing the sorted list.
//     Contributor information for Georg Pipps
//     Contributor information for ID 25

import java.util.*;

class U4IP {
    public static void main(String[] args) {
        // CREATE LINKED LIST USING UTIL.LINKEDLIST SHOWN IN TEACHER EXAMPLE
        LinkedList ll = new LinkedList();
        MyHelpers help = new MyHelpers();
        MyHashHelpers hashHelp = new MyHashHelpers();
        Scanner scanner = new Scanner(System.in);

        String prompt =
        "\nPlease select an action:\n"
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
                Contributor c = new Contributor();
                c.setNewContributor();
                help.setHigestID(ll, c.getID());
                if (help.zeroCheck(c.getID())) {
                    int num = help.setIDHighestAvail();
                    c.setID(num);
                }
                help.addContributorSortedByLine(ll, c.getFirstName(), c.getLastName(), c.getCountry(), c.getPhone(), c.getContribution(), c.getID());
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
