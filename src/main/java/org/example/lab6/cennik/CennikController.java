package org.example.lab6.cennik;

import org.example.lab6.cennik.Cennik;
import org.example.lab6.cennik.CennikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cenniki")
public class CennikController {

    private final CennikService cennikService;

    @Autowired
    public CennikController(CennikService cennikService) {
        this.cennikService = cennikService;
    }

    @GetMapping
    public ResponseEntity<List<Cennik>> getAllCenniki() {
        List<Cennik> cenniki = cennikService.findAll();
        return new ResponseEntity<>(cenniki, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cennik> getCennikById(@PathVariable("id") Long id) {
        return cennikService.findById(id)
                .map(cennik -> new ResponseEntity<>(cennik, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cennik> createCennik(@RequestBody Cennik cennik) {
        Cennik createdCennik = cennikService.save(cennik);
        return new ResponseEntity<>(createdCennik, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cennik> updateCennik(@PathVariable("id") Long id, @RequestBody Cennik cennik) {
        if (!cennikService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cennik.setId(id);
        Cennik updatedCennik = cennikService.save(cennik);
        return new ResponseEntity<>(updatedCennik, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCennik(@PathVariable("id") Long id) {
        cennikService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
