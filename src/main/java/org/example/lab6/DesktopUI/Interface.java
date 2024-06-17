package org.example.lab6.DesktopUI;

import org.example.lab6.cennik.Cennik;
import org.example.lab6.cennik.CennikController;
import org.example.lab6.platnosci.DokonaneWplaty;
import org.example.lab6.platnosci.DokonaneWplatyController;
import org.example.lab6.instalacja.Instalacja;
import org.example.lab6.instalacja.InstalacjaController;
import org.example.lab6.klient.Klient;
import org.example.lab6.klient.KlientController;
import org.example.lab6.platnosci.NaliczoneNaleznosci;
import org.example.lab6.platnosci.NaliczoneNaleznosciController;
import org.springframework.http.ResponseEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

public class Interface extends JFrame {

    private final CennikController cennikController;
    private final DokonaneWplatyController dokonaneWplatyController;
    private final InstalacjaController instalacjaController;
    private final KlientController klientController;
    private final NaliczoneNaleznosciController naliczoneNaleznosciController;

    public Interface(CennikController cennikController, DokonaneWplatyController dokonaneWplatyController,
                     InstalacjaController instalacjaController, KlientController klientController, NaliczoneNaleznosciController naliczoneNaleznosciController) {
        this.cennikController = cennikController;
        this.dokonaneWplatyController = dokonaneWplatyController;
        this.instalacjaController = instalacjaController;
        this.klientController = klientController;
        this.naliczoneNaleznosciController = naliczoneNaleznosciController;

        setTitle("Interfejs Swing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3));


        JButton createCennikButton = new JButton("Utwórz Cennik");
        createCennikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typUslugi = JOptionPane.showInputDialog("Podaj typ usługi:");
                String cenaText = JOptionPane.showInputDialog("Podaj cenę:");
                BigDecimal cena = new BigDecimal(cenaText);
                Cennik newCennik = new Cennik(typUslugi, cena);
                cennikController.createCennik(newCennik);
                textArea.append("Utworzono nowy cennik: " + newCennik + "\n");
            }
        });

        JButton readCennikButton = new JButton("Wyświetl Cenniki");
        readCennikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResponseEntity<List<Cennik>> responseEntity = cennikController.getAllCenniki();
                List<Cennik> cenniki = responseEntity.getBody();
                textArea.append("Cenniki:\n");
                for (Cennik cennik : cenniki) {
                    textArea.append("- " + cennik + "\n");
                }
            }
        });

        JButton updateCennikButton = new JButton("Aktualizuj Cennik");
        updateCennikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID cennika do aktualizacji:");
                Long id = Long.parseLong(idString);
                String typUslugi = JOptionPane.showInputDialog("Podaj typ usługi:");
                String cenaText = JOptionPane.showInputDialog("Podaj cenę:");
                BigDecimal cena = new BigDecimal(cenaText);
                Cennik newCennik = new Cennik(typUslugi, cena);
                cennikController.updateCennik(id, newCennik);
                textArea.append("Zaktualizowano cennik o ID " + id + ": " + newCennik + "\n");
            }
        });

        JButton deleteCennikButton = new JButton("Usuń Cennik");
        deleteCennikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID cennika do usunięcia:");
                Long id = Long.parseLong(idString);
                cennikController.deleteCennik(id);
                textArea.append("Usunięto cennik o ID " + id + "\n");
            }
        });
        JButton createKlientButton = new JButton("Utwórz Klienta");
        createKlientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = JOptionPane.showInputDialog("Podaj imie klienta:");
                String nazwisko = JOptionPane.showInputDialog("Podaj imie klienta:");
                String number = JOptionPane.showInputDialog("Podaj numer Klienta:");
                Klient newKlient = new Klient(imie, nazwisko, number);
                klientController.createKlient(newKlient);
                textArea.append("Utworzono nowego klienta: " + newKlient + "\n");
            }
        });

        JButton readKlientButton = new JButton("Wyświetl Klientów");
        readKlientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResponseEntity<List<Klient>> responseEntity = klientController.getAllKlienci();
                List<Klient> klienci = responseEntity.getBody();
                textArea.append("Klienci:\n");
                for (Klient klient : klienci) {
                    textArea.append("- " + klient + "\n");
                }
            }
        });

        JButton updateKlientButton = new JButton("Aktualizuj Klienta");
        updateKlientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID klienta do aktualizacji:");
                Long id = Long.parseLong(idString);
                String imie = JOptionPane.showInputDialog("Podaj imie klienta:");
                String nazwisko = JOptionPane.showInputDialog("Podaj imie klienta:");
                String number = JOptionPane.showInputDialog("Podaj numer Klienta:");
                Klient updatedKlient = new Klient(imie, nazwisko, number);
                klientController.updateKlient(id, updatedKlient);
                textArea.append("Zaktualizowano klienta o ID " + id + ": " + updatedKlient + "\n");
            }
        });

        JButton deleteKlientButton = new JButton("Usuń Klienta");
        deleteKlientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID klienta do usunięcia:");
                Long id = Long.parseLong(idString);
                klientController.deleteKlient(id);
                textArea.append("Usunięto klienta o ID " + id + "\n");
            }
        });

        JButton createInstalacjaButton = new JButton("Utwórz Instalację");
        createInstalacjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwa = JOptionPane.showInputDialog("Podaj nazwę instalacji:");
                /*
                Instalacja newInstalacja = new Instalacja(nazwa);
                instalacjaController.createInstalacja(newInstalacja);
                textArea.append("Utworzono nową instalację: " + newInstalacja + "\n");*/
            }
        });

        JButton readInstalacjaButton = new JButton("Wyświetl Instalacje");
        readInstalacjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Instalacja> instalacje = (List<Instalacja>) instalacjaController.getAllInstalacje();
                textArea.append("Instalacje:\n");
                for (Instalacja instalacja : instalacje) {
                    textArea.append("- " + instalacja + "\n");
                }
            }
        });

        JButton updateInstalacjaButton = new JButton("Aktualizuj Instalację");
        updateInstalacjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID instalacji do aktualizacji:");
                Long id = Long.parseLong(idString);
                String names0 = JOptionPane.showInputDialog("Podaj adres:");
                String names1 = JOptionPane.showInputDialog("Podaj numer routera:");
                String names2 = JOptionPane.showInputDialog("Podaj Typ usługi:");
                String names3 = JOptionPane.showInputDialog("Podaj Id klienta:");
                /*
                Instalacja updatedInstalacja = new Instalacja(names0, names1, names2, names3);
                instalacjaController.updateInstalacja(id, updatedInstalacja);
                textArea.append("Zaktualizowano instalację o ID " + id + ": " + updatedInstalacja + "\n");
                */
            }
        });

        JButton deleteInstalacjaButton = new JButton("Usuń Instalację");
        deleteInstalacjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID instalacji do usunięcia:");
                Long id = Long.parseLong(idString);
                instalacjaController.deleteInstalacja(id);
                textArea.append("Usunięto instalację o ID " + id + "\n");
            }
        });
        JButton createDokonaneWplatyButton = new JButton("Utwórz Dokonaną Wpłatę");
        createDokonaneWplatyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DokonaneWplaty newWplata = new DokonaneWplaty();
                dokonaneWplatyController.createDokonaneWpłaty(newWplata);
                textArea.append("Utworzono nową dokonaną wpłatę: " + newWplata + "\n");
            }
        });

        JButton readDokonaneWplatyButton = new JButton("Wyświetl Dokonane Wpłaty");
        readDokonaneWplatyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<DokonaneWplaty> dokonaneWplaty = (List<DokonaneWplaty>) dokonaneWplatyController.getAllDokonaneWpłaty();
                textArea.append("Dokonane Wpłaty:\n");
                for (DokonaneWplaty wplata : dokonaneWplaty) {
                    textArea.append("- " + wplata + "\n");
                }
            }
        });

        JButton updateDokonaneWplatyButton = new JButton("Aktualizuj Dokonaną Wpłatę");
        updateDokonaneWplatyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID dokonanej wpłaty do aktualizacji:");
                Long id = Long.parseLong(idString);
                DokonaneWplaty updatedWplata = new DokonaneWplaty();
                dokonaneWplatyController.updateDokonaneWpłaty(id, updatedWplata);
                textArea.append("Zaktualizowano dokonaną wpłatę o ID " + id + ": " + updatedWplata + "\n");
            }
        });

        JButton deleteDokonaneWplatyButton = new JButton("Usuń Dokonaną Wpłatę");
        deleteDokonaneWplatyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID dokonanej wpłaty do usunięcia:");
                Long id = Long.parseLong(idString);
                dokonaneWplatyController.deleteDokonaneWpłaty(id);
                textArea.append("Usunięto dokonaną wpłatę o ID " + id + "\n");
            }
        });

        JButton createNaliczoneNaleznosciButton = new JButton("Utwórz Naliczoną Należność");
        createNaliczoneNaleznosciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NaliczoneNaleznosci newNaleznosc = new NaliczoneNaleznosci();
                naliczoneNaleznosciController.createNaliczoneNależności(newNaleznosc);
                textArea.append("Utworzono nową naliczoną należność: " + newNaleznosc + "\n");
            }
        });

        JButton readNaliczoneNaleznosciButton = new JButton("Wyświetl Naliczone Należności");
        readNaliczoneNaleznosciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<NaliczoneNaleznosci> naliczoneNaleznosci = (List<NaliczoneNaleznosci>) naliczoneNaleznosciController.getAllNaliczoneNależności();
                textArea.append("Naliczone Należności:\n");
                for (NaliczoneNaleznosci naleznosc : naliczoneNaleznosci) {
                    textArea.append("- " + naleznosc + "\n");
                }
            }
        });

        JButton updateNaliczoneNaleznosciButton = new JButton("Aktualizuj Naliczoną Należność");
        updateNaliczoneNaleznosciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID naliczonej należności do aktualizacji:");
                Long id = Long.parseLong(idString);
                NaliczoneNaleznosci updatedNaleznosc = new NaliczoneNaleznosci();
                naliczoneNaleznosciController.updateNaliczoneNależności(id, updatedNaleznosc);
                textArea.append("Zaktualizowano naliczoną należność o ID " + id + ": " + updatedNaleznosc + "\n");
            }
        });

        JButton deleteNaliczoneNaleznosciButton = new JButton("Usuń Naliczoną Należność");
        deleteNaliczoneNaleznosciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = JOptionPane.showInputDialog("Podaj ID naliczonej należności do usunięcia:");
                Long id = Long.parseLong(idString);
                naliczoneNaleznosciController.deleteNaliczoneNależności(id);
                textArea.append("Usunięto naliczoną należność o ID " + id + "\n");
            }
        });








        buttonPanel.add(createCennikButton);
        buttonPanel.add(readCennikButton);
        buttonPanel.add(updateCennikButton);
        buttonPanel.add(deleteCennikButton);
        buttonPanel.add(createKlientButton);
        buttonPanel.add(readKlientButton);
        buttonPanel.add(updateKlientButton);
        buttonPanel.add(deleteKlientButton);
        buttonPanel.add(createInstalacjaButton);
        buttonPanel.add(readInstalacjaButton);
        buttonPanel.add(updateInstalacjaButton);
        buttonPanel.add(deleteInstalacjaButton);
        buttonPanel.add(createDokonaneWplatyButton);
        buttonPanel.add(readDokonaneWplatyButton);
        buttonPanel.add(updateDokonaneWplatyButton);
        buttonPanel.add(deleteDokonaneWplatyButton);
        buttonPanel.add(createNaliczoneNaleznosciButton);
        buttonPanel.add(readNaliczoneNaleznosciButton);
        buttonPanel.add(updateNaliczoneNaleznosciButton);
        buttonPanel.add(deleteNaliczoneNaleznosciButton);
        /*buttonPanel.add(addPaymentButton);
        buttonPanel.add(editPaymentButton);
        buttonPanel.add(deletePaymentButton);
        //buttonPanel.add(viewPriceListButton);
        buttonPanel.add(viewCustomersButton);
        buttonPanel.add(viewInstallationsButton);*/

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
