import java.util.*;

class MyHashHelpers {

    public void loadHashtable(Hashtable llht, LinkedList ll) {
        for (int i = 0; i < ll.size(); i++) {
            String contributor = (String) ll.get(i);
            Contributor c = new Contributor(contributor.split(","));
            addIDToHashtable(llht, c.getFirstName(), c.getLastName(), c.getCountry(), c.getPhone(), c.getContribution(), c.getID());
        }
    }

    public void addIDToHashtable(Hashtable llht, String s0, String s1, String s2, String s3, Double d4, int i5) {
        int id = i5;
        int mod = id % 5;
        LinkedList lltmp = (LinkedList) llht.get(mod);
        lltmp.addLast(id);
    }

    // pop (or remove) the ID passed from the the hashtable
    public void popIDFromHashtable(Hashtable llht, int id) {
        int mod = id % 5;
        LinkedList lltmp = (LinkedList) llht.get(mod);
        for (int i = 0; i < lltmp.size(); i++) {
            if ((Integer) lltmp.get(i) == id) {
                lltmp.remove(i);
            }
        }
    }

    public void printHashtableOneNumPerLine(Hashtable llht) {
        for (int i = 0; i < llht.size(); i++) {
            LinkedList bucketll = (LinkedList) llht.get(i);
            for (int j = 0; j < bucketll.size(); j++) {
                System.out.println(bucketll.get(j));
            }
        }
    }

    public boolean checkHTEmpty(Hashtable llht) {
        if (llht.size() == 0) {
            return true;
        }
        return false;
    }

    public void printHashtable(Hashtable llht) {
        System.out.println("\nContributor ID's Hashtable");
        for (int i = 0; i < llht.size(); i++) {
            System.out.println("bucket " + i + ": " + llht.get(i));
        }
    }

}
