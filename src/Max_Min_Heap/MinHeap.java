package Max_Min_Heap;

public class MinHeap {

    private int[] Heap;
    private int boyut;
    private int maxboyut;

    private static int BAS = 1;

    public MinHeap(int maxboyut) {
        this.maxboyut = maxboyut;
        this.boyut = 0;
        Heap = new int[this.maxboyut + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    //Fonksiyon gelen pozisyondaki değerin atasını çevirir
    private int parent(int pos) {
        return pos / 2;
    }
    
    //Fonksiyon gelen pozisyondaki değerin sol çocuğunu çevirir
    private int solCocuk(int pos) {
        return (2 * pos);
    }

    //Fonksiyon gelen pozisyondaki değerin sol çocuğunu çevirir
    private int sagCocuk(int pos) {
        return (2 * pos) + 1;
    }

    //Gelen pozisyonun yaprak olup olmadığını kontrol eder
    //Dizi içerisindeki elemanların sağ yarısı yapraktır
    private boolean yaprakMi(int pos) {
        if (pos >= (boyut / 2) && pos <= boyut) {
            return true;
        }
        return false;
    }

    //Gelen iki elemanın yerini değiştirir 
    private void degis(int posbir, int posiki) {
        int tmp;
        tmp = Heap[posbir];
        Heap[posbir] = Heap[posiki];
        Heap[posiki] = tmp;
    }

    //Heap gezer ve olağandışı bir durumda gunceller
    private void minGuncelle(int pos) {

        //Gelen posizyon yaprak olana kadar devam ediyor 
        if (!yaprakMi(pos)) {
            if (Heap[pos] > Heap[solCocuk(pos)]
                    || Heap[pos] > Heap[sagCocuk(pos)]) {

               //Eğer sol cocuk sag cocutan kucukse pos ile sol cocugun yerini degisiyoruz
                if (Heap[solCocuk(pos)] < Heap[sagCocuk(pos)]) {
                    degis(pos, solCocuk(pos));
                    minGuncelle(solCocuk(pos));
                } 
                //Değilse pos ile sag cocugun yerini değiştiriyoruz 
                else {
                    degis(pos, sagCocuk(pos));
                    minGuncelle(sagCocuk(pos));
                }
            }
        }
    }

    // Heap e eleman eklememize yarayan fonsiyıon
    public void ekle(int element) {
        if (boyut >= maxboyut) {
            return;
        }
        Heap[++boyut] = element;
        int suan = boyut;

        while (Heap[suan] < Heap[parent(suan)]) {
            degis(suan, parent(suan));
            suan = parent(suan);
        }
    }
    
    
     
    
    public void yaz() {
        for (int i = 1; i <= boyut / 2; i++) {
            System.out.print(" ANA : " + Heap[i]
                    + " SOL COCUK : " + Heap[2 * i]
                    + " SAG COCUK :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }


    //Sil fonksiyonu elemanı sildikten sonra heap i gunceller ve silinen elemanı çevirir
    //(Heap'in ilk elemanını siler)
    public int sil() {
        int cikan = Heap[BAS];
        Heap[BAS] = Heap[boyut--];
        minGuncelle(BAS);
        return cikan;
    }

    public boolean MinHeapMi(int pos) {
        if (!yaprakMi(pos)) {
            if (Heap[pos] > Heap[solCocuk(pos)]
                    || Heap[pos] > Heap[sagCocuk(pos)]) {
                return false;
            } else if (Heap[pos] > Heap[solCocuk(pos)]) {
                MinHeapMi(solCocuk(pos));
            } else {
                MinHeapMi(sagCocuk(pos));
            }
        }
        return true;
    }
    public boolean maxHeapMi(int pos){
        if(!yaprakMi(pos)){
            if (Heap[pos] < Heap[solCocuk(pos)]
                    || Heap[pos] < Heap[sagCocuk(pos)]) {
                return false;
            }
            else if (Heap[pos] > Heap[solCocuk(pos)]) {
                MinHeapMi(solCocuk(pos));
            } else {
                MinHeapMi(sagCocuk(pos));
            }
        }
        return true;
    }

    public void MaxAyarla( int pos) 
    { 
        int sol = 2*pos ; 
        int sag = 2*pos + 1; 
        int buyuk = pos; 
        if (sol < boyut && Heap[sol] > Heap[pos]) 
            buyuk = sol; 
        if (sag < boyut && Heap[sag] > Heap[buyuk]) 
            buyuk = sag; 
        if (buyuk != pos) 
        { 
           
            int temp = Heap[pos]; 
            Heap[pos] = Heap[buyuk]; 
            Heap[buyuk] = temp; 
            MaxAyarla(buyuk); 
        } 
    }
    
    
     public void donusturMaxHeap() 
    { 
       
        for (int pos = (boyut-1)/2; pos > 0;pos--) 
            MaxAyarla(pos); 
    }
    //Quız Min heapte tutulan sayıları buyukten kuçuge sıralı bir şekilde 
    //bir diziye yazdıran metodu yazınız.
     
    public static int[] siraliDizi(MinHeap heap){
        int heapDizi[]=heap.Heap;
        return diziSirala(heapDizi);
    }
    public static int [] diziSirala(int dizi[]){
        int uzunluk=dizi.length;
        for (int i = 0; i < uzunluk; i++) {
            for (int j =i+1 ; j <uzunluk ; j++) {
                if(dizi[i]<dizi[j]){
                    int tut=dizi[i];
                    dizi[i]=dizi[j];
                    dizi[j]=tut;
                    
                }
            }
        }
        
        return dizi;
    }
    public static void main(String[] arg) {
        System.out.println("Min Heap");
        MinHeap minHeap = new MinHeap(15);
        
        minHeap.ekle(84);
        minHeap.ekle(3);
        minHeap.ekle(17);
        minHeap.ekle(10);
        minHeap.ekle(22);
        minHeap.ekle(12);
        minHeap.ekle(19);
        minHeap.ekle(6);
        minHeap.ekle(9);
        
        int []heap=minHeap.Heap;
        for (int i = 1; i < heap.length; i++) {
            System.out.print(heap[i]+" ");
        }
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Min Heap mi ? "+minHeap.MinHeapMi(BAS));        
        minHeap.yaz();
        System.out.println("--------");
        minHeap.donusturMaxHeap();
        minHeap.yaz();
        
        System.out.println(minHeap.MinHeapMi(BAS));
        System.out.println("--------Buyukten kucuge--------");
        
        int []dizi=MinHeap.siraliDizi(minHeap);
        for (int i = 0; i < dizi.length-1; i++) {
            System.out.print(dizi[i]+" ");
        }
        //System.out.println(minHeap.maxHeapMi(BAS));
    }
}
