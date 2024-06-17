package org.example.lab6.platnosci;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.example.lab6.instalacja.Instalacja;
@Entity
@Table(name = "naliczone_naleznosci")
public class NaliczoneNaleznosci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate terminPlatnosci;
    private BigDecimal kwotaDoZaplaty;

    @ManyToOne
    @JoinColumn(name = "instalacja_id")
    private Instalacja instalacja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTerminPlatnosci() {
        return terminPlatnosci;
    }

    public void setTerminPlatnosci(LocalDate terminPlatnosci) {
        this.terminPlatnosci = terminPlatnosci;
    }

    public BigDecimal getKwotaDoZaplaty() {
        return kwotaDoZaplaty;
    }

    public void setKwotaDoZapłaty(BigDecimal kwotaDoZaplaty) {
        this.kwotaDoZaplaty = kwotaDoZaplaty;
    }

    public Instalacja getInstalacja() {
        return instalacja;
    }

    public void setInstalacja(Instalacja instalacja) {
        this.instalacja = instalacja;
    }

    public NaliczoneNaleznosci() {}

    public NaliczoneNaleznosci(LocalDate terminPlatnosci, BigDecimal kwotaDoZaplaty, Instalacja instalacja) {
        this.terminPlatnosci = terminPlatnosci;
        this.kwotaDoZaplaty = kwotaDoZaplaty;
        this.instalacja = instalacja;
    }
}