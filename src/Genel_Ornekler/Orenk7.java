
package Genel_Ornekler;
 /*
    Sadece tam sayıları tutan bir bağlı listede dugum ve sınıf yapılarını gösteren
    veri yapısını verin .Boolean sıralımı()BagliListe liste) metodu ile listenin
    sıralı olup olmadıgını test eden metot yazınız.
*/

class Eleman{
    int veri;
    Eleman ileri;

    public Eleman(int veri ) {
        this.veri=veri;
        this.ileri=null;
    }
    
}
class BagliListe{
    Eleman bas;
    Eleman son;

    public BagliListe() {
        bas=son=null;
    }
    public void ekle(Eleman yeni){
        if(bas==null){
            bas=son=yeni;
        }
        else{
            son.ileri=yeni;
            son=yeni;
        }
    }
    public void sil(){
        if(bas==son){
            bas=son=null;
        }
        else{
            Eleman tmp=bas;
            Eleman once=null;
            while(tmp.ileri!=null){
               if(tmp.ileri==son){
                   once=tmp;
                   break;
               }
               else{
                   tmp=tmp.ileri;
               }
            }
            if(once!=null){
                son=null;
                son=once;
            }
        }
        
    }
    static boolean siraliMi(BagliListe liste){
        boolean sirali=true;
        Eleman temp=liste.bas;
        while(temp.ileri!=null){
            if(temp.veri>temp.ileri.veri){
                sirali=false;
                break;
            }
            temp=temp.ileri;
            
        }
        
        return sirali;
    }
    
}
public class Orenk7 {
    public static void main(String[] args) {
        BagliListe liste= new BagliListe();
        liste.ekle(new Eleman(5));
        liste.ekle(new Eleman(6));
        liste.ekle(new Eleman(14));
        liste.ekle(new Eleman(8));
        liste.ekle(new Eleman(9));
        liste.ekle(new Eleman(10));
        liste.ekle(new Eleman(11));
        liste.ekle(new Eleman(12));
        liste.ekle(new Eleman(13));
        
        System.out.println(BagliListe.siraliMi(liste));
    }
}
