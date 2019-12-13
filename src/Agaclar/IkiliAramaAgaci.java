
package Agaclar;
 
public class IkiliAramaAgaci {
    Eleman kok;
    public IkiliAramaAgaci(){
        kok=null;
    }
    public Eleman getKok(){
        return kok;
    }
    
    
    //Ağacın preorder olarak dolaşılması
    //-->Köke uğra 
    //-->Sol alt ağacı preorder olarak dolaş
    //-->Sağ alt ağacı preorder olarak dolaş
    
    public void preOrder(Eleman yerelKok){
        if(yerelKok!=null){
            yerelKok.elemanGoster();
            preOrder(yerelKok.sol);
            preOrder(yerelKok.sag);
        }
    }
    
    //Ağacın inorder olarak dolaşımı 
    //--> Sol alt ağacı inordera göre dolaş
    //-->Köke uğra
    //--> Sağ alt ağacı inordera göre dolaş
    
    public void inOrder(Eleman yerelKok){
        if(yerelKok!=null){
            inOrder(yerelKok.sol);
            yerelKok.elemanGoster();
            inOrder(yerelKok.sag);
        }
    }
    
    // Ağacın postordera göre dolaşımı 
    //-->Sol alt ağacı postordera göre dolaş
    //-->Sağ alt ağacı postordera göre dolaş
    //-->Köke uğra
    
    public void postOrder(Eleman yerelKok){
        if(yerelKok!=null){
            postOrder(yerelKok.sol);
            postOrder(yerelKok.sag);
            yerelKok.elemanGoster();
        }
    }
    
    public void ekle(int yeniveri){
        Eleman eleman = new Eleman(yeniveri);
        if(kok==null){
            kok=eleman;
        }
        else{
            Eleman temp=kok;
            Eleman parent;
            while(true){
                parent=temp;
                if(yeniveri<temp.veri){
                    temp=temp.sol;
                    if(temp==null){
                        parent.sol=eleman;
                        return;
                    }
                }
                else{
                    temp=temp.sag;
                    if(temp==null){
                        parent.sag=eleman;
                        return;
                    }
                }
            }
        }
    }
    //Arama işleminde küçükse ve büyükse karşılaştırmaları yaparak geziniyoruz
    public Eleman ara(int arananVeri){
        Eleman temp=kok;
        while(temp!=null){
            if(temp.veri==arananVeri){
                return temp;
            }
            else if(arananVeri < temp.veri){
                temp=temp.sol;
            }
            else{
                temp=temp.sag;
            }
        
        }
        return null;
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
    public boolean yaprakMi(Eleman e){
        return (e.sol == null && e.sag == null);
    }
    public void dugumSil(Eleman e){
        
    }
    
    
    
}
