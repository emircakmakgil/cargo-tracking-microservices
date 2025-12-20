#sıfır bir linux makinem var , projeyi nasıl kurarım ?
#sıfırdan kurmamıza gerek yok mesela jdknın imajı var onu ekliyeceğiz oradan devam edicek
#bir docker imajı katman katman kurulur
#bizim için github ne ise docker imaje lar için docker hubda o
#ilk olarak makineye maven kurulumu yapalım:
FROM maven:3.9.6-eclipse-temurin-21  AS build

#makineye linuxu kurdum projeye de o makineye kopyalıyacağım work directory kısaltması olan workdır ile yapıcam
#linuxda app bir klasörü gösteriyor aslında onun altına yapacağım işlemleri
#Sonrasında projeyi de onun altına kopyalayacağım.  burada sol taraf source sağ taraf destination olarak geçer.
# Bulunduğum noktada nokta her şeyi temsil ettiği için noktayı yazıyorum

WORKDIR /app
COPY . /app/

#burada çalıştırmak için bu komutu kullanacağız. Testleri geçiyoruz çünkü testlerin çalıştırılacağı nokta docker imagenın çalıştırılacağı yer değildir.
#O yüzden burada testleri geçmenin sakıncası yoktur.
#Bunu yapmanın amacı bağımllıkları projeye yüüklensin
#maven package projeyi gidiyor derliyor sonrasonda java projesi olduğu için bir jar dosyasına çıkartıyor.
#java -jar "jar ismi" ni yazıyorsun ve proje başıyor aslında bizim gidip start tuşuna bastığımzda da arkada olan olay bu.
RUN mvn clean package -DskipTests

#Şimdi yeni bir katman daha oluşturacağım. Yukarısı bu projenin derlenmesi içindi. Container dediğim şey o projenin çalışmasını amaçlar derlenemsini değil sadece.

#Çalıştırma işlemleri için
#yukarıda verdiğim aliansı burada kullanıyorum
FROM eclipse-temurin:21-jdk
COPY --from=build /app/target/shipment-service-0.0.1-SNAPSHOT.jar /app/app.jar

#Entrypoin ve run ikiside komut çalıştırır.Aralarındaki farkı Run imaj oluşturulurken kullanılır eğer entrypoint ile verdiysen o imaj container haline gelirken kullanılıyor.
#Bu imaj container olıuştuktan sonra oluşsun istiyorum.Ayağa kalkma işlemi entrypoint
ENTRYPOINT ["java","-jar","/app/app.jar"]

#artık bu imajı oluşturabiliriz
#bulunduğum konum shipment service olduğundan
#cd shipment-service
# docker build -t turkcell-shipment-service .  yazıyorum
#BURADA DOCKER DESKTOPIN ÇALIŞTIĞINA EMİN OLALIM
#-t -> taglıyorum imageı
#turkcell-shipment-service de bu imaja bir isim veriyoeum istediğini gir
#sonrasıda . yazıyorum . bulunduğum komutu gösteriyor cd ile içine girdiğimden istediğim noktadayım pondan  nokta koydum
#bu konumda olmasaydım . yerinde /shipment-service/ yazıyor olucaktım.

#buradan sonra bunu bilgilerini docker-compose.yml'a ekliyorum bakabilirisin oradan
#ama ççalışmayacak hata veriyor sebebi ise jbdc
#hata şu Connection to localhost:5433 refused
#burada iki docker containerı arasında iletişimi localhost diyerek kullanamıyorum
#Çünkü bizim shipment service için olşturduğumuz pg-2 nin ayrı bir networku var bizim shipmnet-servicein ayrı bir networku var
#ikisinin local host dediği şey iki ayrı yer aslında
#dolayısıyla turkcell-shipment-service in içindeki localhost pg-2 deki localhosta işaret etmez
#docker containerların birbirilerityle ilişime geçebilmesi için docker compose altında yapacağız.
#BUNLARIN NETWORKU her ne kadar iki ayrı network olsa da sanal bir network oluşturuğ birbirleriyle iletişime geçebiliyorlar.
#docker içiçn yml deverdiğimiz datasource url localhost olmalı artık docker değiştiği için
#docker compose da applicaitno yaml da yazdığımız şeyleri overrride edebiliyoruz
#shipment_Service'e enviroment yazıp ekliyorum oradan bakarsın
#spring url de artık localdeki portu değil docker portunu yazacağım