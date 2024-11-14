package dsa.avengers.linkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    Node<T> head;

    // BigO: O(1) We have a pointer to the head and we can directly
    // attach a node and change the pointer. So the Time complexity of inserting a node
    // at the head position is O(1) as it does a constant amount of work.
    public void pushBeginning(T data) {
        //1. Allocate the Node n Put in the data
        Node<T> newNode = new Node<>(data);

        //2. make next of new Node as head
        newNode.next = head;

        //3. Move the head to point to new Node
        head = newNode;
    }

    public void insertAfter(T key, T data) {
        Node<T> newNode = new Node<>(data);

        Node<T> temp = head;

        // find key of Node
        while (temp != null && !temp.data.equals(key)) {
            temp = temp.next;
        }

        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void append(T data) {
        /* 1. Allocate the Node &
            2. Put in the data
            3. Set next as null */
        Node<T> newNode = new Node<>(data);

        /* 4. If the Linked List is empty, then make the
        new node as head */
        if (head == null) {
            head = new Node<>(data);
            return;
        }

         /* 4. This new node is going to be the last node, so
        make next of it as null */
        newNode.next = null;

        /* 5. Else traverse till the last node */
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }

        /* 6. Change the next of last node */
        last.next = newNode;
    }

    public void remove(T key) {
        if (head == null) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }

        // remove the first element at the first position of the list
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }

        // Allocate temp Node
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null && !curr.data.equals(key)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }
        prev.next = curr.next;
    }

    public int count() {
        Node<T> temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }


    /*
    The idea is to use three pointers curr, prev, and next to keep track of nodes to
     update reverse links.

    Follow the steps below to solve the problem:

        Initialize three pointers prev as NULL, curr as head, and next as NULL.
        Iterate through the linked list. In a loop, do the following:
        Before changing the next of curr, store the next node
              next = curr -> next
        Now update the next pointer of curr to the prev
              curr -> next = prev
        Update prev as curr and curr as next
              prev = curr
              curr = next
     */
    public Node<T> reverse(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


    public void traverse() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }


    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
