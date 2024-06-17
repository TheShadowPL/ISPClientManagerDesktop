package org.example.lab6.klient;
import jakarta.persistence.*;


@Entity
@Table(name = "klienci")
public class Klient {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;
    private String nazwisko;
    private String numerKlienta;

    public Klient() {}

    public Klient(String imie, String nazwisko, String numerKlienta) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerKlienta = numerKlienta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNumerKlienta() {
        return numerKlienta;
    }

    public void setNumerKlienta(String numerKlienta) {
        this.numerKlienta = numerKlienta;
    }

    // toString() dla wygody podglądu danych
    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", imię='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numerKlienta='" + numerKlienta + '\'' +
                '}';
    }
}
