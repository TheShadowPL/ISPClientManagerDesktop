package org.example.lab6.platnosci;

import org.example.lab6.platnosci.DokonaneWplaty;
import org.example.lab6.platnosci.DokonaneWplatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dokonane-wplaty")
public class DokonaneWplatyController {

    private final DokonaneWplatyService dokonaneWplatyService;

    @Autowired

    public DokonaneWplatyController(DokonaneWplatyService dokonaneWplatyService) {
        this.dokonaneWplatyService = dokonaneWplatyService;
    }

    @GetMapping
    public ResponseEntity<List<DokonaneWplaty>> getAllDokonaneWpłaty() {
        List<DokonaneWplaty> DokonaneWplaty = dokonaneWplatyService.findAll();
        return new ResponseEntity<>(DokonaneWplaty, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DokonaneWplaty> getDokonaneWpłatyById(@PathVariable("id") Long id) {
        return dokonaneWplatyService.findById(id)
                .map(wpłata -> new ResponseEntity<>(wpłata, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DokonaneWplaty> createDokonaneWpłaty(@RequestBody DokonaneWplaty wplata) {
        DokonaneWplaty createdWplata = dokonaneWplatyService.save(wplata);
        return new ResponseEntity<>(createdWplata, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DokonaneWplaty> updateDokonaneWpłaty(@PathVariable("id") Long id, @RequestBody DokonaneWplaty wplata) {
        if (!dokonaneWplatyService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wplata.setId(id);
        DokonaneWplaty updatedWpłata = dokonaneWplatyService.save(wplata);
        return new ResponseEntity<>(updatedWpłata, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDokonaneWpłaty(@PathVariable("id") Long id) {
        dokonaneWplatyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
