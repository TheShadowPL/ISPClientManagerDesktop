package org.example.lab6.instalacja;

import org.example.lab6.instalacja.Instalacja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalacjaRepository extends JpaRepository<Instalacja, Long> {
}