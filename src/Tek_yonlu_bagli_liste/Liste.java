package Tek_yonlu_bagli_liste;

class Eleman{
    int icerik;
    Eleman ileri;
    
    public Eleman(int icerik){
        this.icerik=icerik;
        this.ileri=null;
    }
}

public class Liste {
       Eleman bas;
       Eleman kuyruk;
       
       /*Listenin başının tutulması zorunludur .Kuyruk tutmak zorunlu değil ancak
        avantajlı değildir.
       */
       
       public Liste(){
           bas=null;
           kuyruk=null;
       }
       
      public void basaEkle(Eleman yeni){
          
          //ilk başta elaman olup olmadığını kontrol ediyoruz
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
          //ilk başta elaman olup olmadığını kontrol ediyoruz
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
          //eleman yok ise
          if(bas==null && kuyruk==null){
              basaEkle(yeni);
          }
          //tek eleman varsa
          else if(bas==kuyruk){
              basaEkle(yeni);
          }
          else{
              Eleman tmp =bas;
              while(tmp!=null && tmp.icerik!=ara){
                  tmp=tmp.ileri;
                   
                  
              }
              if(tmp!=null){
                  yeni.ileri=tmp.ileri;
                  tmp.ileri=yeni;
              }
          }
          
      }
      public Eleman listeAra(int aranan){
          Eleman tmp=bas;
          while(tmp!=null){
              if(tmp.icerik==aranan ){
                  return tmp;
              }
              tmp =tmp.ileri;
              
          }
          return null;
          
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
          Eleman twp=bas;
          Eleman once=null;
          
          while(twp!=null){
            if(twp.icerik == aranan){
                break;
            }
            else {
                once = twp ;
                twp = twp.ileri;
            }
        }
        if(once == null){
            bas = bas.ileri;
        }
        else if(once !=null){
            once.ileri = twp.ileri;
        }
      }
}
