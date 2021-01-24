package lists.generic_lists.impl;

import lists.generic_lists.IListGenerics;
import utils.Constants;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AList2<T> implements IListGenerics<T> {

    int capacityCount;
    T[] array;
    private static final int DEFAULT_CAPACITY = 10;

    public AList2(){
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public AList2(int capacity){
        array = (T[]) new Object[capacity];
    }

    public AList2(T[] array){
        this.array = array;
    }




    @Override
    public void clear() {
        array = null;
    }

    @Override
    public int size() {
        return capacityCount;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public boolean add(T value) {
        if (capacityCount >= array.length) {
            ensureCapacity();
        }
        array[capacityCount++] = value;
        return true;
    }

    private void ensureCapacity() {
        int oldCapacity = array.length;
        if (capacityCount >= oldCapacity){
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            T[] newArray = (T[]) new Object[newCapacity];
            for (int i = 0; i < oldCapacity; i ++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public boolean add(int index, T value) {
        isIndexCorrect(index);
        ensureCapacity();
        for (int i = 0; i < size(); i++){

        }
        array = Arrays.copyOfRange(array, 0, index);
        array[index] = value;
        array = Arrays.copyOfRange(array, index + 1, array.length);
        return true;
    }

    private void isIndexCorrect(int index){
        if (index < 0 || index >= array.length){
            throw new IndexOutOfBoundsException(Constants.INCORRECT_INDEX);
        }
    }

    @Override
    public T remove(T value) {
        for (int i = 0; i < array.length; i++){
            if (array[i] == value){
                removeByIndex(i);
            }
        }
        return null;
    }

    @Override
    public T removeByIndex(int index) {
        isIndexCorrect(index);
        T removedValue = array[index];
        System.out.println(size());
        T[] newArray = (T[]) new Object[size()-1];
        for (int i = 0; i < size()-1; i++){
            if (i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i+1];
            }
        }
        System.out.println(Arrays.toString(newArray));
        for (int k = 0; k < size()-1; k++) {
            array[k] = newArray[k];
        }
        capacityCount = capacityCount - 1;
        return removedValue;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size(); i++){
            if (array[i] == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, T value) {
        isIndexCorrect(index);
        Array.set(array, index, value);
        return true;
    }

    @Override
    public void print() {
        String result = "[ ";
        for (int i = 0; i < size(); i++) {
            result += array[i] + ", ";
        }
        result += " ]";
        System.out.println(result);
    }

    @Override
    public T[] toArray() {
        T[] newArray = (T[]) new Object[capacityCount];
        for (int i = 0; i < capacityCount; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public boolean removeAll(T[] ar) {
        for (T i : ar){
            if (contains(i)){
                remove(i);
            }
        }
        return true;
    }

}
