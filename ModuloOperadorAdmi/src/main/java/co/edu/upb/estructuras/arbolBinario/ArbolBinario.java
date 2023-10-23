package co.edu.upb.estructuras.arbolBinario;


import co.edu.upb.estructuras.colas.ColaPrioridadList;
import co.edu.upb.estructuras.listas.DoubleLinkedList;

import java.io.Serializable;
/**
 *@author ChristianRodriguez
 */

public class ArbolBinario<T extends Serializable> implements Serializable {
    private NodoArbolBinario<T> root;
    private int gradoArbol = 2;
    private int alturaArbol; // camino mas largo a cualquier nodo;

    public ArbolBinario() {
        alturaArbol = 0;
    }

    public ArbolBinario(NodoArbolBinario<T> rooting) {
        this.root = rooting;
        rooting.setNivelNodo(1);
        alturaArbol = 1;
    }

    public NodoArbolBinario<T> getRoot() {
        return root;
    }

    public void setRoot(NodoArbolBinario<T> root) {
        this.root = root;
    }

    public String preOrder() {
        String strRes = "";
        return preOrder(getRoot(), strRes);
    }

    private String preOrder(NodoArbolBinario<T> rootCh, String strRes) {
        if (rootCh != null) {
            strRes += rootCh.getObject().toString() + ", ";
            strRes = preOrder(rootCh.getHijoIzq(), strRes);
            strRes = preOrder(rootCh.getHijoDer(), strRes);
        }
        return strRes;
    }

    public DoubleLinkedList preOrderLista() {
        DoubleLinkedList list = new DoubleLinkedList();
        return preOrderLista(getRoot(), list);
    }

    private DoubleLinkedList preOrderLista(NodoArbolBinario<T> rootCh, DoubleLinkedList listRes) {
        if (rootCh != null) {
            listRes.add(rootCh);
            listRes = preOrderLista(rootCh.getHijoIzq(), listRes);
            listRes = preOrderLista(rootCh.getHijoDer(), listRes);
        }
        return listRes;
    }

    public String postOrder() {
        String strResPos = "";
        return postOrder(getRoot(),strResPos);
    }

    private String postOrder(NodoArbolBinario<T> root, String strResPos) {
        if (root != null){
            strResPos = postOrder(root.getHijoIzq(), strResPos);
            strResPos = postOrder(root.getHijoDer(), strResPos);
            strResPos += root.getObject().toString() + ", ";
        }
        return strResPos;
    }

    public DoubleLinkedList postOrderLista() {
        DoubleLinkedList list = new DoubleLinkedList();
        return preOrderLista(getRoot(), list);
    }

    private DoubleLinkedList postOrderLista(NodoArbolBinario<T> rootCh, DoubleLinkedList listRes) {
        if (rootCh != null) {
            listRes = preOrderLista(rootCh.getHijoIzq(), listRes);
            listRes = preOrderLista(rootCh.getHijoDer(), listRes);
            listRes.add(rootCh);
        }
        return listRes;
    }

    public String inOrder (){
        String strResIn = "";
        return inOrder(getRoot(), strResIn);
    }

    private String inOrder(NodoArbolBinario<T> root, String strIn) {
        if (root != null){
            strIn = inOrder(root.getHijoIzq(), strIn);
            strIn+= root.getObject().toString() + ", ";
            strIn = inOrder(root.getHijoDer(), strIn);
        }
        return strIn;
    }

    public DoubleLinkedList inOrderLista() {
        DoubleLinkedList list = new DoubleLinkedList();
        return preOrderLista(getRoot(), list);
    }

    private DoubleLinkedList inOrderLista(NodoArbolBinario<T> rootCh, DoubleLinkedList listRes) {
        if (rootCh != null) {
            listRes = preOrderLista(rootCh.getHijoIzq(), listRes);
            listRes.add(rootCh);
            listRes = preOrderLista(rootCh.getHijoDer(), listRes);
        }
        return listRes;
    }

    public String widthOrder() {
        String strRes="";
        if(root!=null){
            ColaPrioridadList queue = new ColaPrioridadList();
            queue.push(root);
            while(!queue.isEmpty()){
                root = (NodoArbolBinario<T>) queue.pop();
                strRes += root.getObject().toString();
                queue.push(root.getHijoIzq());
                queue.push(root.getHijoDer());
            }
        }
        return strRes;
    }

    public DoubleLinkedList widthOrderLista() {
        DoubleLinkedList strRes=new DoubleLinkedList();
        if(root!=null){
            ColaPrioridadList queue = new ColaPrioridadList();
            queue.push(root);
            while(!queue.isEmpty()){
                root = (NodoArbolBinario<T>) queue.pop();
                strRes .add( root);
                queue.push(root.getHijoIzq());
                queue.push(root.getHijoDer());
            }
        }
        return strRes;
    }

    public boolean insertWidthOrder(T object) {
        NodoArbolBinario root = this.root;
        int i=0;
        if(root!=null){
            ColaPrioridadList queue = new ColaPrioridadList();
            queue.push(root);
            while(!queue.isEmpty()){
                root = (NodoArbolBinario<T>) queue.pop();
                queue.push(root.getHijoIzq());
                queue.push(root.getHijoDer());
                if(root.getHijoIzq()==null){
                    i=1;
                    break;
                }
                if(root.getHijoDer()==null){
                    break;
                }
            }
            if(i==1){
                root.setHijoIzq(new NodoArbolBinario<>(object));
            }else{
                root.setHijoDer(new NodoArbolBinario<>(object));
            }
        }else{
            this.root = new NodoArbolBinario<>(object);
        }
        return true;
    }

    public static void main(String[] args) {
        NodoArbolBinario root = new NodoArbolBinario<>("rooting");
        ArbolBinario arbolitoNavidading = new ArbolBinario(root);
        NodoArbolBinario hijoDer = new NodoArbolBinario<>("HijingDer");
        root.setHijoDer(hijoDer);
        NodoArbolBinario hijoIzq = new NodoArbolBinario<>("HijingIzq");
        root.setHijoIzq(hijoIzq);
        arbolitoNavidading.insertWidthOrder("lopez");
        arbolitoNavidading.insertWidthOrder("mauro");
        arbolitoNavidading.insertWidthOrder("pato");
        DoubleLinkedList a = arbolitoNavidading.preOrderLista();
        a.imprimir();

    }
}

