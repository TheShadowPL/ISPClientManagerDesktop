package org.example.lab6.cennik;

import org.example.lab6.cennik.Cennik;
import org.example.lab6.cennik.CennikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CennikService {

    private final CennikRepository cennikRepository;

    @Autowired
    public CennikService(CennikRepository cennikRepository) {
        this.cennikRepository = cennikRepository;
    }

    public List<Cennik> findAll() {
        return cennikRepository.findAll();
    }

    public Optional<Cennik> findById(Long id) {
        return cennikRepository.findById(id);
    }

    public Cennik save(Cennik cennik) {
        return cennikRepository.save(cennik);
    }

    public void deleteById(Long id) {
        cennikRepository.deleteById(id);
    }
}
