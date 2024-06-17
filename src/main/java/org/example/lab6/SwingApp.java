package org.example.lab6;

import org.example.lab6.DesktopUI.Interface;
import org.example.lab6.cennik.CennikController;
import org.example.lab6.platnosci.DokonaneWplatyController;
import org.example.lab6.instalacja.InstalacjaController;
import org.example.lab6.klient.KlientController;
import org.example.lab6.platnosci.NaliczoneNaleznosciController;

import javax.swing.*;

public class SwingApp {

    public static void launchSwingApp(CennikController cennikController,
                                      DokonaneWplatyController dokonaneWplatyController,
                                      InstalacjaController instalacjaController,
                                      KlientController klientController, NaliczoneNaleznosciController naliczoneNaleznosciController) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Interface desktopInterface = new Interface(cennikController, dokonaneWplatyController,
                        instalacjaController, klientController, naliczoneNaleznosciController);
            }
        });
    }

    public static void launchSwingApp() {
    }
}
