
package Genel_Ornekler;
/*
2-Bir yığıtta tam sayılar tutulmaktadır.Bu yığıtı kendisine paremetre alan ve 
yığıttaki tek sayıları ayrı bir yığıta ve çift sayıları ayrı bir yığıta atan 
metodu yazınız.

*/

public class Ornek_2 {
   
}
class ListeStack{
    Dugum ust;
    public ListeStack(){
        ust=null;
    }
    boolean listeBos(){
        if(ust==null){
            return true;
        }
        else{
            return false;
        }
    }
    void ekle(Dugum yeni){
        if(listeBos()){
            ust=yeni;
        }
        else{
            yeni.ileri=ust;
            ust=yeni;
        }
    }
    Dugum cikar(){
        Dugum e=ust;
        if(!listeBos()){
            ust=ust.ileri;
        }
        return e;
    }
    void tekAyır(ListeStack liste){
        ListeStack tek= new ListeStack();
        ListeStack cift =new ListeStack();
        
        while(!liste.listeBos()){
            Dugum temp=liste.cikar();
            if(temp.icerik % 2 == 0 ){
                cift.ekle(temp);
            }
            else if(temp.icerik % 2 == 1){
                tek.ekle(temp);
            }
        }
    }
    
}
