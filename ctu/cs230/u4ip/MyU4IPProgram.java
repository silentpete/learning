import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class MyHelpers {
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

        help.loadCsvFile(csv, ll);
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
