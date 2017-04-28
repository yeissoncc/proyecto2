
package metodos;

import java.util.ArrayList;

public class mezcla extends metodos_ord{
    
    public mezcla(ArrayList<Integer> lis){
        super(lis);
    }
    
    @Override
    public void ordenar(){
        long time_s = System.currentTimeMillis();
        this.lista_desordenada = this.ordenar_lis(this.lista_desordenada);
        long time_e = System.currentTimeMillis();
        this.tiempo_ejecucion = time_e - time_s;
    }
    
    private ArrayList<Integer> ordenar_lis(ArrayList<Integer> lis){
        int n = lis.size();
        int m = (int) n/2;
        
        if (n==1){
            return lis;
        }
        
        ArrayList<Integer> left = new ArrayList<Integer>();
        for(int i = 0; i < m; i++){
            int tmp = lis.get(i);
            left.add(tmp);
        }
        
        left = this.ordenar_lis(left);
        
        ArrayList<Integer> right = new ArrayList<Integer>();
        for(int i = m; i < lis.size(); i++){
            int tmp = lis.get(i);
            right.add(tmp);
        }
        
        right = this.ordenar_lis(right);
        
        return this.merge(left,right);
    }
    
    private ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int len_left = left.size(); 
        int len_right = right.size(); 
 
        while(i < len_left || j < len_right){ 
            if(i >= len_left){ 
                result.add(right.get(j)); 
                j = j + 1;
            }
            else{
                if(j >= len_right){ 
                    result.add(left.get(i)); 
                    i = i + 1;
                }
                else{
                    if(left.get(i) < right.get(j)){ 
                        result.add(left.get(i)); 
                        i = i + 1;
                    }
                    else{ 
                        result.add(right.get(j)); 
                        j = j + 1;
                    }
                }
            }
        }
        return result;
    }    
}
