package metodos;

import java.util.ArrayList;

public class rapido extends metodos_ord{
    
    public rapido(ArrayList<Integer> lis){
        super(lis);
    }
    
    @Override
    public void ordenar(){
        long time_s = System.currentTimeMillis();
        this.lista_desordenada = this.quicksort(this.lista_desordenada);
        long time_e = System.currentTimeMillis();
        this.tiempo_ejecucion = time_e - time_s;
    }
    
    private ArrayList<Integer> quicksort(ArrayList<Integer> lis){
        int izq = 0;
        int der = lis.size()-1;
        ArrayList<Integer> res = quick(lis,izq,der);
        return res;
    }
    
    private ArrayList<Integer> quick(ArrayList<Integer> lis,int izq,int der){
        int i = izq;
        int j = der;
        int m = (int)((izq + der) / 2);
        int x = lis.get(m);
        while(i <= j){
            while(lis.get(i) < x && j <= der){
                i++;
            }
            while(x < lis.get(j) && j > izq){
                j--;
            }
            if(i <= j){
                int aux = lis.get(i);
                lis.set(i, lis.get(j));
                lis.set(j, aux);
                i++;
                j--;
            }
            if(izq < j){
                this.quick(lis, izq, j);
            }
            if(i < der){
                this.quick(lis, i, der);
            }
        }
        return lis;
    }
}