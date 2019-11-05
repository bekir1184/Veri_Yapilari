
package StackDizi;

//Dizi içerisine ekleyeceğimiz veri cinsi
class Eleman{
    int icerik;
    public Eleman(int icerik){
        this.icerik=icerik;
    }

    @Override
    public String toString() {
        return Integer.toString(icerik);
    }
    
}
    
public class Dizi {
    Eleman elemanlar[];
    int ust;
    int elemanSayisi;
    public Dizi(int elemanSayisi){
        elemanlar=new Eleman[elemanSayisi];
        this.elemanSayisi=elemanSayisi;
        ust=-1;
    }
    //Dizinin ust elemanını çeviren metot
    Eleman ust(){
        return elemanlar[ust];
    }
    //Dizimiz dolu olduğuda true değer , aksi halde false döndürür
    boolean stackDolu(){
        if(ust==elemanSayisi-1){
            return true;
        }
        else{
            return false;
        }
    }
    //Dizinin boş olduğu durumda true değer aksi halde false döndürür
    boolean stackBos(){
        if(ust==-1){
            return true; 
        }
        else{
            return false;
        }
        
    }
    
    //En ust kısma eleman eklemize yarayan metot
    //push()
    void elemanEkle(Eleman yeni){
        if(!stackDolu()){
            ust++;
            elemanlar[ust]=yeni;
        }
    }
    //En ust kısımdan eleman silmemize yarayan metot
    //pop()
    Eleman elemanSil(){
        if(!stackBos()){
            ust--;
            return elemanlar[ust+1];
        }
        else{
            return null;
        }
    }
    String yaz(){
        String stack="";
        if(stackBos()){
            stack="Dizi boş";
        }
        else{
            for (int i = ust; i >-1; i--) {
                stack+="["+elemanlar[i].toString()+"]"+"\n";
                stack+=" ^ "+"\n";
            }
        }
        return stack;
    }

   
    
    public static void main(String[] args) {
        Dizi dizi= new Dizi(8);
        System.out.println("Dizinin eleman sayisi -->" + dizi.elemanSayisi );
        dizi.elemanEkle(new Eleman(5));
        dizi.elemanEkle(new Eleman(9));
        dizi.elemanEkle(new Eleman(3));
        dizi.elemanEkle(new Eleman(6));
        dizi.elemanEkle(new Eleman(1));
        dizi.elemanEkle(new Eleman(7));
        dizi.elemanEkle(new Eleman(3));
        dizi.elemanEkle(new Eleman(2));
        System.out.println(dizi.yaz());
        
        System.out.println("Eleman çıkartırsak");
        dizi.elemanSil();
        System.out.println(dizi.yaz());
    }
    
}
