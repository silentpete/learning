import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class MyHelpers {
    Scanner scanner = new Scanner(System.in);
    public int highestID;

    public void loadCsvFile(String csv, LinkedList ll) {
        // properties
        String csvLine = "";

        // read in csv file
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            while ((csvLine = br.readLine()) != null) {
                String[] c = csvLine.split(",");
                addContributorSortedByLine(ll, c[0], c[1], c[2], c[3], Double.parseDouble(c[4]), Integer.parseInt(c[5]));
                setHigestID(ll, Integer.parseInt(c[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // keep track of the highest ID encountered
    public void setHigestID(LinkedList ll, int tmpid) {
        if (tmpid > highestID) {
            highestID = tmpid;
        }
    }

    // a new Contributor will have ID 0, checking for this
    public boolean zeroCheck(int tid) {
        if (tid == 0) {
            return true;
        }
        return false;
    }

    // changing the highest ID available, this is used for new Contributors to get the next highest ID
    public int setIDHighestAvail() {
        highestID++;
        return highestID;
    }

    // add contributor into the linkedlist sorted
    public void addContributorSortedByLine(LinkedList ll, String fn, String ln, String c, String pn, double con, int id ) {
        String contributorInfo = (fn + "," + ln + "," + c + "," + pn + "," + con + "," + id);
        if (ll.size() == 0) {
            ll.addFirst(contributorInfo);
            return;
        }
        for (int i = 0; i < ll.size(); i++) {
            String value = (String) ll.get(i);
            if (value.toLowerCase().compareTo(contributorInfo.toLowerCase()) > 0) {
                ll.add(i, contributorInfo);
                return;
            } else if (value.toLowerCase().compareTo(contributorInfo.toLowerCase()) < 0 && i == (ll.size()-1)) {
                ll.addLast(contributorInfo);
                return;
            }
        }
    }

    // check if the linked list given is empty
    public boolean checkLLEmpty(LinkedList ll) {
        // check if empty linked list
        if (ll.size() == 0) {
            System.out.println("\nNo Elements to remove");
            return true;
        }
        return false;
    }

    // pop (or remove) a contributor from a linked list
    public void popContributorFromLinkedList(LinkedList ll, String str) {
        ll.remove(str);
    }

    // print all information out of the linked list
    public void printLLAll(LinkedList ll) {
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }
    }

    // print all contributor information out of the linked list
    public void printLLAllContributorInfo(LinkedList ll) {
        System.out.println("\nContributor Information");
        if (ll.size() == 0) {
            System.out.println("(empty)");
        }
        printLLAll(ll);
    }

    // print all information out of the linked list with numbers next to them
    public void printLLAllWNum(LinkedList ll) {
        for (int i = 0; i < ll.size(); i++) {
            System.out.println((i + 1) + ". " + ll.get(i));
        }
    }

    // print a contributor from a linked list given the place it'll be found by index
    public void printContributorInfo(LinkedList ll, int indexInLL) {
        if (indexInLL == -1) {
            System.out.println("No contributor found.");
            return;
        }
        String line = (String) ll.get(indexInLL);
        Contributor c = new Contributor(line.split(","));
        System.out.println("\n" + c.getFirstName() + "'s Contributor Information\n" + "First Name: " + c.getFirstName() + "\n" + "Last Name: "
                + c.getLastName() + "\n" + "Country: " + c.getCountry() + "\n" + "Phone: " + c.getPhone() + "\n"
                + "Contribution: " + c.getContribution() + "\n" + "ID: " + c.getID());
    }

    // print out the given linked list, ask by prompt which contributor info would like to print out
    public void printContributorFromLinkedList(LinkedList ll) {
        // check if empty linked list
        if (ll.size() == 0) {
            System.out.println("(empty)");
            return;
        }

        System.out.println("\nWhich contributor info would you like to print?");
        printLLAllWNum(ll);
        int printContributor = scanner.nextInt();
        if (printContributor > ll.size() || printContributor <= 0) {
            System.out.println("not a valid number: " + printContributor);
            return;
        }
        printContributorInfo(ll, (printContributor-1));
    }

    // print out all contributor information
    public void printContributorsFromLinkedList(LinkedList ll) {
        System.out.println("\nAll Contributor Information");
        for (int i = 0; i < ll.size(); i++) {
            printContributorInfo(ll, i);
        }
    }

    // find an id of a contributor in the linked list
    public String findContributorInfoByID(LinkedList ll, int fid) {
        for (int i = 0; i < ll.size(); i++) {
            String cInfo = (String) ll.get(i);
            Contributor tmpc = new Contributor(cInfo.split(","));

            if (tmpc.getID() == fid) {
                return cInfo;
            }
        }
        return "";
    }

    // find an name of a contributor in the linked list
    public int findContributorByName(LinkedList ll, String name) {
        for (int i = 0; i < ll.size(); i++) {
            String cInfo = (String) ll.get(i);
            Contributor tmpc = new Contributor(cInfo.split(","));

            if (tmpc.getFirstName().toLowerCase().contains(name.toLowerCase()) || tmpc.getLastName().toLowerCase().contains(name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    // find contributor by id
    public int findContributorByID(LinkedList ll, int cid) {
        for (int i = 0; i < ll.size(); i++) {
            String cInfo = (String) ll.get(i);
            Contributor tmpc = new Contributor(cInfo.split(","));

            if (tmpc.getID() == cid || tmpc.getID() == cid) {
                return i;
            }
        }
        return -1;
    }
}
