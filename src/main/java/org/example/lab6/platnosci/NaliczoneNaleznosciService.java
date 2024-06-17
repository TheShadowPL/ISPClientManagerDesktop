package org.example.lab6.platnosci;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NaliczoneNaleznosciService {

    private final NaliczoneNaleznosciRepository naliczoneNaleznosciRepository;

    public NaliczoneNaleznosciService(NaliczoneNaleznosciRepository naliczoneNaleznosciRepository) {
        this.naliczoneNaleznosciRepository = naliczoneNaleznosciRepository;
    }

    public List<NaliczoneNaleznosci> findAll() {
        return naliczoneNaleznosciRepository.findAll();
    }

    public Optional<NaliczoneNaleznosci> findById(Long id) {
        return naliczoneNaleznosciRepository.findById(id);
    }

    public NaliczoneNaleznosci save(NaliczoneNaleznosci naleznosc) {
        return naliczoneNaleznosciRepository.save(naleznosc);
    }

    public void deleteById(Long id) {
        naliczoneNaleznosciRepository.deleteById(id);
    }

}
