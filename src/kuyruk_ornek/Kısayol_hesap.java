package kuyruk_ornek;

import java.util.ArrayList;

public class Kısayol_hesap {

    Konum baslangic;
    Konum hedef;
    ArrayList<Kuyruk> kuyruklar;
    int arrayListS=0;
    int kuyrukS=0;
    int konumS=0;

    public Kısayol_hesap(Konum baslangic, Konum hedef) {
        this.baslangic = baslangic;
        this.hedef = hedef;
        kuyruklar = new ArrayList<>();
        Kuyruk anaKonum = new Kuyruk(1);
        anaKonum.ekle(baslangic);
        kuyruklar.add(anaKonum);
        

    }

    public int kısayolHesapla() {
        int adimSayisi = 0;
        boolean bitti = false;

        while (!bitti) {
            int kuyruksayisi = kuyruklar.size();
            int sayac = 0;
            
            while (sayac < kuyruksayisi) {
                
                konumS = 0;
                while (!kuyruklar.get(sayac).bosMu()) {
                    
                    Konum temp = kuyruklar.get(sayac).cikar();

                    if (temp.pozX == hedef.pozX && temp.pozY == hedef.pozY) {
                        bitti = true;
                        return adimSayisi;
                    } else {

                        kuyruklar.add(konumAyarla(temp));
                    }
                    System.out.println("ArrayList : "+arrayListS+" Kuyruk :"+sayac+" Konum : "+konumS+" -- >temp x :" + temp.pozX + " temp y: " + temp.pozY + " = bitti mi ? ->" + bitti);
                    
                    konumS++;
                }
                kuyrukS++;
                sayac++;
            }
            System.out.println("Adım sayısı arttı");
            adimSayisi++;
            kuyrukS=0;
            arrayListS++;
        }

        return 0;
    }
    
    

    public Kuyruk konumAyarla(Konum konum) {
        Kuyruk konumlar = new Kuyruk(8);
        Konum birinciDurum = new Konum(konum.pozX - 1, konum.pozY + 2);
        konumlar.ekle(birinciDurum);
        Konum ikinciDurum = new Konum(konum.pozX - 1, konum.pozY - 2);
        konumlar.ekle(ikinciDurum);
        Konum ucuncuDurum = new Konum(konum.pozX + 1, konum.pozY + 2);
        konumlar.ekle(ucuncuDurum);
        Konum dorduncuDurum = new Konum(konum.pozX + 1, konum.pozY - 2);
        konumlar.ekle(dorduncuDurum);
        Konum besinciDurum = new Konum(konum.pozX - 2, konum.pozY + 1);
        konumlar.ekle(besinciDurum);
        Konum altinciDurum = new Konum(konum.pozX - 2, konum.pozY - 1);
        konumlar.ekle(altinciDurum);
        Konum yedinciDurum = new Konum(konum.pozX + 2, konum.pozY + 1);
        konumlar.ekle(yedinciDurum);
        Konum sekizinciDurum = new Konum(konum.pozX + 2, konum.pozY - 1);
        konumlar.ekle(sekizinciDurum);

        return konumlar;
    }

    public static void main(String[] args) {
        Kısayol_hesap k = new Kısayol_hesap(new Konum(7, 0), new Konum(0, 7));
        System.out.println(k.kısayolHesapla());
    }
}
