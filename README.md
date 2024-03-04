# RestServiceDesignWithJavaSpringBoot
Java spring boot kullanarak fatura kayıt sistemi için Rest service tasarımı
Bu proje, Java ve Spring Boot kullanılarak geliştirilmiş bir fatura takip sistemi REST servisini içerir. Bu servis, fatura oluşturma, güncelleme, silme ve listeleme gibi temel CRUD (Create, Read, Update, Delete) işlemlerini destekler.

### Gereksinimler
- Java Development Kit (JDK) 17 veya üzeri
- Maven 3.x veya üzeri
- Bir IDE (Integrated Development Environment) (örneğin, IntelliJ IDEA, Eclipse)

- Gereksinimler sağlandıktan sonra tarayıcınızda `http://localhost:8080` adresine giderek servisin çalışıp çalışmadığını kontrol edebilirsiniz.

- ## Kullanım

Bu REST servisi aşağıdaki HTTP istekleriyle kullanılabilir:

- **GET /AllInvoices**: Tüm faturaları listeler.
- **POST /InvoiceCreate**: Yeni bir fatura oluşturur.
- **POST /EmployeeCreate**: Yeni bir Çalışan oluşturur.
- **PUT /edit/{id}**: Mevcut bir çalışanı günceller.
- **DELETE /remove/{id}**: Belirli bir faturayı siler.
- **DELETE /remove/{id}**: Belirli bir çalışanı siler.
- Her istek json formatında veri alır ve döndürür

- ## Ekran Görüntüleri
- Görselde  postman collection ve sunucuya atılan listeleme isteği ve çıktısı gösterilmiştir

![F0BD2604-D4D2-41EF-8DC3-09E09C23993D_1_201_a](https://github.com/Ahmethan1/RestServiceDesignWithJavaSpringBoot/assets/62026273/a7c3feb7-946d-4ff7-90be-059760aa7b13)

-Projeye Entegre edilen swagger ekran çıktısı paylaşılmıştır

![46AD9273-3BC3-4E4B-B3E3-AB6B033D987F_1_201_a](https://github.com/Ahmethan1/RestServiceDesignWithJavaSpringBoot/assets/62026273/50c807ae-fe46-4ab2-b814-c0bdab8e2154)


