package StackOrnek;

import java.util.Scanner;

class Eleman{
    int sayi;
    char islem;
    Eleman ileri;
    boolean sayiMi;
    public Eleman(int sayi){
        this.sayi=sayi;
        this.ileri=null;
        sayiMi=true;
    }
    
    public Eleman(char islem){
        this.islem=islem;
        sayiMi=false;
    }
}

public class Liste {
     Eleman ust;
    public Liste(){
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
    void elemanEkle(Eleman yeni){
        
        if(listeBos()){
            ust=yeni;
        }
        else{
           yeni.ileri=ust;
           ust=yeni;
        }
        
    }
    Eleman elemanCikar(){
        Eleman e=ust;
        if(!listeBos()){
            ust=ust.ileri;
        }
       
       return e;
    }
    
    void postfixEkle(Eleman yeni){
        if(yeni.sayiMi){
            elemanEkle(yeni);
        }
        else if(!yeni.sayiMi){
            char islem=yeni.islem;
            int sayi1=0;
            int sayi2=0;
            Eleman sonuc=null;
            switch(islem){
                case '+':
                    sayi1=elemanCikar().sayi;
                    sayi2=elemanCikar().sayi;
                    sonuc=new Eleman(sayi1+sayi2);
                    elemanEkle(sonuc);
                    break;
                case '-':
                    sayi1=elemanCikar().sayi;
                    sayi2=elemanCikar().sayi;
                    sonuc=new Eleman(sayi1-sayi2);
                    elemanEkle(sonuc);
                    break;
                case '*':
                    sayi1=elemanCikar().sayi;
                    sayi2=elemanCikar().sayi;
                    sonuc=new Eleman(sayi1*sayi2);
                    elemanEkle(sonuc);
                    break;
                case '/':
                    sayi1=elemanCikar().sayi;
                    sayi2=elemanCikar().sayi;
                    sonuc= new Eleman(sayi1/sayi2);
                    elemanEkle(sonuc);
                    break;
                case '?':
                    System.out.println(this.listele());
                    break;
                case '^':
                    elemanCikar();
                    break;
                case'!':
                    System.exit(0);
                    break;
            }
            
        }
    }
    
    String  listele(){
        String liste="";
        Eleman tmp=ust;
        while(tmp!=null){
            liste+="["+tmp.sayi+"]"+"\n";
            tmp=tmp.ileri;
        }
        return liste;
    }
    
    public static void main(String[] args) {
        Liste liste= new Liste();
        Scanner scan= new Scanner(System.in);
        while(true){
            String sayi=scan.next();
            if(sayi.equals("+")||sayi.equals("-")||sayi.equals("*")
                    ||sayi.equals("/")||sayi.equals("?")||sayi.equals("^")||sayi.equals("!")){
                liste.postfixEkle(new Eleman(sayi.charAt(0)));
            }
            else{
                liste.postfixEkle(new Eleman(Integer.parseInt(sayi)));
            }
            
        }
    }
    
}
