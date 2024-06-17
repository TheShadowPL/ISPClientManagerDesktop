package org.example.lab6.klient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.example.lab6.klient.Klient;
import org.example.lab6.klient.KlientRepository;
import java.util.Arrays;

@Component
public class kleinttest implements CommandLineRunner {
    private final KlientRepository klientRepository;

    public kleinttest(KlientRepository klientRepository) {
        this.klientRepository = klientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Klient klient1 = new Klient("Imię1", "Nazwisko1", "Numer1");
        Klient klient2 = new Klient("Imię2", "Nazwisko2", "Numer2");
        klientRepository.saveAll(Arrays.asList(klient1, klient2));
    }

}
