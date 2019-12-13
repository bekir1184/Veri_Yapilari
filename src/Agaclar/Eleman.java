
package Agaclar;

public class Eleman{
    Eleman sol;
    Eleman sag;
    
    int veri;
    
     /*İkili ağaç düğümü oluşturulurken her defasında sol ve sağı boş olan 
    bir düğüm oluşturulur*/
   
    
    public Eleman(int veri) {
        this.veri=veri;
        sol=sag=null;
    }
    
    public void elemanGoster(){
        System.out.println(" "+ veri +" ");
    }
    
}