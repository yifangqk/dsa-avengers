package dsa.avengers.linkedlist;

public class DoublyLinkedList<T> {
    Node<T> head;

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }
}
