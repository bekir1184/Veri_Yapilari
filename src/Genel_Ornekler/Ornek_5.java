package Genel_Ornekler;



/*
6-Kutupahane prog kitaplar içi Kitap adı,yazar adı,Kütüpahane kodu tutulacaktır
a)Yukarıdaki bilgileri tutacak bir sınıf yapısı
b)Tanımlanan tipten en cok 50 elemanı tutacak statik kuyruk

*/
public class Ornek_5 {
    
}
class Kitap{
    String kitapAdi;
    String yazarAdi;
    int KutupaheneKodu;

    public Kitap(String kitapAdi, String yazarAdi, int KutupaheneKodu) {
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.KutupaheneKodu = KutupaheneKodu;
    }
    
}
class Kuyruk{
    int boyut=50;
    int elemanSayisi=0;
    Kitap kitaplar[]= new Kitap[boyut];
    int bas=0;
    int son=-1;
    
    
    void ekle(Kitap yeni){
       if(son == boyut-1){
           son=-1;
       }
       else{
           kitaplar[++son]=yeni;
           elemanSayisi++;
       }
    }
    Kitap cikar(){
        Kitap temp=kitaplar[bas++];
        if(bas==boyut){
            son=-1;
        }
        elemanSayisi--;
        return temp;
    }
    

}
