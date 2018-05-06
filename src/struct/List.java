package struct;

public interface List<E> {
    int size();

    void resize(int resizeNum);

    boolean isEmpty();

    boolean isContained(E e);

    void addFirst(E e);

    void addLast(E e);

    void add(int index, E e);

    void remove(E e);

    E get(int index);

    int find(E e);
}
