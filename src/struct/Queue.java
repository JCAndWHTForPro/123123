package struct;

public interface Queue<E> {

    int size();

    boolean isEmpty();

    void enQueue(E e);

    E deQueue();

    void resize(int num);
}
