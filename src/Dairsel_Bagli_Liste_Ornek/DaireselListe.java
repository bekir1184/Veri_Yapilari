package Dairsel_Bagli_Liste_Ornek;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.JFrame;

class Eleman {

    int aci;
    double sinusKarsiligi;
    Eleman ileri;
    Eleman geri;

    public Eleman(int aci, double sinuskarsiligi) {
        this.aci = aci;
        this.sinusKarsiligi = sinuskarsiligi;
        ileri = null;
        geri = null;
    }

}

public class DaireselListe {

    Eleman bas;
    Eleman son;
    int elemanSayisi = 0;

    public DaireselListe() {
        bas = null;
        son = null;

    }

    public void sinusAcisiBaşlat(double baslamaAcisi) {

        if (baslamaAcisi >= 0) {
            while (baslamaAcisi <= 360) {
                double deger = Math.toRadians(baslamaAcisi);
                listeyeEkle(new Eleman((int) baslamaAcisi, Math.sin(deger)));
                baslamaAcisi++;
            }
        } else if (baslamaAcisi < 0) {

            while (baslamaAcisi >= -360) {
                double deger = Math.toRadians(baslamaAcisi);
                listeyeEkle(new Eleman((int) baslamaAcisi, Math.sin(deger)));
                baslamaAcisi--;

            }

        }
    }

    void listeyeEkle(Eleman yeni) {
        if (bas == null) {
            yeni.ileri = yeni.geri = yeni;
            bas = son = yeni;
        } else {
            yeni.ileri = bas;
            yeni.geri = bas.geri;
            bas.geri.ileri = yeni;
            bas.geri = yeni;
        }
        elemanSayisi++;
    }

    void listedenSil() {
        if (bas.ileri == bas) {
            bas = null;
        } else {
            bas.geri.ileri = bas.ileri;
            bas.ileri.geri = bas.geri;
            bas = bas.ileri;
        }
    }

    String listele() {
        Eleman twp = bas;
        String liste = "";
        int i = 0;
        while (i < elemanSayisi) {
            liste = liste + twp.aci + " / " + twp.sinusKarsiligi + "  -->  " + "\n";

            twp = twp.ileri;
            i++;
        }
        return liste;
    }

    void ciz(int periyot) {
        Ciz ciz = new Ciz(this, periyot, this.bas.aci);
        ciz.init();
        JFrame frame = new JFrame();
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ciz);
        frame.setVisible(true);

        ciz.start();
    }

    

    public static void main(String[] args) {
        DaireselListe daireselListe = new DaireselListe();
        daireselListe.sinusAcisiBaşlat(90);
        //daireselListe.ciz(1);

        

    }
}
