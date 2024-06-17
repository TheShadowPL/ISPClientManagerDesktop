package org.example.lab6.platnosci;

import org.example.lab6.platnosci.NaliczoneNaleznosci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NaliczoneNaleznosciRepository extends JpaRepository<NaliczoneNaleznosci, Long> {

}
