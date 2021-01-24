package lists.int_lists.impl;

import lists.int_lists.IList;
import utils.Constants;

import java.util.LinkedList;

public class LList2 implements IList {

    class ListElement {
        int data;
        ListElement next;
        ListElement prev;

        public ListElement(ListElement prev, int data, ListElement next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListElement head = null;
    private ListElement tail = null;
    private int capacityCount = 0;

    private ListElement findElem(int index) {
        if (index < (capacityCount >> 1)) {
            ListElement le = head;
            for (int i = 0; i < index; i++)
                le = le.next;
            return le;
        } else {
            ListElement le = tail;
            for (int i = capacityCount - 1; i > index; i--)
                le =le.prev;
            return le;
        }
    }

    @Override
    public void clear() {
        for (ListElement x = head; x != null; ) {
            ListElement next = x.next;
            x.data = 0;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        capacityCount = 0;
    }

    @Override
    public int size() {
        return capacityCount;
    }

    @Override
    public int get(int index) {
        isIndexCorrect(index);
        return findElem(index).data;
    }

    private void isIndexCorrect(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(Constants.INCORRECT_INDEX);
        }
    }

    @Override
    public boolean add(int value) {
        final ListElement last = tail;
        final ListElement newLE = new ListElement(last, value, null);
        tail = newLE;
        if (last == null)
            head = newLE;
        else
            last.next = newLE;
        capacityCount++;
        return true;
    }

    @Override
    public boolean add(int index, int value) {
        isIndexCorrect(index);
        if (index == capacityCount){
            add(value);
        } else {
            ListElement le = findElem(index);
            final ListElement prev = le.prev;
            final ListElement newLE = new ListElement (prev, value, le);
            le.prev = newLE;
            if (prev == null)
                head = newLE;
            else
                prev.next = newLE;
            capacityCount++;
        }
        return true;
    }

    @Override
    public int remove(int number) {
        for (ListElement le = head; le != null; le = le.next) {
            if (number == le.data) {
                return removeByListElement(le);
            }
        }
        return 0;
    }

    @Override
    public int removeByIndex(int index) {
        isIndexCorrect(index);
        return removeByListElement(findElem(index));
    }

    private int removeByListElement(ListElement le){
        final int element = le.data;
        final ListElement next = le.next;
        final ListElement prev = le.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            le.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            le.next = null;
        }
        capacityCount--;
        return element;
    }

    @Override
    public boolean contains(int value) {
        for (ListElement le = head; le != null; le = le.next) {
            if (value == le.data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        isIndexCorrect(index);
        ListElement le = findElem(index);
        int oldVal = le.data;
        le.data = value;
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
        for (int j : ar) {
            remove(j);
        }
        return true;
    }
}
