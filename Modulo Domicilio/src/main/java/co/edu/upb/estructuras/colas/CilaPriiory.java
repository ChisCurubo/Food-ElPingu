package co.edu.upb.estructuras.colas;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *@author ChristianRodriguez
 */
public class CilaPriiory<T extends Serializable> implements Serializable {
    ColaPrioridadList[] arrayClasi ;

    public CilaPriiory(int n){
        arrayClasi = new ColaPrioridadList[n];
        for (int i = 0; i < n; i++) {
            arrayClasi[i]  = new ColaPrioridadList();
        }
    }

    public boolean addToCola (int indice, T objeto){
        try {
            if(indice < arrayClasi.length) {
                arrayClasi[indice].push(objeto);
                return true;
            }
        }catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return false;
    }

    public T popcola(){
        try {
            for (int i = 0; i < arrayClasi.length; i++) {
                if (!arrayClasi[i].isEmpty()) {
                    return (T) arrayClasi[i].pop();
                }
            }
        }catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return null;
    }
    public String imprimir(){
        String str = "";
        for (int i = 0; i < arrayClasi.length; i++) {
            str += arrayClasi[i].print();
        }
        return str;
    }
}
