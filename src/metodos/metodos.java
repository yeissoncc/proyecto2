/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.ArrayList;





public class metodos {
    
    public static void main(String[] args){
        
        /*
            aqui probamos si los metodos de ordenamiento funcionan
        */
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < 10000; i++){
            int v = (int) (Math.random()*(99999-(-99999)+1)+(-99999));
            a.add(v);
        }
        
        System.out.println("lista de pruba:  ");
        System.out.println(a);
        
        metodos_ord prueba = new insercion(a);
        prueba.ordenar();
        System.out.println("metodo insercion: ");
        System.out.println(prueba.lista_desordenada);
        System.out.print(" tiempo de ejecucion en ms: ");
        System.out.println(prueba.tiempo_ejecucion);
        
        metodos_ord prueba_mezcla = new mezcla(a);
        prueba_mezcla.ordenar();
        System.out.println("metodo mezcla: ");
        System.out.println(prueba_mezcla.lista_desordenada);
        System.out.print(" tiempo de ejecucion en ms: ");
        System.out.println(prueba_mezcla.tiempo_ejecucion);
        
        metodos_ord prueba_monticulo = new monticulo(a);
        prueba_monticulo.ordenar();
        System.out.println("metodo monticulo: ");
        System.out.println(prueba_monticulo.lista_desordenada);
        System.out.print(" tiempo de ejecucion en ms: ");
        System.out.println(prueba_monticulo.tiempo_ejecucion);
        
        metodos_ord pru_rapido = new rapido(a);
        pru_rapido.ordenar();
        System.out.println("metodo rapido: ");
        System.out.println(pru_rapido.lista_desordenada);
        System.out.print(" tiempo de ejecucion en ms: ");
        System.out.println(pru_rapido.tiempo_ejecucion);
        
        metodos_ord pru_conteo = new conteo(a);
        pru_conteo.ordenar();
        System.out.println("metodo couting sort: ");
        System.out.println(pru_conteo.lista_desordenada);
        System.out.print(" tiempo de ejecucion en ms: ");
        System.out.println(pru_conteo.tiempo_ejecucion);
        
        metodos_ord pru_radix = new radix(a);
        pru_radix.ordenar();
        System.out.println("metodo radix sort: ");
        System.out.println(pru_radix.lista_desordenada);
        System.out.print(" tiempo de ejecucion en ms: ");
        System.out.println(pru_radix.tiempo_ejecucion);
        
    }
}
