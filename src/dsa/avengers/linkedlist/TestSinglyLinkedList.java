package dsa.avengers.linkedlist;

public class TestSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();

        linkedList.append("1");
        linkedList.append("2");
        linkedList.append("3");
        linkedList.append("4");
        linkedList.append("5");


        SinglyLinkedList.Node<String> head = linkedList.reverse(linkedList.head);

        linkedList.traverse();

        System.out.println(head.data);

        System.out.println(linkedList.count());

        int[][] table = new int[][]{{0, 2, 4}, {6, 8}, {1, 3, 5, 7, 9}};

        System.out.println(table.length);
        System.out.println(table[2][3]);
    }
}
