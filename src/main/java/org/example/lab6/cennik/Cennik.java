package org.example.lab6.cennik;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cennik")
public class Cennik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typUslugi;
    private BigDecimal cena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypUslugi() {
        return typUslugi;
    }

    public void setTypUsługi(String typUslugi) {
        this.typUslugi = typUslugi;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public Cennik() {}

    public Cennik(String typUslugi, BigDecimal cena) {
        this.typUslugi = typUslugi;
        this.cena = cena;
    }
}
