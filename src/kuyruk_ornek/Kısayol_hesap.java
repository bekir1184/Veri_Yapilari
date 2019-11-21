package kuyruk_ornek;

import java.util.ArrayList;

public class Kısayol_hesap {

    Konum baslangic;
    Konum hedef;
    ArrayList<Kuyruk> kuyruklar;
    int arrayListS = 0;
    int konumS = 0;

    public Kısayol_hesap(Konum baslangic, Konum hedef) {
        this.baslangic = baslangic;
        this.hedef = hedef;
        kuyruklar = new ArrayList<>();
        Kuyruk anaKonum = new Kuyruk(1);
        anaKonum.ekle(baslangic);
        kuyruklar.add(anaKonum);
        

    }
    public Kısayol_hesap(Konum hedef){
        this.baslangic=new Konum(0,0);
        this.hedef=hedef;
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
                    System.out.println("ArrayList : " + arrayListS + " Kuyruk :" + sayac + " Konum : " + konumS + " -- >temp x :" + temp.pozX + " temp y: " + temp.pozY + " = bitti mi ? ->" + bitti);

                    konumS++;
                }

                sayac++;
            }
            System.out.println("Adım sayısı arttı");
            adimSayisi++;
            arrayListS++;
        }

        return 0;
    }
    public int alinanMesafe(){
        int adimSayisi=0;
        while(true){
            System.out.println("baslangic x:"+baslangic.pozX+" baslangic y: "+baslangic.pozY+" hedef x:"+hedef.pozX+" hedef y: "+hedef.pozY);
            if(baslangic.pozX > 7){
                baslangic.pozY=baslangic.pozY+1;
                baslangic.pozX=0;
            }
            if(baslangic.pozY > 7){
                break;
                
            }
            if(baslangic.pozX == hedef.pozX && baslangic.pozY== hedef.pozY){
                break;
                
            }
            baslangic.pozX=baslangic.pozX+1;
            adimSayisi++;
        }
        
        
        
        return adimSayisi;
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
        
        konumlar.ekle(new Konum(konum.pozX+1,konum.pozY+1));
        konumlar.ekle(new Konum(konum.pozX-1,konum.pozY-1));
        
        return konumlar;
    }

    public static void main(String[] args) {
        Kısayol_hesap k = new Kısayol_hesap(new Konum(0, 5), new Konum(5, 2));
        //System.out.println(k.kısayolHesapla());
        Kısayol_hesap quiz = new Kısayol_hesap(new Konum(2,2));
       System.out.println(quiz.alinanMesafe());
    
    }
}
