
package Genel_Ornekler;


/*
3-Bir bağlı liste yapısı ile tek paremetreye sahip bir polinom (Örn P(x)=x^3+3x^2+5x+10)tutulmak
isteniyor.Bağlı listedeki her bir düğüm polinomun ilgili teriminin katsayı ve 
derecesini tutmaktadır.Buna göre;
    a)Bağlı liste ve düğüm veri yapısını veriniz.
    b)Bağlı listeye ekleme işlemini dereceye göre sıralı yapan kodu veriniz
    c)Kedisine paremetre olarak bir x sayısı ve bağlı listeyi alarak girilen sayıya
    göre polinomun değerini hesaplayan metodu yazınız.

*/

public class Ornek_3 {
    public static void main(String[] args) {
        Polinom p= new Polinom();
        p.ekle(new PolinomDugum(2, 4));
        p.ekle(new PolinomDugum(3, 0));
        p.ekle(new PolinomDugum(1, 2));
        
        
        System.out.println(p.listele());
        
        System.out.println(p.hesapla(3));
    }
   
}
//(Örn P(x)=x^3+3x^2+5x+10)
class PolinomDugum{
    int katsayı;
    int derece;
    PolinomDugum ileri;

    public PolinomDugum(int katsayı, int derece) {
        this.katsayı = katsayı;
        this.derece = derece;
        this.ileri = null;
    }
    
}
class Polinom{
    PolinomDugum bas;
    PolinomDugum son;
    public Polinom() {
        bas=son=null;
    }
    
  
    
    void ekle(PolinomDugum dugum){
        if(bas==null){
            bas=son=dugum;
            
        }
        else{
            if(dugum.derece>=bas.derece){
                basaEkle(dugum);
            }
            else if(dugum.derece <= son.derece ){
                sonaEkle(dugum);
            }
            else{
                PolinomDugum temp=bas;
                PolinomDugum once=bas;
                while(temp!=null){
                    
                    if(temp.derece<dugum.derece){
                        once.ileri=dugum;
                        dugum.ileri=temp;
                    }
                    once=temp;
                    temp=temp.ileri;
                }
            }
             
        }
        
    }
    int  hesapla(int x){
        int toplam=0;
        PolinomDugum temp=bas;
        while(temp.ileri!=null){
            toplam+=x*Math.pow(temp.katsayı, temp.derece);
            temp=temp.ileri;
        }
        return toplam;
    }
     
    void basaEkle(PolinomDugum yeni) {
        if (son == null) {
            bas = son = yeni;
        } else {
            yeni.ileri = bas;
            bas = yeni;
        }
    }

    void sonaEkle(PolinomDugum yeni) {
        if (bas == null) {
            bas = son = yeni;
        } else {
            son.ileri = yeni;
            son = yeni;
        }
    }

    void arayaEkle(PolinomDugum yeni, int ara) {
        if (bas == null) {
            basaEkle(yeni);
        } else if (bas == son) {
            basaEkle(yeni);
        } else {
            PolinomDugum temp = bas;
            while (temp.ileri != null) {
                if (temp.derece == ara) {
                    yeni.ileri = temp.ileri;
                    temp.ileri = yeni;
                    break;
                }
                temp = temp.ileri;
            }
        }

    }
    String  listele(){
        String liste="";
        PolinomDugum tmp=bas;
        while(tmp!=null){
            liste+="["+tmp.katsayı+"]"+"\n";
            tmp=tmp.ileri;
        }
        return liste;
    }
    
    
    
}