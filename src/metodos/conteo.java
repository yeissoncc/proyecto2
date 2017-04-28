package metodos;

import java.util.ArrayList;

public class conteo extends metodos_ord{
    
    public conteo(ArrayList<Integer> lis){
        super(lis);
    }
    
    @Override
    public void ordenar(){
        long time_s = System.currentTimeMillis();
        this.lista_desordenada = this.couting_sort(this.lista_desordenada);
        long time_e = System.currentTimeMillis();
        this.tiempo_ejecucion = time_e - time_s;
    }
    
    private ArrayList<Integer> couting_sort(ArrayList<Integer> lis){
        
        ArrayList<ArrayList<Integer>> tmp = this.sep_num(lis);
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> pos = tmp.get(0);
        ArrayList<Integer> neg = tmp.get(1);
        
        ArrayList<Integer> N_neg = this.inv_neg(neg);
        
        ArrayList<Integer> res_pos = this.couting(pos);
        ArrayList<Integer> res_neg = this.couting(N_neg);
        
        ArrayList<Integer> Nres_neg = this.vol_neg_ord(res_neg);
        
        for(int i = 0; i < Nres_neg.size(); i++){
            res.add(Nres_neg.get(i));
        }
        for(int i = 0; i < res_pos.size(); i++){
            res.add(res_pos.get(i));
        }
        return res;
    }
    
    private ArrayList<Integer> couting(ArrayList<Integer> lis){

        int n = lis.size();
        int m = this.max_val(lis) + 1;
        ArrayList<Integer> count = new ArrayList<Integer>();
        for(int i = 0; i < m; i++){
            count.add(0);
        }
        for(int j = 0; j < n; j++){
            int tmp = lis.get(j);
            int tmp2 = count.get(tmp);
            tmp2++;
            count.set(tmp,tmp2);
        }
        
        int i = 0;
        
        for(int k = 0; k < m; k++){
            for(int l = 0; l < count.get(k); l++){
                lis.set(i, k);
                i++;
            }
        }
        
        return lis;
    }
    
    private ArrayList<ArrayList<Integer>> sep_num(ArrayList<Integer> lis){
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        
        for(int i=0; i<lis.size(); i++){
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
    
    private ArrayList<Integer> vol_neg_ord(ArrayList<Integer> neg){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (neg != null){
            for(int i = neg.size()-1; i >= 0; i-- ){
                res.add(neg.get(i)* -1);
            }
        }
        return res;
    }
    
    private ArrayList<Integer> inv_neg(ArrayList<Integer> neg){
        if(neg != null){
            for(int i=0; i<neg.size(); i++){
                neg.set(i, neg.get(i) * -1);
            }
        }
        return neg;
    }
    
    private int max_val(ArrayList<Integer> lis){
        int max = 0;
        for(int i = 0; i < lis.size(); i++){
            if(max < lis.get(i)){
                max = lis.get(i);
            }
        }
        return max;
    }
    
}