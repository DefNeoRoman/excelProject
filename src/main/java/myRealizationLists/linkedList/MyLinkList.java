package myRealizationLists.linkedList;

import myRealizationLists.MyList;

public class MyLinkList<E> implements MyList<E> {
    private int size = 0;
    //Изначально голова является также и хвостом
    private Node head = new Node(0, null, null);
    private Node tail;

    public MyLinkList() {
        tail = new Node(1, head, null);
        head.prev = tail;

    }

    @Override
    public E get(int index) {
        int currentSize = size();
        int middle = currentSize / 2;
        Node firstNode;
        Node searchNode = new Node(null, null, null);
        Node secondNode;
        if (index > middle) {
            firstNode = tail;
            secondNode = tail.prev;
            for (int i = currentSize; i >= 0; i--) {
                if (i > index) {
                    firstNode = secondNode;
                    secondNode = firstNode.prev;
                }
                if (i == index) {
                    searchNode = firstNode;

                }

            }
        } else {
            firstNode = head;
            secondNode = head.prev;
            for (int i = 0; i <= currentSize; i++) {
                if (i < index) {
                    firstNode = secondNode;
                    secondNode = firstNode.next;
                }
                if (i == index) {
                    searchNode = firstNode;
                    return (E)searchNode.value;
                }
            }
        }

        return (E) searchNode.value;
    }

    @Override
    public E getOrDefault(int i, E elem) {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public boolean add(E e) {
        size++;
        Node currentNode = tail;
        tail = new Node(e, null, currentNode);
        return true;
    }

    @Override
    public boolean add(int index, E e) {
        int currentSize = size();
        int middle = currentSize / 2;
        Node firstNode;
        Node insertNode;
        Node secondNode;
        if (index > middle) {
            firstNode = tail;
            secondNode = tail.prev;
            for (int i = currentSize; i >= 0; i--) {
                if (i > index) {
                    firstNode = secondNode;
                    secondNode = firstNode.prev;
                }
                if (i == index) {
                    insertNode = new Node(e, firstNode, secondNode);
                    firstNode.prev = insertNode;
                    secondNode.next = insertNode;
                }

            }
        } else {
            firstNode = head;
            secondNode = head.next;
            for (int i = 0; i <= currentSize; i++) {
                if (i < index) {
                    firstNode = secondNode;
                    secondNode = firstNode.next;
                }
                if (i == index) {
                    insertNode = new Node(e, secondNode, firstNode);
                    secondNode.prev = insertNode;
                    firstNode.next = insertNode;
                }
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean addIfAbsent(E element) {
        return false;
    }

    @Override
    public boolean update(int index, E element) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public boolean delete(E e) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    class Node<E> {
        private E value;
        private Node next;
        private Node prev;

        public Node(E value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
