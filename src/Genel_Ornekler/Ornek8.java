/*
    Bir öğrencinin adının soyadını notu ve numarasını tutan bir 2li
ağaç yapısı üzerinde void kuçukmu(mt eleman) metodu ile gelen elemandan kucuk 
dugumleri yazdıran metot
 */
package Genel_Ornekler;

class Dugumagac {

    String adi;
    String soyAdi;
    int not;
    Dugumagac sag, sol;

    public Dugumagac(String adi, String soAdi, int not) {
        this.adi = adi;
        this.soyAdi = soAdi;
        this.not = not;
        sag = sol = null;
    }

    public void yaz() {
        System.out.println("Adi :" + adi + " Soyadi :" + soyAdi + " Notu :" + not);
    }

}

class Agac {

    Dugumagac kok;

    public Agac() {
        kok = null;
    }
//İkili arama ağacında sağ yaprak boş olmayana kadar gidersek ulaştığımız 
//en sağdaki yaprak en büyük elemandır.

    public Dugumagac max() {
        Dugumagac sonuc = kok;
        while (sonuc != null) {
            sonuc = sonuc.sag;
        }
        return sonuc;
    }
// İkili arama ağacında sol yaprak boş olmayana kadar gidersek ulaştığımız 
// en sağdaki yaprak en buyuk elemandır.    

    public Dugumagac min() {
        Dugumagac sonuc = kok;
        while (sonuc != null) {
            sonuc = sonuc.sol;
        }
        return sonuc;
    }
// Ekleme yaparken gelen sayı ile karşılaştırıyoruz.
// Eğer sayımız root'dan(kök) başlayıp tüm alanlara baka baka büyükse sağa değilse sola doğru kaydırıyoruz.    

    public void ekle(Dugumagac yeni) {
        if (kok == null) {
            kok = yeni;
        } else {
            Dugumagac temp = kok;
            Dugumagac ata = null;
            while (true) {
                ata =temp;
                if (yeni.not < temp.not) {
                    temp = temp.sol;
                    if(temp==null){
                        ata.sol=yeni;
                        return;
                    }
                } else {
                    temp = temp.sag;
                    if(temp==null){
                        ata.sag=yeni;
                        return;
                    }
                }
            }            
        }

    }

    public void inorder(Dugumagac yerelKok) {
        if (yerelKok != null) {
            inorder(yerelKok.sag);
            yerelKok.yaz();
            inorder(yerelKok.sol);
            
        }
    }
    public void kucukMu(Dugumagac eleman){
        if(eleman !=null){
            kucukMu(eleman.sol);
            eleman.yaz();
            kucukMu(eleman.sag);
        }
    }

}

public class Ornek8 {

    public static void main(String[] args) {
        Agac agac = new Agac();
        agac.ekle(new Dugumagac("Bekir", "Erever", 100));
        agac.ekle(new Dugumagac("Asdff", "Es", 10));
        agac.ekle(new Dugumagac("dfafdsg", "Er", 90));
        agac.ekle(new Dugumagac("Bgasd", "eresrrrrrrrrr", 80));
        agac.ekle(new Dugumagac("Beerk", "Erewr", 40));
        agac.ekle(new Dugumagac("Beko", "Erwe", 50));
        agac.ekle(new Dugumagac("Bek11", "Erevsdfs", 55));
        agac.ekle(new Dugumagac("Beker", "Ereasdf", 20));

        agac.inorder(agac.kok);
        System.out.println("kucukMu metot");
        agac.kucukMu(new Dugumagac("Beerk", "Erewr", 40));
    }
}
