import java.util.*;

class MyHashHelpers {

    // load the hashtable from the linked list, which was loaded from the csv file
    public void loadHashtable(Hashtable ht, LinkedList ll) {
        for (int i = 0; i < ll.size(); i++) {
            String contributor = (String) ll.get(i);
            Contributor c = new Contributor(contributor.split(","));
            addIDToHashtable(ht, c);
        }
    }

    // add a new contributor to the hashtable in the correct bucket
    public void addIDToHashtable(Hashtable ht, Contributor c) {
        int id = c.getID();
        int mod = id % 5;
        LinkedList lltmp = (LinkedList) ht.get(mod);
        lltmp.addLast(c);
    }

    // pop (or remove) the ID passed from the the hashtable
    public void popIDFromHashtable(Hashtable ht, int id) {
        int mod = id % 5;
        LinkedList lltmp = (LinkedList) ht.get(mod);
        for (int i = 0; i < lltmp.size(); i++) {
            Contributor c = (Contributor) lltmp.get(i);
            if (c.getID() == id) {
                lltmp.remove(i);
            }
        }
    }

    // print the hashtable content one bucket linked list item at a time
    public void printHashtableOneNumPerLine(Hashtable ht) {
        for (int i = 0; i < ht.size(); i++) {
            LinkedList ll = (LinkedList) ht.get(i);
            for (int j = 0; j < ll.size(); j++) {
                Contributor c = (Contributor) ll.get(j);
                System.out.println(c.getID());
            }
        }
    }

    // check if the hashtable is empty
    public boolean checkHTEmpty(Hashtable ht) {
        if (ht.size() == 0) {
            return true;
        }
        return false;
    }

    // print everything in the hashtable
    public void printHashtable(Hashtable ht) {
        System.out.println("\nContributor ID's Hashtable");
        for (int i = 0; i < ht.size(); i++) {
            LinkedList ll = (LinkedList) ht.get(i);
            int[] ids = new int[ll.size()];
            for (int j = 0; j < ll.size(); j++) {
                Contributor c = (Contributor) ll.get(j);
                ids[j] = c.getID();
            }
            System.out.print("bucket " + i + ": ");
            for (int k = 0; k < ids.length; k++) {
                System.out.print(ids[k]);
                if (k != ids.length) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

}
