
package metodos;

import java.util.ArrayList;

public class monticulo extends metodos_ord {
    
    public monticulo(ArrayList<Integer> lis){
        super(lis);
    }
    
    @Override
    public void ordenar(){
        long time_s = System.currentTimeMillis();
        this.lista_desordenada = heap_sort(this.lista_desordenada);
        long time_e = System.currentTimeMillis();
        this.tiempo_ejecucion = time_e - time_s;
    }
    
    private ArrayList<Integer> heap_sort(ArrayList<Integer> lis){
        
        int fin = lis.size();
        int start = ((int)(fin / 2)) - 1;
        for(int i = start; i >= 0; i--){
            this.heapify(lis,fin,i);
        }
        for(int i = fin-1; i > 0; i--){
            this.swap(lis,i,0);
            this.heapify(lis, i, 0);
        }
        
        return lis;
    }
    
    private void swap(ArrayList<Integer> lis, int i, int j){
        int aux = lis.get(i);
        lis.set(i, lis.get(j));
        lis.set(j, aux);
    }
    
    private void heapify(ArrayList<Integer> lis, int fin, int i){
        int l = 2 * i + 1;
        int r = 2 * (i + 1);
        int max = i;
        if((l < fin) && (lis.get(i) < lis.get(l))){
            max = l;
        }
        if((r < fin) && (lis.get(max) < lis.get(r))){
            max = r;
        }
        if(max != i){
            this.swap(lis,i,max);
            this.heapify(lis, fin, max);
        }
    }
}
