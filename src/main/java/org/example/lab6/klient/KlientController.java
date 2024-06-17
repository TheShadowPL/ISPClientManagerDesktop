package org.example.lab6.klient;

import org.example.lab6.klient.Klient;
import org.example.lab6.klient.KlientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/klienci")
public class KlientController {

    private final KlientService klientService;

    @Autowired
    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping
    public ResponseEntity<List<Klient>> getAllKlienci() {
        List<Klient> klienci = klientService.findAll();
        return new ResponseEntity<>(klienci, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Klient> getKlientById(@PathVariable("id") Long id) {
        return klientService.findById(id)
                .map(klient -> new ResponseEntity<>(klient, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Klient> createKlient(@RequestBody Klient klient) {
        Klient createdKlient = klientService.save(klient);
        return new ResponseEntity<>(createdKlient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Klient> updateKlient(@PathVariable("id") Long id, @RequestBody Klient klient) {
        if (!klientService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        klient.setId(id);
        Klient updatedKlient = klientService.save(klient);
        return new ResponseEntity<>(updatedKlient, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteKlient(@PathVariable("id") Long id) {
        klientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
