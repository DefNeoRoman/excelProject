package myRealizationLists.linkedList;

import myRealizationLists.MyList;

public class MyLinkList<E> implements MyList<E> {
    private int size = 0;
    //Изначально голова является также и хвостом
    private Node head = new Node("head", null, null);
    private Node tail;

    public MyLinkList() {
        tail = new Node("tail", null, head);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;

    }

    @Override
    public E get(int index) {
        int middle = size / 2;

        if (index < middle) {
            Node<E> x = head.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x.value;
        } else {
            Node<E> x = tail.prev;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x.value;
        }
    }

    public Node<E> getNode(int index) {
        int middle = size / 2;

        if (index < middle) {
            Node<E> x = head.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = tail.prev;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public E getOrDefault(int i, E elem) {
        return null;
    }

    @Override
    public E getFirst() {

        return get(0);
    }

    @Override
    public E getLast() {
        return get(size);
    }

    @Override
    public boolean add(E e) {
        size++;
        Node prev = tail.getPrev();
        Node newNode = new Node(e, tail, prev);
        prev.setNext(newNode);
        tail = new Node("tail", null, newNode);
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
        size--;
        return unlink(getNode(index));
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
        for (Node<E> x = head; x != null; ) {
            Node<E> next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    boolean unlink(Node<E> x) {

        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.value = null;
        return true;
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

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
