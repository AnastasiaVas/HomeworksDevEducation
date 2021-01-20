package lists.impl;

import lists.IList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AList1 implements IList {

    int[] array;
    int capacityCount;

    public AList1(){
        this.array = new int[10];
    }

    public AList1(int capacity){
        this.array = new int[capacity];
    }

    public AList1(int[] array){
        this.array = array;
    }




    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++){
            array[i] = 0;
        }
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public boolean add(int value) {
        ensureCapacity();
        array[capacityCount] = value;
        return true;
    }

    private void ensureCapacity() {
        capacityCount++;
        int oldCapacity = array.length;
        if (capacityCount > oldCapacity){
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    @Override
    public boolean add(int index, int value) {
        isIndexCorrect(index);
        ensureCapacity();
        array = Arrays.copyOfRange(array, 0, index);
        array[index] = value;
        array = Arrays.copyOfRange(array, index + 1, array.length);
        return true;
    }

    private void isIndexCorrect(int index){
        if (index < 0 || index >= array.length){
            throw new IndexOutOfBoundsException("Указанный индекс некорректный.");
        }
    }

    @Override
    public int remove(int number) {
        for (int i = 0; i < array.length; i++){
            if (array[i] == number){
                removeByIndex(i);
            }
        }
        return 0;
    }

    @Override
    public int removeByIndex(int index) {
        isIndexCorrect(index);
        int removedValue = array[index];
        array = Arrays.copyOfRange(array, 0, index);
        array = Arrays.copyOfRange(array, index + 1, array.length);
        return removedValue;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < array.length; i++){
            if (array[i] == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        isIndexCorrect(index);
        Array.set(array, index, value);
        return true;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(array));
    }

    @Override
    public int[] toArray() {
        return array;
    }

    @Override
    public boolean removeAll(int[] ar) {
        for (int i = 0; i < array.length; i++){
            array[i] = 0;
        }
        return true;
    }
}
