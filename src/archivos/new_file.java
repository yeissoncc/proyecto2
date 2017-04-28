package archivos;

import java.io.*;
import java.util.ArrayList;

public class new_file{
    
    private String Name = "prueba.txt";
    
    public void write(ArrayList<Integer> lis, String s){
        this.Name = s;
        try{
            File arch = new File(this.Name);
            if(arch.exists()){
                System.out.println("ya existe el archivo de prueba");
            }
            else{
                FileWriter ecrb = new FileWriter(arch,true);
                for(int i = 0; i < lis.size(); i++){
                    String tmp = lis.get(i).toString()+ "\r\n";
                    ecrb.write(tmp);
                }
                ecrb.close();
            }
        }catch(Exception e){
            System.out.println("Error al editar archivo" + e);
        }
    }
    
    public ArrayList<Integer> leer(){
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        try{
            
            FileReader lec = new FileReader(this.Name);
            BufferedReader cntd = new BufferedReader(lec);
            
            String texto;
            
            while((texto = cntd.readLine())!= null){
                int tmp = Integer.valueOf(texto);
                res.add(tmp);
            }
            lec.close();
            cntd.close();
        }catch(Exception e){
            System.out.println("Error al leer archivo" + e);
        }
        return res;
    }
}