package org.example.lab6.cennik;

import org.example.lab6.cennik.Cennik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CennikRepository extends JpaRepository<Cennik, Long> {

}