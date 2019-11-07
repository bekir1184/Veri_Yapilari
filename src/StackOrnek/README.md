# Stack Ornek
>**Ornek Aciklama:**
Bu ödevde yığıt kullanılarak tam sayı operandların (işlenenlerin)ve +, -,  /, * gibi operatörlerin alındığı bir sistemde
postfix notasyonuna göre hesaplama yapan bir program yazılacaktır. Program için tam sayıları tutan bir yığıt 
yapısı(ekleme(), silme(), bosmu(), tepe(), vb. metotları ile) oluşturulmalıdır.  Program aşağıdaki gibi çalışacaktır. 
* -Kullanıcı klavyeden operatör ve operandları postfix notasonunda olduğu gibi almalıdır. Fakat burada ekstra girişlere de 
izin verilmektedir.
* -Eğer kullanıcı tam sayı bir değer girerse yığıta eklenir. 
* -Eğer kullanıcı geçerli bir operatör girerse, yığıtın tepesinden ilgili tam sayı alınır ve gerekli işlem yapılarak tekrar 
sonuç yığıta yazılır. 
* -Eğer kullanıcı ? Girerse yığıtın içeriği kullanıcıya gösterilir (Bu işlem yığıt boşaltılmadan yapılmalıdır.)
* -Eğer kullanıcı ^ sembolü girerse yığıtın tepesindeki eleman çıkarılır. 
* -Kullanıcı ! Sembolü girerse program sonlanmalıdır. 
```
Örnek bir çalıştırma aşağıdaki gibidir. 
?
[]
10
?
[10]
20 30
?
[30, 20, 10]
*
?
[600, 10]
+
?
[610]
^
610
?
[]
!

```

Yukarıda ilk olarak ? girildiği için yığıt boş olarak ([]) gösterilmiştir. Daha sonra 10 girilmiş ve ? ile 
yığıt gösterilmiştir([10]). Sonra 20 ve 30 girilmiş ve ? İle yığıt gösterilmiştir ([30,20,10]). Sonra * girildiği
 için yığıtın tepesinden 0 ve 30 alınıp çarpma işlemi yapılmış ve sonuç tekrar yığıta eklenmiştir([600,10]). 
Sonra + operatörü girildiği için  600 ve 10 toplanmış? ile yığıt gösterilmiştir([610]).  Sonra ^girildiği için yığıtın 
tepesindeki eleman çıkarılmıştır. ? ile yığıtın boş olduğu gösterilmekte ve ! ile programdan çıkılmaktadır.
