package Genel_Ornekler;
/*
4-Öğrenci verisi olarak sadece not bilgisi tutalacaktır.
a)Düğüm ve bağlı yığıt yapısını push ve pop metotlarını ile verin.
b)Yığıtın bağları üzeride gezinmeden push ve pop metotları kullanarak girilen 
yığıt nesnesinin not ort bulan metot.

*/
public class Orenk_4 {
    public static void main(String[] args) {
        StackListe liste= new StackListe();
        liste.ekle(new Dugum4(1));
        liste.ekle(new Dugum4(3));
        liste.ekle(new Dugum4(4));
        liste.ekle(new Dugum4(5));
        System.out.println(liste.ortalamaHesapla());
    }
    
}
class Dugum4{
    int icerik;
    Dugum4 ileri;
    public Dugum4(int icerik) {
        this.icerik=icerik;
        this.ileri=null;
    }
    
}
class StackListe{
    Dugum4 ust;
    public StackListe(){
        ust=null;
    }
    void ekle(Dugum4 yeni){
        if(ust==null){
            ust=yeni;
        }
        else{
            yeni.ileri=ust;
            ust=yeni;
        }
    }
    Dugum4 cikar(){
        Dugum4 temp=ust;
        
        if(ust!=null){
            ust=ust.ileri;
        }
        
        return temp;
    }
    int ortalamaHesapla(){
        int toplam=0;
        int ortalama=0;
        int sayac=0;
        
        while(ust!=null){
            Dugum4 temp=cikar();
            toplam+=temp.icerik;
            sayac++;
        }
        ortalama=toplam/sayac;
        
        return ortalama;
    }
}
