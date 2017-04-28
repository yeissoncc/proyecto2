package metodos;

import java.util.ArrayList;

public class insercion extends metodos_ord{

    public insercion(ArrayList<Integer> lis) {
        super(lis);
    }
    
    @Override
    public void ordenar(){
        long time_s = System.currentTimeMillis();
        for(int i = 0; i < this.get_tam()-1; i++){
            for(int j = 0; j < this.get_tam()-1; j++){
                int a = this.lista_desordenada.get(j);
                int b = this.lista_desordenada.get(j+1);
                if(a>b){
                    this.lista_desordenada.set(j, b);
                    this.lista_desordenada.set(j+1,a);
                }
            }
        }
        long time_e = System.currentTimeMillis();
        this.tiempo_ejecucion = time_e - time_s;
    }
}