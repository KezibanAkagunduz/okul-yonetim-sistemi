package com.okulyonetim.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "STUDENTS")
public class Ogrenci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;
    private String numara;
    private String bolum;
    private String email;

    // Boş constructor (zorunlu)
    public Ogrenci() {
    }

    // Parametreli constructor
    public Ogrenci(String ad, String soyad, String numara, String bolum, String email) {
        this.ad = ad;
        this.soyad = soyad;
        this.numara = numara;
        this.bolum = bolum;
        this.email = email;
    }

    // Getter ve Setter'lar
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", numara='" + numara + '\'' +
                ", bolum='" + bolum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
