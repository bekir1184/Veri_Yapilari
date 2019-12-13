package Genel_Ornekler;

public class Ornek_1 {
    public static void main(String[] args) {
        Liste liste= new Liste();
        liste.sonaEkle(new Dugum(5));
        liste.sonaEkle(new Dugum(4));
        liste.sonaEkle(new Dugum(3));
        liste.sonaEkle(new Dugum(2));
        liste.sonaEkle(new Dugum(1));
        System.out.println(Liste.siraliMi(liste));
    }
}

class Dugum {

    int icerik;
    Dugum ileri;

    public Dugum(int icerik) {
        this.icerik = icerik;
        this.ileri = null;
    }
}

class Liste {

    Dugum bas;
    Dugum son;

    public Liste() {
        this.bas = null;
        this.son = null;
    }

    void basaEkle(Dugum yeni) {
        if (son == null) {
            bas = son = yeni;
        } else {
            yeni.ileri = bas;
            bas = yeni;
        }
    }

    void sonaEkle(Dugum yeni) {
        if (bas == null) {
            bas = son = yeni;
        } else {
            son.ileri = yeni;
            son = yeni;
        }
    }

    void arayaEkle(Dugum yeni, int ara) {
        if (bas == null) {
            basaEkle(yeni);
        } else if (bas == son) {
            basaEkle(yeni);
        } else {
            Dugum temp = bas;
            while (temp.ileri != null) {
                if (temp.icerik == ara) {
                    yeni.ileri = temp.ileri;
                    temp.ileri = yeni;
                    break;
                }
                temp = temp.ileri;
            }
        }

    }

    void bastanSil() {
        bas = bas.ileri;
        if (bas == null) {
            son = null;
        }
    }

    void sondanSil() {

        Dugum temp = bas;
        Dugum once = null;
        while (temp.ileri != null) {
            once = temp;
            temp = temp.ileri;
        }
        //once ilerlemişse tek eleman var 
        if (once == null) {
            bas = son = null;
        } else {
              once.ileri=null;
              son=once;
        }

    }

    void aradanSil(int aranan) {
        Dugum temp=bas;
        Dugum once=null;
        while(temp.ileri != null){
            if(temp.icerik == aranan){
                break;
            }
            else{
                once=temp;
                temp=temp.ileri;
            }
        }
        if(once==null){
            bas=bas.ileri;
        }
        else{
            once.ileri=temp.ileri;
        }
    }
    static boolean siraliMi(Liste liste){
        boolean siraliMi=true;
        Dugum temp=liste.bas;
        while(temp.ileri!=null){
            if(temp.icerik <= temp.ileri.icerik){
                siraliMi=false;
                break;
            }
            else{
                temp=temp.ileri;
            }
        }
        
        
        return siraliMi;
    }
    

}
