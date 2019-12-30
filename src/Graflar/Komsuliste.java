package Graflar;

class Liste {

    Eleman bas;
    Eleman son;

    public Liste() {
        bas = son = null;
    }

    public void ekle(Eleman yeni) {
        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            son.ileri = yeni;
            son = yeni;
        }
    }

}
class Kuyruk{
     private int boyut;
    private int[]kuyrukDizi;
    private int bas;
    private int son;
    private int elemanSayisi;
    
    public Kuyruk(int boyut){
        this.boyut=boyut;
        kuyrukDizi= new int[boyut];
        bas=0;
        son=-1;
        elemanSayisi=0;
    }
    //Kuyruğun sonuna eleman ekler
    public void ekle(int yeni){
        if(son==boyut-1){
            son=-1;
        }
        kuyrukDizi[++son]=yeni;
        elemanSayisi++;
    }
    public int cikar(){
        int temp=kuyrukDizi[bas++];
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

public class Komsuliste {

    Liste[] kenar;
    int N;

    public Komsuliste(int N) {
        int i;
        this.N = N;
        kenar = new Liste[10];
        for (i = 0; i < 10; i++) {
            kenar[i] = new Liste();
        }
    }

    public void kenarekle(int baslangic ,int bitis ){
        Eleman yeni;
        yeni = new Eleman(baslangic,bitis);
        kenar[baslangic].ekle(yeni);
    }
    boolean gezildimi[] = new boolean[10];

    //Deep First Search
    
    int bagliParcaBulDerinArma() {
        int v ;
        int parcaSayisi = 0;
        //Oncelikle düğümleri henüz dolaşmadığımız için gezildimi boolean dizisinin tüm elemanlarını false yapıyoruz
        for (v = 0; v < N; v++) {
            gezildimi[v] = false;
        }
        for (v = 0; v < N; v++) {
            if (!gezildimi[v]) {
                gezildimi[v] = true;
                derinArama(v);
                parcaSayisi++;
            }
        }
        return parcaSayisi;
    }

   private  void derinArama(int v) {
        Eleman dugum;
        int y;
        dugum = kenar[v].bas;
        while (dugum != null) {
            y = dugum.bitis;
            if (!gezildimi[y]) {
                gezildimi[y] = true;
                derinArama(y);
            }
            dugum = dugum.ileri;
        }
    }
   //Breadth First Search 
    int  bagliParcaBulGenisArama(){
        int v , parcaSayisi=0;
        for (v = 0; v < N; v++) {
            gezildimi[v]= false;
        }
        for ( v = 0; v < N; v++) {
            if(!gezildimi[v]){
                gezildimi[v]=true;
                genisArama(v);
                parcaSayisi++;
            }
            
        }
        return parcaSayisi;
    }
    private void genisArama(int x){
        Eleman dugum;
        int y;
        Kuyruk k= new Kuyruk(100);
        k.ekle(x); 
        while(!k.bosMu()){
            x=k.cikar();
            dugum =kenar[x].bas;
            while(dugum!=null){
                y=dugum.bitis;
                if(!gezildimi[y]){
                    gezildimi[y]=true;
                    k.ekle(y);
                }
                dugum=dugum.ileri;
            }
            
        }
        
    }
}
class Calistir1{
    public static void main(String[] args) {
        Komsuliste komsuliste= new Komsuliste(7);
        komsuliste.kenarekle(5,2);
        komsuliste.kenarekle(2,6);
        komsuliste.kenarekle(6,3);
        komsuliste.kenarekle(3,4);
        komsuliste.kenarekle(3,7);
        komsuliste.kenarekle(7,4);
        komsuliste.kenarekle(7,9);
        
        System.out.println(komsuliste.bagliParcaBulDerinArma());
        System.out.println(komsuliste.bagliParcaBulGenisArama());
        
    }
}
