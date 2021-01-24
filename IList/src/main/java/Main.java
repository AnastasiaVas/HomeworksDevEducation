import lists.int_lists.impl.LList2;

import java.util.LinkedList;

public class Main {
    public static void main (String args[]){
        LList2 lList2 = new LList2();
        lList2.add(1);
        lList2.add(2);
        lList2.add(3);
        lList2.add(4);
        lList2.add(5);
        lList2.add(6);
        lList2.print();
        lList2.remove(4);
        lList2.print();
        lList2.removeByIndex(1);
        lList2.print();
    }
}
