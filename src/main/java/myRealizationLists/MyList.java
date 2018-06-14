package myRealizationLists;
// Реализуемые коллекции должны поддерживать следующие методы
public interface MyList<E> {
    // хотим получить элемент по индексу
    E get(int i);
    // получить элемент по индексу, и если такого нету то вернуть дефолтное занчение
    E getOrDefault(int i, E elem);
    // Получить первый
    E getFirst();
    // Получить последний
    E getLast();
    // просто добавить
    boolean add(E e);
    // добавить по индексу
    boolean add(int index, E e);
    // добавить если такого нету
    boolean addIfAbsent(E element);
    // апдейт по индексу
    boolean update(int index, E element);
    // удалить по индексу
    boolean delete(int index);
    // удалить элемент, который совпадает с ним
    boolean delete(E e);
    // размер
    int size();

    void clear();
    boolean contains (E e);
}
