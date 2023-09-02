package list;

import node.NodeInterface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinkedList<T> implements LinkedListInterface<T>, Cloneable {
    private SingleListNode<T> head;
    private SingleListNode<T> tail;
    private SingleListNode<T> inode;
    private int size;

    public LinkedList() {
    }

    @Override
    public boolean add(T object) {
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SingleListNode<>(object);  //LAS ASIGNACIONES SE LEEN DE DERECHA A IZQUIERDA
                } else {                                             //Cola = Cabeza tiene una referencia a este objeto //Head apunta a SingleListNode
                    tail.setNext(new SingleListNode<>(object));
                    tail = tail.getNext();
                }
                size++;
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T object) {
        Iterator iterator = iterator();
        SingleListNode nodeTemp;
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SingleListNode<>(object);
                }
                if (tail.equals(node)) {
                    tail.setNext(new SingleListNode<>(object));
                    tail = tail.getNext();
                } else {
                    while (iterator.hasNext()) {
                        nodeTemp = (SingleListNode) iterator.next();
                        if (nodeTemp.isEquals(node.getObject())) {
                            SingleListNode nodeToAdd = new SingleListNode<>(object);
                            nodeToAdd.setNext(nodeTemp.getNext());    //El nodo a añadir señala al siguiente al temporal
                            nodeTemp.setNext(nodeToAdd);
                        }
                    }
                }
                size++;
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, NodeInterface<T> next) {
        Iterator iter = iterator();
        SingleListNode nodeTemp;
        if (node != null && next != null) {
            tail.setNext((SingleListNode<T>) next);
            tail = tail.getNext();
        }
        try {
            while (iter.hasNext()) {
                nodeTemp = (SingleListNode) iter.next();
                if (nodeTemp.isEquals(node.getObject())) {
                    SingleListNode newNode = (SingleListNode) next;
                    newNode.setNext(nodeTemp.getNext());
                    nodeTemp.setNext(newNode);
                }
            }
            size++;
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return false;
    }

    @Override
    public boolean add(T[] objects) {
        Iterator iter = iterator();
        try {
            if (isEmpty()) {
                for (int i = 0; i < objects.length; i++) {
                    if (head == null) {
                        tail = head = new SingleListNode<>(objects[i]);
                        size++;
                    } else {
                        tail.setNext(new SingleListNode<>(objects[i]));
                        tail = tail.getNext();
                        size++;
                    }
                }
            } else {
                for (int i = 0; i < objects.length; i++) {
                    tail.setNext(new SingleListNode<>(objects[i]));
                    tail = tail.getNext();
                    size++;
                }
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T[] objects) {
        Iterator iter = iterator();
        SingleListNode nodeTemp;
        if (objects.length > 0) {
            try {
                if (isEmpty()) {
                    for (int i = 0; i < objects.length; i++) {
                        if (head == null) {
                            head = tail = new SingleListNode<>(objects[i]);
                            size++;
                        }
                    }
                } else {
                    while (iter.hasNext()) {
                        nodeTemp = (SingleListNode) iter.next();
                        if (nodeTemp.isEquals(node.getObject())) {
                            for (int i = 0; i < objects.length; i++) {
                                SingleListNode newNode = new SingleListNode<>(objects[i]);
                                newNode.setNext(nodeTemp.getNext());
                                nodeTemp.setNext(newNode);
                                size++;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T object) {
        if (object != null) {
            try {
                if (isEmpty()) {
                    head = tail = new SingleListNode<>(object);
                } else {
                    SingleListNode newNode = new SingleListNode(object);
                    newNode.setNext(head);
                    head = newNode;
                }
                size++;
                return true;
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T[] objects) {
        if (objects.length > 0) {
            try {
                if (isEmpty()) {
                    for (T object : objects) {
                        head = tail = new SingleListNode<>(object);
                        size++;
                    }
                } else {
                    for (T object : objects) {
                        addOnHead(object);
                    }
                    return true;
                }

            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        head = null;
        size = 0;
        return true;
    }

    @Override
    public LinkedList<T> cloneList() {
        try {
            if (!isEmpty()) {
                Iterator<NodeInterface<T>> iter = iterator();
                LinkedList<T> cloneNode = new LinkedList<>();
                while (iter.hasNext()) {
                    cloneNode.add(iter.next().getObject());
                }
                return cloneNode;
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return null;
    }

    @Override
    public boolean contains(T object) {
        Iterator iter = iterator();
        if (!isEmpty()) {
            if (object != null) {
                while (iter.hasNext()) {
                    SingleListNode newNode = (SingleListNode) iter.next();
                    if (newNode.isEquals(object)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(T[] objects) {
        if (!isEmpty()) {
            try {
                int cont = 1;
                for (T object : objects) {
                    if (contains(object)) {
                        cont++;
                    }
                }
                if (cont == objects.length) {
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }


    @Override
    public NodeInterface<T> nodeOf(T object) {
        Iterator iter = iterator();
        if (object != null) {
            try {
                while (iter.hasNext()) {
                    SingleListNode newNode = (SingleListNode) iter.next();
                    if (newNode.isEquals(object)) {
                        return newNode;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return new SingleListNode<>(null);
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public T get() {
        if (!isEmpty()) {
            return head.getObject();
        }
        return null;
    }

    @Override
    public T[] get(int n) {
        T[] arrRetur = (T[]) new Object[n];
        Iterator iter = iterator();
        if (!isEmpty()) {
            if (size() >= n) {
                for (int i = 0; i < n; i++) {
                    SingleListNode<T> nodeArr = (SingleListNode<T>) iter.next();
                    arrRetur[i] = nodeArr.getObject();
                }
            } else {
                throw new NoSuchElementException("Te pasaste de wey");
            }
        }

        return arrRetur;
    }

    @Override
    public T getPrevious(NodeInterface<T> node) {
        Iterator iter = iterator();
        T objReturn = null;
        if (!isEmpty()) {
            SingleListNode<T> prevNode = null;
            SingleListNode<T> nodeTemp = null;
            while (iter.hasNext()) {
                prevNode = nodeTemp;    //NodeTemp = head     | nodePrev = null , porque anterior es cabeza
                nodeTemp = (SingleListNode<T>) iter.next();
                if (nodeTemp.isEquals(node.getObject())) {
                    return prevNode.getObject();
                }
            }
            try {
                objReturn = prevNode.getObject();
            } catch (Exception ex) {
                objReturn = null;
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return objReturn;
    }

    private NodeInterface<T> getPreviousNode(NodeInterface<T> node) {
        Iterator iter = iterator();
        SingleListNode<T> prevNode = null;
        SingleListNode<T> nodeTemp = null;
        if (!isEmpty()) {
            while (iter.hasNext()) {
                prevNode = nodeTemp;    //NodeTemp = head     | nodePrev = null , porque anterior es cabeza
                nodeTemp = (SingleListNode<T>) iter.next();
                if (nodeTemp.isEquals(node.getObject())) {
                    return prevNode;
                }
            }
        }
        return prevNode;
    }

    @Override
    public T getFromEnd() {
        if (!isEmpty()) {
            return tail.getObject();
        }
        return null;
    }

    @Override
    public T[] getFromEnd(int n) {
        T[] arrTail = (T[]) new Object[n];
        SingleListNode<T> nodeTemp;
        nodeTemp = tail;
        if (size() > n) {
            for (int i = 0; i < n; i++) {
                arrTail[i] = nodeTemp.getObject();
                nodeTemp = new SingleListNode<>(getPrevious(nodeTemp));
            }
        }
        return arrTail;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            SingleListNode<T> nodeTemp = head;
            head = head.getNext();
            size--;
            return nodeTemp.getObject();
        }
        return null;
    }

    @Override
    public boolean remove(T object) {//impecable
        Iterator iter;
        SingleListNode<T> nodeTemp = null;
        if (object != null && (!isEmpty()) && (contains(object))) {
            try {
                if (head.isEquals(object)) {
                    head = head.getNext();
                    size--;
                    return true;
                } else if (tail.isEquals(object)) {
                    T nodeFin = getPrevious(new SingleListNode<>(object));
                    tail = (SingleListNode<T>) nodeOf(nodeFin);
                    tail.setNext(null);
                    size--;
                    return true;
                }
                SingleListNode<T> nodeU;
                iter = iterator();
                while (iter.hasNext()) {
                    nodeU = nodeTemp;
                    nodeTemp = (SingleListNode<T>) iter.next();
                    if (nodeTemp.isEquals(object)) {
                        nodeU.setNext(nodeTemp.getNext());
                        size--;
                        return true;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean remove(NodeInterface<T> node) {
        if (isEmpty()) {
            return false;
        } else {
            try {
                return remove(node.getObject());
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(T[] objects) {
        if (!isEmpty() && objects != null) {
            try {
                for (T objet : objects) {
                    if (objet != null) {
                        remove(objet);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    /*
        private boolean retain(T[] objects) {
            try {
                for (T objet : objects) {
                    if (objet != null) {
                        if (!contains(objet)) {
                            remove(objet);

                        }
                    }
                }
                return true;
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
            return false;
        }


     */
    @Override
    public boolean retainAll(T[] objects) {
        if (objects != null && !isEmpty()) {
            try {
                int cont = 0;
                Iterator iter = iterator();
                T[] arrTemp = (T[]) new Object[objects.length];
                SingleListNode<T> nodeTemp;
                while (iter.hasNext()) {
                    nodeTemp = (SingleListNode<T>) iter.next();
                    for (int i = 0; i < objects.length; i++) {
                        if (nodeTemp.isEquals(objects[i])) {
                            arrTemp[cont] = nodeTemp.getObject();
                            cont++;
                        }
                    }
                }
                clear();
                add(arrTemp);
                return true;
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedListInterface<T> subList(NodeInterface<T> from, NodeInterface<T> to) {
        if (validateSubList(from, to) && (!isEmpty())) {
            Iterator iter = iterator();
            SingleListNode<T> ini;
            LinkedList subLista = new LinkedList();
            while (iter.hasNext()) {
                ini = (SingleListNode<T>) iter.next();
                if (ini.isEquals(from.getObject())) {
                    subLista.add(ini.getObject());
                    ini = ini.getNext();
                    while (!ini.isEquals(to.getObject())) {
                        subLista.add(ini.getObject());
                        ini = ini.getNext();
                    }
                    subLista.add(ini.getObject());
                    return subLista;
                }
            }
            return subLista;
        } else {
            System.out.println("no entra");
        }
        return null;
    }

    private boolean validateSubList(NodeInterface<T> from, NodeInterface<T> to) {
        Iterator iter = iterator();
        SingleListNode<T> nodeTemp;
        if (from != null && to != null) {
            while (iter.hasNext()) {
                nodeTemp = (SingleListNode<T>) iter.next();
                if (nodeTemp.isEquals(from.getObject())) {
                    return true;
                } else if (nodeTemp.isEquals(to.getObject())) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        NodeInterface<T> nodo = head;
        T[] arreglo = (T[]) new Object[size];
        Iterator iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            nodo = (NodeInterface<T>) iterator.next();
            arreglo[i++] = (T) nodo.getObject();
        }
        return arreglo;
    }
    /*@Override
    public T[] toArray() {
        T[] objectArr ;
        SingleListNode nodo = head;
        T[] arreglo = (T[]) new Object[size];

        for (int i = 0; i < size; i++) {
            arreglo[i] = (T) nodo.getObject();
            nodo = nodo.getNext();
        }
        return arreglo;
    }*/

    @Override
    public boolean sortObjectsBySize() {
        if (!isEmpty()) {
            Iterator iter = iterator();
            SingleListNode nodeTemp = null;
            Object[][] arrTo = (T[][]) new Object[size()][2];
            for (int i = 0; i < size(); i++) {
                nodeTemp = (SingleListNode) iter.next();
                String stringNode = nodeTemp.getObject().toString();
                Integer sizeString = stringNode.length();
                for (int j = 0; j < 2; j++) {
                    if (arrTo[i][0] == (null)) {
                        arrTo[i][0] = sizeString;
                    } else if (arrTo[i][1] == (null)) {
                        arrTo[i][1] = nodeTemp.getObject();
                    }
                }
            }
            //int fila = arrTo.length;                              int fila = arrTo.length;
            //for (int i = fila / 2; i > 0; i /= 2) {               for (int i = fila / 2; i > 0; i /= 2) {
            //for (int j = i; j < fila; i++) {                      for (int j = i; j < fila; j++) {
            //Object[] filaTemp = arrTo[j];                          Object[] filaTemp = arrTo[j];
            //int k;                                                    int k;
            //for (k = j; k >= i && ((int) arrTo[k - i][0] > (int) filaTemp[0]); k -= i) {      for (k = j; k >= i && ((int) arrTo[k - i][0] > (int) filaTemp[0]); k -= i) {
            //arrTo[k] = arrTo[k - i];
            // }
            //arrTo[k] = filaTemp;
            //}
            //}
            int fila = arrTo.length;
            for (int i = fila / 2; i > 0; i /= 2) {
                for (int j = i; j < fila; j++) {
                    Object[] filaTemp = arrTo[j];
                    int k;
                    for (k = j; k >= i && ((int) arrTo[k - i][0] > (int) filaTemp[0]); k -= i) {
                        arrTo[k] = arrTo[k - i];
                    }
                    arrTo[k] = filaTemp;
                }
            }

            LinkedList newList = new LinkedList();
            for (int i = 0; i < arrTo.length; i++) {
                newList.add(arrTo[i][1]);
            }

            head = newList.head;
            tail = newList.tail;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<NodeInterface<T>> iterator() {
        inode = head;
        return new Iterator<NodeInterface<T>>() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public NodeInterface<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = inode;
                inode = inode.getNext();
                return node;
            }
        };
    }

    public Iterator iteratorObj() {
        inode = head;
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = inode;
                inode = inode.getNext();
                return node.getObject();
            }
        };
    }

    public void imprimir() {
        Iterator<NodeInterface<T>> iterator = iterator();
        for (int i = 0; i < size(); i++) {
            System.out.println(iterator.next().getObject());
        }
    }

    public boolean invertir(int k) {
        if (k > 0 && !isEmpty()) {
            int tamaño = (size() / k);
            SingleListNode<T> nodeIter;
            SingleListNode<T> firstNode;
            SingleListNode<T> kNode;
            SingleListNode<T> prevNode;
            SingleListNode<T> moveNode ;
            SingleListNode<T>nodeFor ;
            nodeIter = head;
            for (int i = 0; i < tamaño; i++) {
                firstNode = nodeIter;
                kNode = firstNode;

                for (int j = 1; j < k; j++) {
                    kNode = kNode.getNext();
                }
                if(size()/k ==1){

                    head = kNode;
                    return true;
                }
                if (kNode.isEquals(tail.getObject())) {
                    prevNode = (SingleListNode<T>) getPreviousNode(firstNode);
                    prevNode.setNext(kNode);
                    kNode.setNext(firstNode.getNext());
                    moveNode = (SingleListNode<T>) getPreviousNode(tail);
                    moveNode.setNext(firstNode);
                    firstNode.setNext(null);
                    firstNode = tail;
                }
                if (firstNode.isEquals(head.getObject())) {
                    prevNode = firstNode.getNext();
                    moveNode = (SingleListNode<T>) getPreviousNode(kNode);
                    moveNode.setNext(firstNode);
                    firstNode.setNext(kNode.getNext());
                    nodeIter = kNode;
                    if (getPreviousNode(head) == null) {
                        head.setNext(kNode);
                        kNode.setNext(prevNode);
                    }

                }
                if ((firstNode != head) && (kNode != tail)) {
                    nodeIter = kNode;
                    prevNode = (SingleListNode<T>) getPreviousNode(kNode);
                    prevNode.setNext(firstNode);
                    moveNode = (SingleListNode<T>) getPreviousNode(firstNode);
                    moveNode.setNext(kNode);
                    kNode.setNext(firstNode.getNext());
                    firstNode.setNext(kNode.getNext());
                }
            }
            return true;
        }

        return false;
    }
}

