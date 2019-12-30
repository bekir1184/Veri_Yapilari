package Graflar;

public class KomsuMatris {
    int [][]kenar;
    int N;

    public KomsuMatris(int N) {
        this.N = N;
        int i,j;
        kenar = new int[N][N];
        for (i = 0;  i< N; i++) {
            for ( j = 0; j < N; j++) {
                kenar[i][j]=0;
            }
        }
    }
    
    void kenarEkle(Eleman yeni){
        kenar[yeni.baslangic][yeni.bitis]=yeni.agirlik;
    }
    void yaz(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(kenar[i][j]+" ");
            }
            System.out.println("");
        }
    }
    boolean gezildimi[]= new boolean[N];
    
    
}
class Calistir{
    public static void main(String[] args) {
        KomsuMatris komsuMatris = new KomsuMatris(5);
        komsuMatris.kenarEkle(new Eleman(3,0,7));
        komsuMatris.kenarEkle(new Eleman(0,4,4));
        komsuMatris.kenarEkle(new Eleman(4,3,1));
        komsuMatris.kenarEkle(new Eleman(4,1,2));
        komsuMatris.kenarEkle(new Eleman(1,2,3));
        komsuMatris.yaz();
    }
}
