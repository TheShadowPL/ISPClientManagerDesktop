package org.example.lab6;


import org.example.lab6.cennik.CennikController;
import org.example.lab6.instalacja.InstalacjaController;
import org.example.lab6.klient.KlientController;
import org.example.lab6.platnosci.DokonaneWplatyController;
import org.example.lab6.platnosci.DokonaneWplatyService;
import org.example.lab6.platnosci.NaliczoneNaleznosciController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.lab6.DesktopUI.Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.swing.*;

@SpringBootApplication
public class Lab6Application {

    private static CennikController cennikController;
    private static DokonaneWplatyController dokonaneWplatyController;
    private static InstalacjaController instalacjaController;
    private static KlientController klientController;
    private static NaliczoneNaleznosciController naliczoneNaleznosciController;

    @Autowired
    public Lab6Application(CennikController cennikController, DokonaneWplatyController dokonaneWplatyController,
                           InstalacjaController instalacjaController, KlientController klientController, NaliczoneNaleznosciController naliczoneNaleznosciController) {
        Lab6Application.cennikController = cennikController;
        Lab6Application.dokonaneWplatyController = dokonaneWplatyController;
        Lab6Application.instalacjaController = instalacjaController;
        Lab6Application.klientController = klientController;
        Lab6Application.naliczoneNaleznosciController =  naliczoneNaleznosciController;
    }

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(Lab6Application.class, args);
        javax.swing.SwingUtilities.invokeLater(() -> SwingApp.launchSwingApp(cennikController, dokonaneWplatyController,
                instalacjaController, klientController, naliczoneNaleznosciController));
    }
}
