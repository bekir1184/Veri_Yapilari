package Graflar;

public class Eleman {
    int baslangic;
    int bitis;
    int agirlik;
    Eleman ileri;

    public Eleman(int baslangic, int bitis, int agirlik) {
        this.baslangic = baslangic;
        this.bitis = bitis;
        this.agirlik = agirlik;
        ileri= null;
    }
    public Eleman (int baslangic,int bitis){
        this.baslangic=baslangic;
        this.bitis=bitis;
        ileri=null;
        
    }

    
    
}
