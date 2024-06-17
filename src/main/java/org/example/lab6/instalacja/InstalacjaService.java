package org.example.lab6.instalacja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstalacjaService {
    private final InstalacjaRepository instalacjaRepository;

    public InstalacjaService(InstalacjaRepository instalacjaRepository) {
        this.instalacjaRepository = instalacjaRepository;
    }

    public List<Instalacja> findAll() {
        return instalacjaRepository.findAll();
    }

    public Optional<Instalacja> findById(Long id) {
        return instalacjaRepository.findById(id);
    }

    public Instalacja save(Instalacja instalacja) {
        return instalacjaRepository.save(instalacja);
    }

    public void deleteById(Long id) {
        instalacjaRepository.deleteById(id);
    }
}
