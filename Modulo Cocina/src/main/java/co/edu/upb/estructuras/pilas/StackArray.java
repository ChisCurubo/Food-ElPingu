package co.edu.upb.estructuras.pilas;

import co.edu.upb.estructuras.interfaces.StackInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StackArray<T> implements StackInterface<T> {
    public T[] arryPila;
    private int size;
    private int head;
    private int tail;

    public StackArray(int tamArr) {
        arryPila = (T[]) new Object[tamArr];
        size = 0;
        head = tamArr;
        tail = 0;
    }

    @Override
    public boolean clear() {
        arryPila = (T[]) new Object[0];
        size = 0;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (arryPila == null) {
            return true;
        }
        return false;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return arryPila[head-1];
        }
        return null;
    }


    @Override
    public T pop() {
        if (!isEmpty()) {
            T pop = arryPila[head];
            arryPila[head] = null;
            head++;
            size--;
            return pop;
        }
        return null;
    }


    @Override
    public boolean push(Object object) {
        if (head > 0) {
            head--;
            arryPila[head] = (T) object;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(Object object) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (arryPila[i].equals(object)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean sort() {
        if (!isEmpty()) {
            StackArray<T> stack1 = new StackArray<>(size());
            StackArray<T> stack2 = new StackArray<>(size());
            int size = size();

            for (int i = 0; i < size; i++) {
                T current = pop();
                while ((!stack1.isEmpty()) && (current.toString().length() > stack1.peek().toString().length())) {
                    stack2.push(stack1.pop());
                }
                stack1.push(current);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            while (!stack1.isEmpty()) {
                push(stack1.pop());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean reverse() {
        if (!isEmpty()) {
            try {
                StackArray<T> stackTemp = new StackArray<>(size());
                int cont = size;
                for (int i = 0; i < cont; i++) {
                    stackTemp.push(pop());
                }
                arryPila = stackTemp.arryPila;
                head = stackTemp.head;
                size = stackTemp.size();
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    public void print() {
        for (T obj : arryPila) {
            if (obj != null)
                System.out.println(obj);
        }
    }
}
