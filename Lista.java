/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.listas;

/**
 *
 * @author pc26
 */
public class Lista {

    private Nodo cabeza, cola;
    private int longitud = 0;
    private int datos = 0;

    public int getDatos() {
        return datos;
    }

    public int getLongitud() {
        return longitud;
    }

    public Lista() {
        cabeza = cola = null;
    }

    public Lista(int datos) {
        this.datos = datos;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public void agregarCabeza(Object dato) {
        cabeza = new Nodo(dato, cabeza);
        if (cola == null) {
            cola = cabeza;
        }
        longitud++;
    }

    public void agregarCola(Object dato) {
        if (!esVacia()) {
            cola.setSiguiente(new Nodo(dato));
            cola = cola.getSiguiente();
        } else {
            cola = cabeza = new Nodo(dato);
        }
        longitud++;
    }

    public void imprimir() {
        for (Nodo temp = cabeza; temp != null; temp = temp.getSiguiente()) {
            System.out.println(temp.getDato());
        }
    }

    public Object eliminaDeCabeza() {
        Object dato = null;
        if (!esVacia()) {
            dato = cabeza.getDato();
            if (cabeza == cola) {
                cabeza = cola = null;

            } else {
                cabeza = cabeza.getSiguiente();
            }
            longitud--;
        }
        return dato;
    }

    public Object eliminarDeCola() {
        Object dato = null;
        if (!esVacia()) {
            dato = cola.getDato();
            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                Nodo temp;
                for (temp = cabeza; temp.getSiguiente() != cola; temp = temp.getSiguiente()) {
                    cola = temp;
                }
                cola.setSiguiente(null);
            }
            longitud--;
        }
        return dato;
    }

    public Object obtenerNodo(int indice) {
        Object dato = null;
        if (!esVacia() && indice >= 0 && indice < longitud) {
            Nodo temp = cabeza;
            for (int contador = 0; contador < indice && temp != null; contador++, temp = temp.getSiguiente());
            if (temp != null) {
                dato = temp.getDato();
            }
        }
        return dato;
    }

    public void insertarEnIndice(int indice, Object dato) {
        if (!esVacia() && indice >= 0 && indice < longitud) {
            Nodo temp = cabeza;
            for (int contador = 0;
                    contador < indice && temp != null;
                    contador++, temp = temp.getSiguiente());
            temp.setDato(dato);
        }
    }
 

    public void borrar(Object dato) {
        if (!esVacia()) {
            Nodo temp = cabeza;
            if (cabeza == cola
                    && temp.getDato().equals(dato)) {
                cabeza = cola = null;
                longitud--;
            } else if (dato.equals(cabeza.getDato())) {
                eliminaDeCabeza();
            } else {
                Nodo predesor, tmp;
                for (predesor = cabeza, tmp = cabeza.getSiguiente();
                        tmp != null
                        && !tmp.getDato().equals(dato);
                        predesor = predesor.getSiguiente(), tmp = tmp.getSiguiente());
                if (tmp != null) {
                    predesor.setSiguiente(tmp.getSiguiente());
                    if (tmp == cola) {
                        cola = predesor;
                    }
                    longitud--;
                }
            }
        }
    }
    
    public Nodo returnCabeza(){
        return cabeza;
    }
}
