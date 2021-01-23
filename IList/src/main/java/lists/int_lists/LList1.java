package lists.int_lists;

import java.util.LinkedList;
import java.util.List;

public class LList1 implements IList {

    public class ListElement {
        ListElement next;
        int data;

        public ListElement(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private ListElement head = null;
    private int capacityCount = 0;



    @Override
    public void clear() {
        for (ListElement x = head; x != null; ) {
            ListElement next = x.next;
            x.data = 0;
            x.next = null;
            x = next;
        }
        head = null;
        capacityCount = 0;
    }

    @Override
    public int size() {
        return capacityCount;
    }

    @Override
    public int get(int index) {
        isIndexCorrect(index);
        int count = 0;
        ListElement last;
        last = head;
        int valueToReturn = 0;
        while (count <= index) {
            if (count == index) {
                valueToReturn = last.data;
                break;
            } else {
                last = last.next;
                count++;
            }
        }
        return valueToReturn;
    }

    @Override
    public boolean add(int value) {
        capacityCount++;
        ListElement newListElem = new ListElement(value);
        newListElem.next = null;
        ListElement last = head;
        if (head == null) {
            head = newListElem;
        } else {
            while (last.next != null) {
                last = last.next;
            }
            last.next = newListElem;
        }
        return true;
    }

    @Override
    public boolean add(int index, int value) {
        isIndexCorrect(index);
        capacityCount++;
        int count = 0;
        ListElement last;
        ListElement temp;
        ListElement newListElem = new ListElement(value);
        last = head;
        while (count <= index) {
            if (count == index - 1) {
                temp = last.next;
                last.next = newListElem;
                newListElem.next = temp;
                break;
            } else {
                last = last.next;
                count++;
            }
        }
        return true;
    }

    private void isIndexCorrect(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Указанный индекс некорректный.");
        }
    }

    @Override
    public int remove(int number) {
        ListElement prev = null;
        for (ListElement x = head; x != null; x = x.next) {
            if (number == x.data) {
                if (x == head){
                    head = x.next;
                } else {
                    prev.next = x.next;
                }
                capacityCount--;
                return x.data;
            }
            prev = x;
        }
        return 0;
    }

    @Override
    public int removeByIndex(int index) {
        isIndexCorrect(index);
        int count = 0;
        ListElement last;
        int valueToReturn = 0;
        last = head;
        while (count <= index) {
            if (count == index - 1) {
                valueToReturn = last.next.data;
                last.next = last.next.next;
                capacityCount--;
                break;
            } else {
                last = last.next;
                count++;
            }
        }
        return valueToReturn;
    }


    @Override
    public boolean contains(int value) {
        ListElement le = head;
        while (le != null){
            if (le.data == value){
                return true;
            }
            le = le.next;
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        isIndexCorrect(index);
        int count = 0;
        ListElement last;
        last = head;
        while (count <= index) {
            if (count == index) {
                last.data = value;
                break;
            } else {
                last = last.next;
                count++;
            }
        }
        return true;
    }

    @Override
    public void print() {
        String result = "[";
        ListElement last = head;
        for (int i = 0; i < size(); i++) {
            result += last.data;
            last = last.next;
            if (i != size() - 1) {
                result += ", ";
            }
        }
        result += "]";
        System.out.println(result);
    }

    @Override
    public int[] toArray() {
        int[] array = new int[size()];
        ListElement le = head;
        for (int i = 0; i < size(); i++) {
            array[i] = le.data;
            le = le.next;
        }
        return array;
    }

    @Override
    public boolean removeAll(int[] ar) {
        for (int i = 0; i < ar.length; i++){
            remove(ar[i]);
        }
        return true;
    }
}
