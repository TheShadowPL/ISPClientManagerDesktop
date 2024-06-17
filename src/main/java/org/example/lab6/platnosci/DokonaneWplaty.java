package org.example.lab6.platnosci;
import jakarta.persistence.*;
import org.example.lab6.instalacja.Instalacja;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "dokonane_wplaty")
public class DokonaneWplaty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate terminWplaty;
    private BigDecimal kwotaWplaty;

    @ManyToOne
    @JoinColumn(name = "instalacja_id")
    private Instalacja instalacja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTerminWplaty() {
        return terminWplaty;
    }

    public void setTerminWpłaty(LocalDate terminWplaty) {
        this.terminWplaty = terminWplaty;
    }

    public BigDecimal getKwotaWplaty() {
        return kwotaWplaty;
    }

    public void setKwotaWplaty(BigDecimal kwotaWplaty) {
        this.kwotaWplaty = kwotaWplaty;
    }

    public Instalacja getInstalacja() {
        return instalacja;
    }

    public void setInstalacja(Instalacja instalacja) {
        this.instalacja = instalacja;
    }

    public DokonaneWplaty() {}

    public DokonaneWplaty(LocalDate terminWplaty, BigDecimal kwotaWplaty, Instalacja instalacja) {
        this.terminWplaty = terminWplaty;
        this.kwotaWplaty = kwotaWplaty;
        this.instalacja = instalacja;
    }
}