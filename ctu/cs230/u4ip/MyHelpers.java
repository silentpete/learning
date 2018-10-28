import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class MyHelpers {
    Scanner scanner = new Scanner(System.in);

    public void loadCsvFile(String csv, LinkedList ll) {
        // properties
        String csvLine = "";

        // read in csv file
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            while ((csvLine = br.readLine()) != null) {
                String contributor = csvLine;
                // add each line in csv file as linked list node item
                // Contributor tmpc = new Contributor(csvLine.split(","));
                // System.out.println(tmpc.getFirstName());
                ll.addLast(contributor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public void printContributorInfo(LinkedList ll, int indexInLL) {
        String line = (String) ll.get(indexInLL);
        Contributor c = new Contributor(line.split(","));
        System.out.println("\n" + c.getFirstName() + "'s Contributor Information\n" + "First Name: " + c.getFirstName() + "\n" + "Last Name: "
                + c.getLastName() + "\n" + "Country: " + c.getCountry() + "\n" + "Phone: " + c.getPhone() + "\n"
                + "Contribution: " + c.getContribution() + "\n" + "ID: " + c.getID());
    }

    public void printContributorFromLinkedList(LinkedList ll) {
        // check if empty linked list
        if (ll.size() == 0) {
            System.out.println("(empty)");
        }

        System.out.println("\nWhich contributor info would you like to print?");
        printLLAllWNum(ll);
        int printContributor = scanner.nextInt();
        printContributorInfo(ll, (printContributor-1));
    }

    public void printContributorsFromLinkedList(LinkedList ll) {
        System.out.println("\nAll Contributor Information");
        for (int i = 0; i < ll.size(); i++) {
            printContributorInfo(ll, i);
        }
    }

    public String findContributorInfoByID(LinkedList ll, int id) {
        for (int i = 0; i < ll.size(); i++) {
            String cInfo = (String) ll.get(i);
            Contributor tmpc = new Contributor(cInfo.split(","));
            if (tmpc.getID() == id) {
                return cInfo;
            }
        }
        return "";
    }
}
