/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import fes.aragon.lectura.Leer;
import fes.aragon.listas.Lista;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author perex
 */
public class ListaExamen {
    private Lista datos;
    
    public static void main(String[] args) throws IOException {
        
       File archivo;
       
        
       Lista listaUno =new Lista();
        for (int i = 0; i < 10000; i++) {
            listaUno.agregarCola(new Integer(new Random().nextInt(300)));
        }
        listaUno.imprimir(); 
        
        File miArchivo;
        PrintWriter escribir;
        miArchivo = new File("C:\\Users\\Fernando\\Documents\\Documentoestructuras\\ListasE.txt");
        if(!miArchivo.exists()){
            try{  
                miArchivo.createNewFile();
            }catch(Exception e){
            }
        }else{
            try {
                escribir = new PrintWriter(miArchivo);
                for (int i = 0; i < listaUno.getLongitud(); i++) {
                escribir.print(listaUno.obtenerNodo(i)+",");
                }
                
                escribir.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }       
    }
        
}
