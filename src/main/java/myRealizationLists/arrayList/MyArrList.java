package myRealizationLists.arrayList;

import myRealizationLists.MyList;

import java.util.Arrays;

public class MyArrList<E> implements MyList<E> {
    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private E[] values;
    private final int INIT_CAPACITY;
    private int index = 0;
    private int currentCapacity;

    public MyArrList() {
        INIT_CAPACITY = 10;
        this.values = (E[]) new Object[INIT_CAPACITY];
        currentCapacity = INIT_CAPACITY;
    }

    public MyArrList(int capacity) {
        INIT_CAPACITY = capacity;
        this.values = (E[]) new Object[INIT_CAPACITY];
        currentCapacity = INIT_CAPACITY;
    }

    @Override
    public E get(int i) {

        return values[i];
    }

    @Override
    public E getOrDefault(int i, E elem) {
        if (i >= index) {
            return elem;
        }
        if (values[i] == null) {
            return elem;
        } else {
            return values[i];
        }
    }

    @Override
    public E getFirst() {
        return values[0];
    }

    @Override
    public E getLast() {
        int idx = 0;
        E result = (E) new Object();
        for (E e : values) {
            if (idx == values.length) {
                result = values[values.length - 1];
                return result;
            }
            if (e == null) {
                result = values[idx - 1];
                return result;
            }
            idx++;
        }
        return result;
    }

    @Override
    public boolean add(E e) {
        checkIndex();
        if (index <= MAX_ARRAY_SIZE) {
            values[index] = e;
            index++;
            return true;
        }
        return false;
    }

    /*
    Добавляем в том случае если есть место под этот элемент
     */
    @Override
    public boolean add(int i, E e) {
        checkIndex();
        if (i >= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (e != null) {
            if (i <= MAX_ARRAY_SIZE) {
                values[i] = e;
                return true;
            } else {
                return false;
            }
        }
        return false;

    }

    private void checkIndex() {
        if (index == currentCapacity - 1) {
            int newCapacity = values.length * 2;
            currentCapacity = newCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0) {
                throw new OutOfMemoryError();
            }
            values = Arrays.copyOf(values, values.length * 2);
        }
    }

    @Override
    public boolean addIfAbsent(E element) {
        checkIndex();
        boolean isAbsent = true;
        int i = 0;
        int forAdding = 0;
        for (E e : values) {
            if (e.equals(element)) {
                return false;
            } else {
                if (e == null) {
                    forAdding = i;
                }
                i++;
            }
        }
        if (isAbsent) {
            values[forAdding] = element;
        }
        index++;
        return isAbsent;
    }

    @Override
    public boolean update(int index, E element) {
        if (index <= MAX_ARRAY_SIZE) {
            values[index] = element;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int idx) {
        if (idx >= index) throw new ArrayIndexOutOfBoundsException();
        if (idx >= 0) {
            int removedSize = values.length - idx - 1;
            System.arraycopy(values, idx + 1, values, idx, removedSize);
            index--;
        }
        return true;
    }

    @Override
    public boolean delete(E e) {
        int i = 0;
        for (E elem : values) {
            if (elem.equals(e)) {
                delete(i);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public int size() {
        return index;
    }
    @Override
    public void clear() {
        index = 0;
        values = (E[]) new Object[INIT_CAPACITY];
    }

    @Override
    public boolean contains(E e) {
        return false;
    }
}
