package org.example.lab6.instalacja;

import org.example.lab6.instalacja.Instalacja;
import org.example.lab6.instalacja.InstalacjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instalacje")
public class InstalacjaController {

    private final InstalacjaService instalacjaService;

    @Autowired
    public InstalacjaController(InstalacjaService instalacjaService) {
        this.instalacjaService = instalacjaService;
    }

    @GetMapping
    public ResponseEntity<List<Instalacja>> getAllInstalacje() {
        List<Instalacja> instalacje = instalacjaService.findAll();
        return new ResponseEntity<>(instalacje, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instalacja> getInstalacjaById(@PathVariable("id") Long id) {
        return instalacjaService.findById(id)
                .map(instalacja -> new ResponseEntity<>(instalacja, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Instalacja> createInstalacja(@RequestBody Instalacja instalacja) {
        Instalacja createdInstalacja = instalacjaService.save(instalacja);
        return new ResponseEntity<>(createdInstalacja, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instalacja> updateInstalacja(@PathVariable("id") Long id, @RequestBody Instalacja instalacja) {
        if (!instalacjaService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        instalacja.setId(id);
        Instalacja updatedInstalacja = instalacjaService.save(instalacja);
        return new ResponseEntity<>(updatedInstalacja, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInstalacja(@PathVariable("id") Long id) {
        instalacjaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
