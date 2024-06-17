package org.example.lab6.platnosci;

import org.example.lab6.platnosci.DokonaneWplaty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokonaneWplatyRepository extends JpaRepository<DokonaneWplaty, Long> {

}