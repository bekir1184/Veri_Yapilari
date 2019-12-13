
package AgacOrnek;


public class Sehir {
    int plaka;
    String ilAdi;
    Sehir sag;
    Sehir sol;
    Sehir ana;
    String yon;
    
    public Sehir(int plaka,String ilAdi){
        this.plaka=plaka;
        this.ilAdi=ilAdi;
        this.sag=null;
        this.sol=null;
        this.ana=null;
        this.yon=null;
    }
    public void yaz(){
        System.out.println(" "+this.plaka+" "+this.ilAdi+" ");
    }
}
