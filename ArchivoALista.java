/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.archivo;

import fes.aragon.listas.Lista;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ArchivoALista {

    public Lista lista = new Lista();
//Pura lectura del archivo, sin escribir en el, recibe un archivo, devuelve una lista
    public ArchivoALista(File file) throws FileNotFoundException, IOException {

        String data;
        String[] token;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        while ((data = br.readLine()) != null) {
            token = data.split(",");
            for (String single : token) {
                lista.agregarCola(single);
            }
        }

    }

    public Lista getLista() {
        return lista;
    }

}
