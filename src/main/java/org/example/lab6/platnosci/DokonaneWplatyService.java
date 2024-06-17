package org.example.lab6.platnosci;

import org.example.lab6.platnosci.DokonaneWplaty;
import org.example.lab6.platnosci.DokonaneWplatyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DokonaneWplatyService {

    private final DokonaneWplatyRepository dokonaneWplatyRepository;

    @Autowired
    public DokonaneWplatyService(DokonaneWplatyRepository dokonaneWplatyRepository) {
        this.dokonaneWplatyRepository = dokonaneWplatyRepository;
    }


    public List<DokonaneWplaty> findAll() {
        return dokonaneWplatyRepository.findAll();
    }

    public Optional<DokonaneWplaty> findById(Long id) {
        return dokonaneWplatyRepository.findById(id);
    }

    public DokonaneWplaty save(DokonaneWplaty wpłata) {
        return dokonaneWplatyRepository.save(wpłata);
    }

    public void deleteById(Long id) {
        dokonaneWplatyRepository.deleteById(id);
    }
}