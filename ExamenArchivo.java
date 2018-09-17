/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Abre el archivo de texto en un nuevo programa y guarda los datos en una lista,
para que despues busques los numeros del 30 al 150 e indiques cuantas veces se 
repite.
 */
package fes.aragon;

import fes.aragon.archivo.ArchivoALista;
import fes.aragon.archivo.NumeroRepetido;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ExamenArchivo {
    public static void main(String[] args) throws IOException {
        File f = new File(System.getProperty("user.dir")+"\\ListaE.txt");
        
        ArchivoALista archivo = new ArchivoALista(f);
        NumeroRepetido nr= new NumeroRepetido(archivo.getLista());
        //lista=archivo.getLista();
        nr.imprimirResultado();
        
       
    }
}
