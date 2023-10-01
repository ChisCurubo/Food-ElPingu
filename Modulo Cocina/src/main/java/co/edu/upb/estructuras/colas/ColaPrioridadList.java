package co.edu.upb.estructuras.colas;


import co.edu.upb.estructuras.interfaces.StackInterface;
import co.edu.upb.estructuras.listas.LinkedList;
import co.edu.upb.estructuras.pilas.Stack;

public class ColaPrioridadList<T> implements StackInterface<T> {

    LinkedList<T> listDouble = new LinkedList<>();

    @Override
    public boolean clear() {
        return listDouble.clear();
    }

    @Override
    public boolean isEmpty() {
        return listDouble.isEmpty();
    }

    @Override
    public T peek() {
        return listDouble.get();
    }

    @Override
    public T pop() {
        return listDouble.pop();
    }

    @Override
    public boolean push(T object) {
        return listDouble.add(object);
    }


    @Override
    public int size() {
        return listDouble.size();
    }

    @Override
    public boolean search(T object) {
        return listDouble.contains(object);
    }


    @Override
    public boolean sort() {
        if (!isEmpty()) {
            Stack<T> stack1 = new Stack<>();
            Stack<T> stack2 = new Stack<>();
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
            Stack<T> stak = new Stack<>();
            while (!listDouble.isEmpty()) {

                stak.push(listDouble.pop());
            }
            while (!stak.isEmpty()) {
                push(stak.pop());
            }
            return true;
        }
        return false;
    }

    public void print() {
        listDouble.imprimir();
    }

    @Override
    public String toString() {
        return "ColaPrioridadList{" +
                "listDouble=" + listDouble +
                '}';
    }
}

