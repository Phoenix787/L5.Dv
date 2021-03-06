package U2.L1.L1.l1_dz;

import java.util.Collection;

/**
 * Created by Ксения on 16.03.2016.
 *
 *
 */
public interface Stack<E> {
    void push(E element) throws StackException;

    E pop() throws StackException;

    E peek();

    int getSize();

    boolean isEmpty();

    boolean isFull();

    void pushAll(Collection<? extends E> src) throws StackException;

    void popAll(Collection<? super E> dst) throws StackException;

}
