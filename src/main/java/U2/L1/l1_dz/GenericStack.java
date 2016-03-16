package U2.L1.l1_dz;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Ксения on 16.03.2016.
 *
 */
public class GenericStack<E> implements Stack<E> {

    private int maxSize;
    private int size;
    private LinkedList<E> array;

    public GenericStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.array = new LinkedList<>();
    }


    @Override
    public void push(E element) throws StackException {
        if (isFull()) throw new StackException("Stack is full!");
        size++;
        array.addLast(element);
    }

    @Override
    public E pop() throws StackException {
        if (isEmpty()) throw new StackException("Stack is empty");
        E element = array.removeLast();
        size--;
        return element;
    }

    @Override
    public E peek() {
        return array.get(size-1);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if (maxSize == size) return true;
        return false;
    }

    @Override
    public void pushAll(Collection<? extends E> src) throws StackException {
        for (E e : src) {
            push(e);
        }

    }

    @Override
    public void popAll(Collection<? super E> dst) throws StackException {
        while (!isEmpty()){
            dst.add(pop());
        }

    }

    @Override
    public String toString() {
        return "GenericStack{" +
                "array=" + array +
                '}';
    }
}
