package org.example.lab6.klient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KlientService {
    private final KlientRepository klientRepository;

    @Autowired
    public KlientService(KlientRepository klientRepository) {
        this.klientRepository = klientRepository;
    }

    public List<Klient> findAll() {
        return klientRepository.findAll();
    }

    public Optional<Klient> findById(Long id) {
        return klientRepository.findById(id);
    }

    public Klient save(Klient klient) {
        return klientRepository.save(klient);
    }

    public void deleteById(Long id) {
        klientRepository.deleteById(id);
    }
}
