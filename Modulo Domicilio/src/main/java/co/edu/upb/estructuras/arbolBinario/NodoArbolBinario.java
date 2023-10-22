package co.edu.upb.estructuras.arbolBinario;

import co.edu.upb.estructuras.node.Node;

import java.io.Serializable;
/**
 *@author ChristianRodriguez
 */
public class NodoArbolBinario<T extends Serializable>  extends Node implements Serializable {
    private NodoArbolBinario<T> hijoDer;
    private NodoArbolBinario<T> hijoIzq;

    private int nivelNodo;
    public NodoArbolBinario (){
        super();
        this.hijoDer = null;
        this.hijoIzq = null;
    }

    public NodoArbolBinario (T object){
        super(object);
        this.hijoDer = null;
        this.hijoIzq = null;
    }

    public NodoArbolBinario<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoArbolBinario<T> hijoDer) {
        this.hijoDer = hijoDer;
        hijoDer.setNivelNodo(getNivelNodo() + 1);
    }

    public NodoArbolBinario<T> getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoArbolBinario<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
        hijoIzq.setNivelNodo(getNivelNodo() + 1);
    }

    public void setNivelNodo(int nivelNodo) {
        this.nivelNodo = nivelNodo;
    }

    public int getNivelNodo() {
        return nivelNodo;
    }
}
