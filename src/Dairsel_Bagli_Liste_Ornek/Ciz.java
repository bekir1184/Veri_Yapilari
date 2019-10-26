package Dairsel_Bagli_Liste_Ornek;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JApplet;

public class Ciz extends JApplet {

    DaireselListe liste;
    int periyot;
    int baslagicAci;

    public Ciz(DaireselListe liste, int periyot, int baslangicAci) throws HeadlessException {
        this.liste = liste;
        this.periyot = periyot;
        this.baslagicAci = baslangicAci;
    }

    @Override
    public void init() {
        setSize(1200, 600);
    }

    @Override
    public void paint(Graphics g) {
        
        int baslangic = liste.bas.aci;
        if(baslangic>=0){
            liste.sinusAcisiBaşlat(0);
        }
        else if(baslangic<0){
            liste.sinusAcisiBaşlat(-1);
        }
        int periyotSayisi = periyot;
        liste.sinusAcisiBaşlat(baslangic);
        Eleman temp = liste.bas;
        double ydegeri1;
        double ydegeri2;
        int grafikBaslangicY = 300;
        int dalgaBoyu = 100;
        int periyotUzunlugu = 360;
        int grafikBaslangicX = 600;
        g.setColor(Color.red);
        double x = baslangic;

        if (baslangic >= 0) {
            while (x <= periyotUzunlugu * periyotSayisi) {
                ydegeri1 = temp.sinusKarsiligi;
                ydegeri2 = temp.ileri.sinusKarsiligi;
                
                g.drawLine((int) x + grafikBaslangicX, grafikBaslangicY - (int) (dalgaBoyu * ydegeri1), (int) x + grafikBaslangicX, grafikBaslangicY - (int) (dalgaBoyu * ydegeri2));
                temp = temp.ileri;
                x += 1;
            }

        } else if (baslangic < 0) {
            while (x > (-1) * periyotUzunlugu * periyotSayisi) {
                ydegeri1 = temp.sinusKarsiligi;
                ydegeri2 = temp.ileri.sinusKarsiligi;
                g.drawLine((int) x + grafikBaslangicX, grafikBaslangicY - (int) (dalgaBoyu * ydegeri1), (int) x + grafikBaslangicX, grafikBaslangicY - (int) (dalgaBoyu * ydegeri2));
                temp = temp.ileri;
                x -= 1;
            }
        }

        g.setColor(Color.BLACK);
        g.drawLine(0, 300, 1200, 300);
        g.drawLine(600, 0, 600, 600);

    }
}
