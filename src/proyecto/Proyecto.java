/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import metodos.*;
import archivos.*;
import java.util.ArrayList;


public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        for(int i = 0; i < 10000; i++){
            int v = (int) (Math.random()*(99999-(-99999)+1)+(-99999));
            a.add(v);
        }
        
        new_file prueba = new new_file();
        prueba.write(a,"prueba.txt");
        
        ArrayList<Integer> datos = prueba.leer();
        
        metodos_ord ins = new insercion(datos);
        ins.ordenar();
        System.out.print("tiempo de ejecucion de insercion en ms: ");
        System.out.println(ins.tiempo_ejecucion);
        prueba.write(ins.lista_desordenada, "res_ins.txt");
        
        metodos_ord cont = new conteo(datos);
        cont.ordenar();
        System.out.print("tiempo de ejecucion de conteo en ms: ");
        System.out.println(cont.tiempo_ejecucion);
        prueba.write(cont.lista_desordenada, "res_conteo.txt");
        
        metodos_ord mez = new mezcla(datos);
        mez.ordenar();
        System.out.print("tiempo de ejecucion de mezcla en ms: ");
        System.out.println(mez.tiempo_ejecucion);
        prueba.write(mez.lista_desordenada, "res_mezcla.txt");
        
        metodos_ord mont = new monticulo(datos);
        mont.ordenar();
        System.out.print("tiempo de ejecucion del monticulo en ms: ");
        System.out.println(mont.tiempo_ejecucion);
        prueba.write(mont.lista_desordenada, "res_monticulo.txt");
        
        metodos_ord rad = new radix(datos);
        rad.ordenar();
        System.out.print("tiempo de ejecucion radix en ms: ");
        System.out.println(rad.tiempo_ejecucion);
        prueba.write(rad.lista_desordenada, "res_radix.txt");
        
        metodos_ord rap = new rapido(datos);
        rap.ordenar();
        System.out.print("tiempo de ejecucion del rapido en ms: ");
        System.out.println(rap.tiempo_ejecucion);
        prueba.write(rap.lista_desordenada, "res_rapido.txt");
        
    }
    
}
