package StackBagliListe;

class Eleman{
    int icerik;
    Eleman ileri;
    public Eleman(int icerik){
        this.icerik=icerik;
        ileri=null;
    }
}

public class Liste {
    Eleman ust;
    public Liste(){
        ust=null;
    }
    boolean listeBos(){
        if(ust==null){
            return true;
        }
        else{
            return false;
        }
    }
    void elemanEkle(Eleman yeni){
        if(listeBos()){
            ust=yeni;
        }
        else{
           yeni.ileri=ust;
           ust=yeni;
        }
        
    }
    Eleman elemanCikar(){
        Eleman e=ust;
        if(!listeBos()){
            ust=ust.ileri;
        }
       return e;
    }
    String  listele(){
        String liste="";
        Eleman tmp=ust;
        while(tmp!=null){
            liste+="["+tmp.icerik+"]"+"\n";
            tmp=tmp.ileri;
        }
        return liste;
    }
    public static void main(String[] args) {
        Liste liste= new Liste();
        System.out.println("-----Liste----");
        for (int i = 0; i < 10; i++) {
            liste.elemanEkle(new Eleman(i));
        }
        System.out.println(liste.listele());
        System.out.println("-----Eleman Çıkar-----");
        liste.elemanCikar();
        System.out.println("---Yeni Liste----");
        System.out.println(liste.listele());
        
    }
    
    
}
