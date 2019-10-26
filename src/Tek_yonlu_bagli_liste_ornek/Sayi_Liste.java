package Tek_yonlu_bagli_liste_ornek;

class Eleman {
    int icerik;
    Eleman ileri;
    public Eleman (int icerik){
        this.icerik=icerik;
        ileri =null;
    }
    
}


public class Sayi_Liste {
    Eleman bas;
    Eleman kuyruk;
    
    public Sayi_Liste(){
        bas=null;
        kuyruk=null;
    }
    
    public static Sayi_Liste sayiEkle(int sayi){
        
        Sayi_Liste liste= new Sayi_Liste();
        
        int kalan=0 ;
        int bolum=0;
        while(sayi>1){
            bolum=sayi/2;
            kalan=sayi-(bolum*2);
            liste.sonaEkle(new Eleman(kalan));
            sayi=bolum;
        }
        if(sayi<=1){
           liste.sonaEkle(new Eleman(sayi));
        }
        
        
        return liste;
    }
    public  Sayi_Liste topla(Sayi_Liste liste1){
        Sayi_Liste toplamListe=new Sayi_Liste();
        
        Eleman tmp=liste1.bas;
        Eleman tmp2=bas;
        
        int sayac=0;
        int sayac2=0;
        int fark=0;
        while(tmp!=null){
            sayac++;
            tmp=tmp.ileri;
        }
        while(tmp2!=null){
            sayac2++;
            tmp2=tmp2.ileri;
        }
        if(sayac>sayac2){
           fark=sayac-sayac2;
          
            for (int i = 0; i < fark; i++) {
                this.sonaEkle(new Eleman(0));
            }
        }
        else if(sayac2>sayac){
           fark=sayac2-sayac;
          
            for (int i = 0; i < fark; i++) {
                liste1.sonaEkle(new Eleman(0));
            }
        }
        
        Eleman toplaGez=liste1.bas;
        Eleman toplaGez2=bas;
            int elde=0;
        while(toplaGez!=null){
            int basamakToplam=0;
            int kalan=0;
            int bolum=0;
            basamakToplam=toplaGez.icerik+toplaGez2.icerik+elde;
            bolum=basamakToplam/2;
            kalan=basamakToplam-(bolum*2);
            toplamListe.sonaEkle(new Eleman(kalan));
            elde=bolum;
            toplaGez=toplaGez.ileri;
            toplaGez2=toplaGez2.ileri;
            
        }
        
        if(elde>=1){
            toplamListe.sonaEkle(new Eleman(elde));
        }
            
        
        
        
        
                
                
        return toplamListe;
    }
    
    public  void basaEkle(Eleman yeni){
        if(kuyruk==null){
            bas=yeni;
            kuyruk=yeni;
        }
        else{
            yeni.ileri=bas;
            bas=yeni;
        }
    
    }
    public void sonaEkle(Eleman yeni){
        if(bas==null){
            bas=yeni;
            kuyruk=yeni;
        }
        else{
            kuyruk.ileri=yeni;
            kuyruk=yeni;
        }
    }
    public void arayaEkle(Eleman yeni,int ara){
        if(bas==null && kuyruk==null){
            basaEkle(yeni);
        }
        else if(bas==kuyruk){
            basaEkle(yeni);
        }
        else{
            Eleman tmp =bas;
            while(tmp!=null && tmp.icerik!=ara){
                 tmp.ileri=yeni;
                
            }
            if(tmp!=null ){
                 yeni.ileri=tmp.ileri;
                  tmp.ileri=yeni; 
                }
        }
       
    }
      public void listeBasiSil(){
          bas=bas.ileri;
          if(bas==null){
              kuyruk=null;
          }
      }
      public void listeSonuSil(){
          Eleman tmp=bas;
          Eleman once=null;
          while(tmp!=kuyruk){
              once=tmp;
              tmp=tmp.ileri;
          }
          if(once==null){
              bas=null;
              kuyruk=null;
          }
          else{
              once.ileri=null;
              kuyruk=once;
          }
      }
      public void aradanSil(int aranan){
          Eleman tmp=bas;
          Eleman once=null;
          
          while(tmp!=null){
            if(tmp.icerik == aranan){
                break;
            }
            else {
                once = tmp ;
                tmp = tmp.ileri;
            }
        }
        if(once == null){
            bas = bas.ileri;
        }
        else if(once !=null){
            once.ileri = tmp.ileri;
        }
      }
      public String listele(){
        Eleman twp = bas;
        String liste = "";
        while(twp!=null){
            liste = liste + twp.icerik + "-->";
            twp = twp.ileri ;            
        }
        return liste;
    }
      
      
    public static void main(String[] args) {
        
        Sayi_Liste liste = Sayi_Liste.sayiEkle(3);
        Sayi_Liste liste2= Sayi_Liste.sayiEkle(6);
        
        System.out.println(liste.listele()+" == Liste 1  >>> sayi 3" );
        System.out.println(liste2.listele()+" == Liste 2 >>> sayi 6");
        
        System.out.println(liste.topla(liste2).listele()+" == Liste 1 + Liste 2 ");
        
        liste.basaEkle(new Eleman(3));
        System.out.println(liste.listele()+" ==> basa 3 ekledik");
        
        liste.sonaEkle(new Eleman(5));
        System.out.println(liste.listele()+" ==> sona 5 ekledik");
        
        liste.arayaEkle(new Eleman(7), 3);
        System.out.println(liste.listele()+" ==> 3'ten sonraya 7 ekledik ");
        
        liste.listeBasiSil();
        System.out.println(liste.listele()+" ==> liste başını sildik");
        
        liste.listeSonuSil();
        System.out.println(liste.listele()+" ==> liste sonunu sildik");
        
        liste.aradanSil(1);
        System.out.println(liste.listele()+" ==> 1 'i aradan sildik");
        
        
        
        
        
        
        
        
        
    }
  
    
}
