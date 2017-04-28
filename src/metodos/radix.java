package metodos;

import java.util.ArrayList;

public class radix extends metodos_ord{
    
    public radix(ArrayList<Integer> lis){
        super(lis);
    }
    
    @Override
    public void ordenar(){
        long time_s = System.currentTimeMillis();
        this.lista_desordenada = this.radixsort(this.lista_desordenada);
        long time_e = System.currentTimeMillis();
        this.tiempo_ejecucion = time_e - time_s;
    }
    
    private ArrayList<Integer> radixsort(ArrayList<Integer> lis){
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        ArrayList<ArrayList<Integer>> tmp = this.pos_neg(lis);
        
        ArrayList<Integer> pos = tmp.get(0);
        ArrayList<Integer> neg = tmp.get(1);
        
        neg = this.conv_pos(neg);
        
        int max_pos = this.det_digitos(pos);
        int max_neg = this.det_digitos(neg);
        
        int max = 0;
        
        if (max_pos >= max_neg){
            max = max_pos;
        }
        else{
            max = max_neg;
        }
        
        for(int i = 0; i < max; i++){
            
            ArrayList<ArrayList<Integer>> cola = new ArrayList<ArrayList<Integer>>();
            
            for(int j = 0; j < 10; j++){
                ArrayList<Integer> l = new ArrayList<Integer>();
                cola.add(l);
            }
            pos = this.radix_sort_lsd(pos, cola, i+1);
        }
        
        for(int i = 0; i < max; i++){
            
            ArrayList<ArrayList<Integer>> cola = new ArrayList<ArrayList<Integer>>();
            
            for(int j = 0; j < 10; j++){
                ArrayList<Integer> l = new ArrayList<Integer>();
                cola.add(l);
            }
            neg = this.radix_sort_lsd(neg, cola, i+1);
        }
        
        ArrayList<Integer> tmp2 = new ArrayList<Integer>();
        
        for(int i = neg.size() - 1; i >= 0; i--){
            tmp2.add(neg.get(i) * -1);
        }
        neg = tmp2;
        
        for(int i = 0; i < neg.size(); i++){
            res.add(neg.get(i));
        }
        for(int i = 0; i < pos.size(); i++){
            res.add(pos.get(i));
        }
        
        return res;
    }
    
    private ArrayList<Integer> radix_sort_lsd(ArrayList<Integer> lis, ArrayList<ArrayList<Integer>> cola, int n){
        
        int div = 1;
        for(int i = 0; i < n; i++){
            div = 10 * div;
        }
        
        for(int i = 0; i < lis.size(); i++){
            if (div == 10){
                int pos = lis.get(i) % 10;
                cola.get(pos).add(lis.get(i));
            }
            else{
                int var = (int) (lis.get(i)/ (div / 10));
                if (var == 0){
                    cola.get(0).add(lis.get(i));
                }
                else{
                    int mod = (int)(lis.get(i) % div);
                    int pos = (int)(mod/(div/10));
                    cola.get(pos).add(lis.get(i));
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < cola.size(); i++){
            for(int j = 0; j < cola.get(i).size(); j++){
                if(cola.get(i).get(j) != null){
                    res.add(cola.get(i).get(j));
                }
            }
        }
        
        return res;
    }
    
    private ArrayList<Integer> conv_pos(ArrayList<Integer> lis){
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < lis.size(); i++){
            res.add(lis.get(i)* -1);
        }
        
        return res;
    }
    
    private ArrayList<ArrayList<Integer>> pos_neg(ArrayList<Integer> lis){
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        
        for(int i = 0; i < lis.size(); i++){
            if(lis.get(i) >= 0){
                pos.add(lis.get(i));
            }
            else{
                neg.add(lis.get(i));
            }
        }
        
        res.add(pos);
        res.add(neg);
        
        return res;
    }
    
    private int det_digitos(ArrayList<Integer> lis){
        int digitos = 0;
        for(int i = 0; i < lis.size(); i++){
            int tmp = con_dig(lis.get(i));
            if(tmp > digitos){
                digitos = tmp;
            }
        }
        return digitos;
    }
    
    private int con_dig(int num){
        String a = Integer.toString(num);
        int tam = a.length();
        return tam;
    }
}