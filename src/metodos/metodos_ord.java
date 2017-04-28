package metodos;

import java.util.ArrayList;

public abstract class metodos_ord{
    
    public ArrayList<Integer> lista_desordenada;
    public long tiempo_ejecucion;
    private int tamaño;
    
    public metodos_ord(ArrayList<Integer> lis){
        this.lista_desordenada = new ArrayList<Integer>(lis);
        this.tamaño = lis.size();
        this.tiempo_ejecucion = 0;
    }
    
    public int get_tam(){
        return this.tamaño;
    }
    
    public abstract void ordenar();
    
    public void ver_lista(){
        lista_desordenada.forEach((lista_des) -> {
            System.out.println(lista_des);
        });
    }
}

