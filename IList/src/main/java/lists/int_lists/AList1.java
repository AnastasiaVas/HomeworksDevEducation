package lists.int_lists;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AList1 implements IList {

    private int[] array;
    private int capacityCount;
    private static final int DEFAULT_CAPACITY = 10;

    public AList1(){
        this.array = new int[DEFAULT_CAPACITY];
    }

    public AList1(int capacity){
        if (capacity > 0) {
            this.array = new int[capacity];
        } else {
            throw new IllegalArgumentException("Вместимость массива должна быть больше 0.");
        }
    }

    public AList1(int[] array){
        this.array = array;
        capacityCount = array.length+1;
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
    public int get(int index) {
        return array[index];
    }

    @Override
    public boolean add(int value) {
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
            int[] newArray = new int[newCapacity];
            for (int i = 0; i < oldCapacity; i ++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public boolean add(int index, int value) {
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
            throw new IndexOutOfBoundsException("Указанный индекс некорректный.");
        }
    }

    @Override
    public int remove(int number) {
        int removedValue = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == number){
                removedValue = removeByIndex(i);
            }
        }
        return removedValue;
    }

    @Override
    public int removeByIndex(int index) {
        isIndexCorrect(index);
        int removedValue = array[index];
        System.out.println(size());
        int[] newArray = new int[size()-1];
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
    public boolean contains(int value) {
        for (int i = 0; i < size(); i++){
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
        String result = "[";
        for (int i = 0; i < size(); i++) {
            result += array[i];
            if (i != size()-1){
                result += ", ";
            }
        }
        result += "]";
        System.out.println(result);
    }

    @Override
    public int[] toArray() {
        int[] newArray = new int[capacityCount];
        for (int i = 0; i < capacityCount; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public boolean removeAll(int[] ar) {
        for (int i : ar){
            if (contains(i)){
                remove(i);
            }
        }
        return true;
    }
}
