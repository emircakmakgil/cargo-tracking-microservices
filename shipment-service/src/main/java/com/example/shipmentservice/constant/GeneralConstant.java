package com.example.shipmentservice.constant;

public class GeneralConstant {
    public static final String ADDRESS_NOT_FOUND= "İlgili address bulunamadı.";
    public static final String CONTACT_NOT_FOUND= "İlgili contact bulunamadı.";
    public static final String DELIVERY_RECEIPT_NOT_FOUND = "İlgili alıcı contact bulunamadı.";
    public static final String LOCATION_NOT_FOUND = "İlgili lokasyon bulunamadı.";
    public static final String PACKAGE_NOT_FOUND = "İlgili paket bulunamadı.";
    public static final String PACKAGE_WEIGHT_REQUIRED = "Paket ağırlığı zorunludur.";
    public static final String PACKAGE_DIMENSIONS_REQUIRED = "Paket ölçüleri (uzunluk, genişlik, yükseklik) zorunludur.";
    public static final String PACKAGE_TYPE_REQUIRED = "Paket tipi zorunludur.";
    public static final String PACKAGE_DIMENSIONS_POSITIVE = "Paket ölçüleri ve ağırlığı pozitif olmalıdır.";
    public static final String PACKAGE_WEIGHT_TOO_HIGH = "Paket ağırlığı 1000 kg'dan az olmalıdır.";
    public static final String SERVICE_TYPE_NOT_FOUND = "İlgili servis tipi  bulunamadı.";
    public static final String SHIPMENT_TYPE_NOT_FOUND = "İlgili gönderi bulunamadı.";
    public static final String RECEIVER_NOT_FOUND="Alıcı bulunamadı";
    public static final String SENDER_NOT_FOUND="Gönderici bulunamadı";
    public static final String SENDER_AND_RECEIVER_CANNOT_BE_SAME = "Alıcı ve gönderici aynı olamaz";
    public static final String SHIPMENT_ALREADY_DELIVERED = "Gönderici teslim edilmiştir.";
    public static final String CANCELLED_SHIPMENT_CANNOT_CHANGE = "İptal edilen gönderi değiştirilemez.";
    public static final String INVALID_STATUS_TRANSITION = "Geçersiz gönderi geçişi. Gönderi doğrudan OLUŞTURULDU durumundan TESLİM EDİLDİ durumuna geçemez";
    public static final String SHIPMENT_CANNOT_BE_UPDATED = "Gönderi teslimat durumu güncellenemez";
    public static final String CITY_REQUIRED = "Şehir bilgisi zorunludur.";
    public static final String DISTRICT_REQUIRED = "İlçe bilgisi zorunludur.";
    public static final String ADDRESS_LINE_REQUIRED = "Adres satırı zorunludur.";
    public static final String ADDRESS_ALREADY_EXISTS = "Verilen adres kayıtlıdır.";
    public static final String DELETED_ADDRESS_CANNOT_BE_UPDATED = "Silinmiş olan adres güncellenemez.";
    public static final String CONTRACT_START_DATE_REQUIRED = "Sözleşme başlangıç tarihi zorunludur.";
    public static final String CONTRACT_END_DATE_REQUIRED = "Sözleşme bitiş tarihi zorunludur.";
    public static final String INVALID_CONTRACT_DATE_RANGE = "Sözleşme bitiş tarihi, başlangıç tarihinden önce olamaz.";
    public static final String ACTIVE_CONTRACT_ALREADY_EXISTS = "Bu kişi için zaten aktif bir sözleşme bulunmaktadır.";
    public static final String DELIVERY_RECEIPT_STATUS_REQUIRED = "Teslimat durumu zorunludur.";
    public static final String DELIVERY_RECEIPT_DELIVERED_AT_REQUIRED = "Teslim tarihi zorunludur.";
    public static final String DELIVERY_RECEIPT_RECEIVER_NAME_REQUIRED = "Teslim alan kişi adı zorunludur.";
    public static final String DELIVERY_RECEIPT_FINALIZED_CANNOT_UPDATE = "Tamamlanan teslimat fişi güncellenemez.";
    public static final String LOCATION_CENTER_NAME_REQUIRED = "Merkez adı zorunludur.";
    public static final String LOCATION_CENTER_NAME_TOO_LONG = "Merkez adı 200 karakterden uzun olamaz.";
    public static final String LOCATION_TYPE_REQUIRED = "Lokasyon tipi zorunludur.";
    public static final String SERVICE_TYPE_NAME_REQUIRED = "Servis tipi adı zorunludur.";
    public static final String SERVICE_TYPE_BASE_PRICE_REQUIRED = "Servis tipi için taban fiyat zorunludur.";
    public static final String SERVICE_TYPE_BASE_PRICE_POSITIVE = "Taban fiyat pozitif olmalıdır.";
    public static final String SERVICE_TYPE_DELIVERY_SLA_REQUIRED = "Teslimat SLA tipi zorunludur.";
    public static final String SERVICE_TYPE_WEIGHT_RANGE_INVALID = "Maksimum ağırlık, minimum ağırlıktan küçük olamaz.";
    public static final String SERVICE_TYPE_DIMENSIONS_POSITIVE = "Ağırlık ve boyut sınırları pozitif olmalıdır.";
    public static final String SERVICE_TYPE_ADDITIONAL_FEE_NEGATIVE = "Ek ücret negatif olamaz.";



}
