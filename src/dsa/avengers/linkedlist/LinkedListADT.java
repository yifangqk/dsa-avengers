package dsa.avengers.linkedlist;

public interface LinkedListADT<T> extends Iterable<T> {
    int size();

    boolean isEmpty();

    T get(int index);

    T set(T key, T data);

    void remove(T key);

    int indexOf(T key);

    boolean contains(T key);
}
