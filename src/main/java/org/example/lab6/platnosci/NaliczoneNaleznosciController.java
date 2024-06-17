package org.example.lab6.platnosci;

import org.example.lab6.platnosci.NaliczoneNaleznosci;
import org.example.lab6.platnosci.NaliczoneNaleznosciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/naliczone-naleznosci")

public class NaliczoneNaleznosciController {

    private final NaliczoneNaleznosciService naliczoneNaleznosciService;


    @Autowired
    public NaliczoneNaleznosciController(NaliczoneNaleznosciService naliczoneNaleznosciService ) {
        this.naliczoneNaleznosciService = naliczoneNaleznosciService;
    }



    @GetMapping
    public ResponseEntity<List<NaliczoneNaleznosci>> getAllNaliczoneNależności() {
        List<NaliczoneNaleznosci> naliczoneNależności = naliczoneNaleznosciService.findAll();
        return new ResponseEntity<>(naliczoneNależności, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NaliczoneNaleznosci> getNaliczoneNależnościById(@PathVariable("id") Long id) {
        return naliczoneNaleznosciService.findById(id)
                .map(należność -> new ResponseEntity<>(należność, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<NaliczoneNaleznosci> createNaliczoneNależności(@RequestBody NaliczoneNaleznosci należność) {
        NaliczoneNaleznosci createdNależność = naliczoneNaleznosciService.save(należność);
        return new ResponseEntity<>(createdNależność, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NaliczoneNaleznosci> updateNaliczoneNależności(@PathVariable("id") Long id, @RequestBody NaliczoneNaleznosci naleznosc) {
        if (!naliczoneNaleznosciService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        naleznosc.setId(id);
        NaliczoneNaleznosci updatedNależność = naliczoneNaleznosciService.save(naleznosc);
        return new ResponseEntity<>(updatedNależność, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteNaliczoneNależności(@PathVariable("id") Long id) {
        naliczoneNaleznosciService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
