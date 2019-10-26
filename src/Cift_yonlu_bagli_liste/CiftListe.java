package Cift_yonlu_bagli_liste;

class Eleman {

    int sayi;
    Eleman ileri;
    Eleman geri;

    public Eleman(int sayi) {
        this.sayi = sayi;
        ileri = null;
        geri = null;
    }

}

public class CiftListe {

    Eleman bas;
    Eleman son;

    public CiftListe() {
        bas = null;
        son = null;
    }

    public void basaEkle(Eleman yeni) {
        // Eğer eleman yoksa bas ile son yeni gelen eleman oluyor.
        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            yeni.ileri = bas;
            bas.geri = yeni;
            bas = yeni;
        }
    }

    public void sonaEkle(Eleman yeni) {
        // Eğer eleman yoksa bas ile son yeni gelen eleman oluyor.
        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            yeni.geri = son;
            son.ileri = yeni;
            son = yeni;
        }
    }

    public void bastanSil() {

        if (bas.ileri == null) {
            son = null;
        } else {

            bas.ileri.geri = null;
            bas = bas.ileri;
        }
    }

    public void sondanSil() {

        if (bas.ileri == null) {
            bas = null;
        } else {

            son.geri.ileri = null;
            son = son.geri;
        }
    }

    public void arayaEkle(int nereye, Eleman ekleneceksayi) {
        /*
        Liste içinde aradığımız elemana kadar gidip o elamanı bulduktan sonra 
        arkasına eklemek istediğimiz elemanı ekliyoruz.
         */
        Eleman yedek = bas;
        while (yedek.sayi != nereye) {
            yedek = yedek.ileri;
            if (yedek == null) {
                System.out.println("Hiç Eleman yok");
            }
        }
        if (yedek == son) {
            ekleneceksayi.ileri = null;
            son = ekleneceksayi;
        } else {
            ekleneceksayi.ileri = yedek.ileri;
            yedek.ileri.geri = ekleneceksayi;
        }
        ekleneceksayi.geri = yedek;
        yedek.ileri = ekleneceksayi;
    }

    public void girilenSil(int aranan) {
        Eleman yedek = bas;
        while (yedek.sayi != aranan) {
            yedek = yedek.ileri;
            if (yedek == null) {
                System.out.println("Boş");
            }
        }
        if (yedek == bas) {
            bas = yedek.ileri;
        } else {
            yedek.geri.ileri = yedek.ileri;
        }
    }

    String listele() {
        Eleman yedek = bas;
        String liste = "";
        while (yedek != null) {
            liste = liste + yedek.sayi + "-->";
            yedek = yedek.ileri;
        }
        return liste;
    }
    public static void main(String[] args) {
        CiftListe ciftListe= new CiftListe();
        ciftListe.basaEkle(new Eleman(5));
        System.out.println(ciftListe.listele()+" Liste başına 5 ekledik");
        ciftListe.sonaEkle(new Eleman(7));
        System.out.println(ciftListe.listele()+" Liste sonuna 7 ekledik");
        ciftListe.arayaEkle(5, new Eleman(6));
        System.out.println(ciftListe.listele()+" Listeni arasına 6 ekledik");
        
    }
    

}
