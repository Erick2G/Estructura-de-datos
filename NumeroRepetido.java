/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.archivo;

import fes.aragon.listas.Lista;
import fes.aragon.listas.Nodo;

/**
 *
 * @author user
 */
public class NumeroRepetido {

    public Lista listaNumeros = new Lista();//Donde se van a guardar los valores entre 30 y 150, sin que se repitan y cuantas veces se repitio

    public NumeroRepetido(Lista lista) {
        boolean seRepite;
        int repetir;
        Nodo temp = lista.returnCabeza();

        for (int cont = 0; cont < lista.getLongitud() && temp != null; cont++, temp = temp.getSiguiente()) {
            seRepite = false;

            int a = Integer.parseInt((String) temp.getDato()); //Convertir dato de temp a int
            
            /*Comparar antes (variable que recorre el arreglo desde el inicio hasta donde esta temp)
            para saber si el valor de temp no ha salido antes*/
            Nodo antes = lista.returnCabeza();
            for (int cont2 = 0; cont2 < cont; cont2++) {/*Se detendra cuando el contador de este for sea igual al del primer for
                                                          para que analice solo lo que esta antes*/
                if (antes.getDato().equals(temp.getDato())) {
                    seRepite = true;
                    /*De haber salido antes el valor actual de temp, "seRepite" cambia a true 
                                       y el siguiente ciclo for no se ejecuta, porque ya se buscó cuantas veces está ese valor
                                       en toda la lista*/
                }
                antes = antes.getSiguiente();
            }

            if (a <= 150 && a >= 30 && seRepite == false) {//Ver si temp esta en el rango de 30-150 y que el valor no haya salido antes (con seREpite)
                /*Compara temp con tempS, (tempS recorrera la lista a partir de 
                un valor despues en la lista de donde esta temp, ninguno antes*/
                repetir = 1;
                for (Nodo tempS = temp.getSiguiente(); tempS != null; tempS = tempS.getSiguiente()) {

                    int b = Integer.parseInt((String) tempS.getDato());
                    if (a == b) {//si los valores se coinciden "repetir" aumenta uno
                        repetir++;//El numero de veces que se repite un numero
                    }
                }
                //Al terminar tempS de recorrer todo el arreglo se guarda en una nueva lista
                String together = temp.getDato().toString() + " se repite: " + repetir + " veces";
                listaNumeros.agregarCola(together);
            }
        }
    }

    public void imprimirResultado() {
        listaNumeros.imprimir();
    }

}
