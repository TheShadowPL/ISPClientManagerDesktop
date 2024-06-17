package org.example.lab6.instalacja;
import jakarta.persistence.*;
import org.example.lab6.klient.Klient;
@Entity
@Table(name = "instalacje")
public class Instalacja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adres;
    private String numerRoutera;
    private String typUslugi;

    @ManyToOne
    @JoinColumn(name = "klient_id")
    private Klient klient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNumerRoutera() {
        return numerRoutera;
    }

    public void setNumerRoutera(String numerRoutera) {
        this.numerRoutera = numerRoutera;
    }

    public String getTypUslugi() {
        return typUslugi;
    }

    public void setTypUsługi(String typUslugi) {
        this.typUslugi = typUslugi;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Instalacja() {}

    public Instalacja(String adres, String numerRoutera, String typUslugi, Klient klient) {
        this.adres = adres;
        this.numerRoutera = numerRoutera;
        this.typUslugi = typUslugi;
        this.klient = klient;
    }
}