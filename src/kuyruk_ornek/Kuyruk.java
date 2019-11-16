
package kuyruk_ornek;

class Konum{
    int pozX;
    int pozY;
    public Konum(int pozX,int pozY){
        this.pozX=pozX;
        this.pozY=pozY;
    }
}

public class Kuyruk {
    private int boyut;
    private Konum[]kuyrukDizi;
    private int bas;
    private int son;
    private int elemanSayisi;
    
    public Kuyruk(int boyut){
        this.boyut=boyut;
        kuyrukDizi= new Konum[boyut];
        bas=0;
        son=-1;
        elemanSayisi=0;
    }
    //Kuyruğun sonuna eleman ekler
    public void ekle(Konum yeni){
        if(son==boyut-1){
            son=-1;
        }
        if(yeni.pozX>=0 && yeni.pozY>=0 && yeni.pozX<8 && yeni.pozY<8){
            kuyrukDizi[++son]=yeni;
            elemanSayisi++;
           // System.out.println("ekelenen x :"+yeni.pozX+" eklenen y: "+yeni.pozY);
        }
        
    }

    public Konum cikar(){
        Konum temp=kuyrukDizi[bas++];
        if(bas==boyut){
            bas=0;
        }
        elemanSayisi--;
        return temp;
    }
    
    
    public boolean bosMu(){
        return (elemanSayisi==0);
    }

}
