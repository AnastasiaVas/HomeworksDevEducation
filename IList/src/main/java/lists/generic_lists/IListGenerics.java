package lists.generic_lists;

public interface IListGenerics<T> {


    void clear();
    int size();
    T get(int index);
    boolean add(T value);
    boolean add(int index, T value);
    T remove(T value);
    T removeByIndex(int index);
    boolean contains(T value);
    boolean set(int index, T value);
    void print();
    T[] toArray();
    boolean removeAll(T[] ar);
}
