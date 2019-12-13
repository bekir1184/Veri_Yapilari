package AgacOrnek;

public class Agac {
    Sehir kok;
    
    public Agac(){
        this.kok=null;
    }
    //ikili ağaca düğüm ekleme
    public void ekle(Sehir sehir){
        if(this.kok==null){
            this.kok=sehir;
            this.kok.ana=this.kok;
            return;
        }
        else{
            Sehir temp =this.kok;
            Sehir once;
            
            //Ekleyeceğimiz şehri eklenecek yere götürüyoruz
            do{
                once = temp;
                if(sehir.plaka > temp.plaka){
                    temp =temp.sag;
                }
                else {
                    temp=temp.sol;
                }
            
            }while(temp != null);
            
            //Eklenecek yer bulununce döngüden çıkıyor ve ekleme işlemini yapıyoruz.
            
            
            if(sehir.plaka > once.plaka){
                once.sag =sehir;
                sehir.yon="sag";
                sehir.ana = once;
            }
            else {
                once.sol=sehir;
                sehir.yon="sol";
                sehir.ana=once;
            }
            
        }
    }
    //Alt ağaçlara düğüm ekleme
    public void ekle(Sehir ana ,Sehir sehir){
        Sehir temp = ana;
        Sehir once;
        
        while(temp != null){
            once=temp;
            if(sehir.plaka > temp.plaka){
                temp = temp.sag;
                if(temp == null){
                    once.sag =sehir;
                    break;
                }
            }
            else{
                temp = temp.sol;
                if(temp == null){
                    once.sol = sehir;
                    break;
                }
            }
        }
    }
    
    //Verilen plaka kodu ile arama yapıyoruz ve sehir dondürüyoruz
    public Sehir ara(Sehir eleman,int plakaKodu){
        if(eleman != null){
            if(eleman.plaka == plakaKodu){
                return eleman;
            }
            else if(plakaKodu > eleman.plaka){
                return ara(eleman.sag,plakaKodu);
            }
            else{
                return ara(eleman.sol,plakaKodu);
            }
        }
        else{
            return null;
        }
        
    }
    
    private boolean yaprakMi(Sehir sehir){
        return (sehir.sol == null && sehir.sag == null);
    }
    
    private void  yaprakSil(Sehir sehir){
        if(sehir.yon.equalsIgnoreCase("sag")){
            sehir.ana.sag=null;
        }
        else{
            sehir.ana.sol=null;
        }
    }
    private Sehir getVaris(Sehir ana){
        Sehir once;
        while(true){
            once = ana;
            
            ana=ana.sol;
            if(ana == null){
                break;
            }
        }
        return once;
    }
    //ikili arama ağacığında silinmek istenen düğüm 3 durumda bulunabilir
    
    /*
     1-Silinmek istenen düğüm yaprak düğümü olabilir bu durumda ek bir işlem
    olmadan direkt silinir.
     2-Silinmek istenen düğümün tek çoçuğu varsa düğüm silinir,yerine çoçuğu
    geçer.
     3-Silinmek istenen düğümün iki çoçuğu varsa bu durumda ingilizce successor
    olarak tabi edilen varis düğüm bulunur ve yerine geçirilir.(Sağ alt ağacın
    en küçük elemanını bulup silmek isteğimiz düğümün yerine koyarız.)
    */
    public void sil(int plakaKodu){
        Sehir getir=ara(this.kok,plakaKodu);
        
        if(getir != null){
            if(yaprakMi(getir)){
                yaprakSil(getir);
            }
            else if(getir.sag != null && getir.sol !=null){
                Sehir temp =getir;
                Sehir varis =getVaris(getir.sag);
                
                getir=varis;
                
                if(yaprakMi(varis)){
                    yaprakSil(varis);
                }
                else{
                    yaprakSil(varis);
                    ekle(varis.ana,varis.sag);
                }
            }
        }
        else{
            if(getir.sol != null){
                if(getir.yon.equalsIgnoreCase("sag")){
                    getir.ana.sag=getir.sol;
                } 
                else{
                    getir.ana.sol=getir.sol;
                }
            }
            else{
                if(getir.yon.equalsIgnoreCase("sol")){
                    getir.ana.sag=getir.sol;
                }
                else{
                    getir.ana.sol=getir.sol;
                }
                
            }
        }
    }
    //Ağacın preorder olarak dolaşılması
    //-->Köke uğra 
    //-->Sol alt ağacı preorder olarak dolaş
    //-->Sağ alt ağacı preorder olarak dolaş
    
    public void preOrder(Sehir yerelKok){
        if(yerelKok!=null){
            yerelKok.yaz();
            preOrder(yerelKok.sol);
            preOrder(yerelKok.sag);
        }
    }
    
    //Ağacın inorder olarak dolaşımı 
    //--> Sol alt ağacı inordera göre dolaş
    //-->Köke uğra
    //--> Sağ alt ağacı inordera göre dolaş
    
    public void inOrder(Sehir yerelKok){
        if(yerelKok!=null){
            inOrder(yerelKok.sol);
            yerelKok.yaz();
            inOrder(yerelKok.sag);
        }
    }
    
    // Ağacın postordera göre dolaşımı 
    //-->Sol alt ağacı postordera göre dolaş
    //-->Sağ alt ağacı postordera göre dolaş
    //-->Köke uğra
    
    public void postOrder(Sehir yerelKok){
        if(yerelKok!=null){
            postOrder(yerelKok.sol);
            postOrder(yerelKok.sag);
            yerelKok.yaz();
        }
    }
    public boolean dengeliMi(Sehir temp){
        boolean dengeli=true;
        if(temp!=null){
            if(!yaprakMi(temp)){
                if(temp.sol==null || temp.sag==null){
                    return false;
                }
            }
            dengeliMi(temp.sol);
            dengeliMi(temp.sag);
        }
        
        return dengeli;
    }
    
    public Sehir ikinciBuyuk(Sehir kok,Sehir max,Sehir max2){
        
        if(kok!=null){
            ikinciBuyuk(kok.sag,max,max2);
            if(kok.plaka>max.plaka){
                max=kok;
            }
            else if(kok.plaka>max2.plaka && max.plaka > kok.plaka){
                max2=kok;
            }
            ikinciBuyuk(kok.sol,max,max2);
       }
        return max2; 
    }
    
     public  Sehir baslangic(Sehir kok){
        Sehir max;
        Sehir max2;
        max=kok;
        if(kok.sag != null){
            max2=kok.sag;
        }
        else if(kok.sol != null){
            max2=kok.sol;
        }
        else{
            max2=kok.sol;
        }
        
            return ikinciBuyuk(kok, max, max2);
            
        }
    
    public static void main(String[] args) {
        Agac sehirler= new Agac();
        Sehir sehir0= new Sehir(5,"Trabzon");
        Sehir sehir = new Sehir(10,"Tokat");
        Sehir sehir1 = new Sehir(15,"Adana");
        Sehir sehir2 = new Sehir(12,"Antalya");
        Sehir sehir3 = new Sehir(14,"Amasya");
        
        
        sehirler.ekle(sehir0);
        sehirler.ekle(sehir);
        sehirler.ekle(sehir1);
        sehirler.ekle(sehir2);
        sehirler.ekle(sehir3);
        
        
        System.out.println(sehirler.baslangic(sehirler.kok).plaka);
        
        
        
    }
    
    
    
    
    
}
