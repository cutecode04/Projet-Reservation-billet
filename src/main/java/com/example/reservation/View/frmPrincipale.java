package com.example.reservation.View;

import javax.swing.*;

public class frmPrincipale extends JFrame {
    private JPanel panel1;

    public frmPrincipale() {
        setTitle("Système de Réservation");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        //  Barre de menu
        JMenuBar menuBar = new JMenuBar();

        //  Menu principal
        JMenu menuAction = new JMenu("Action");

        // Sous-menu Gestion
        JMenu menuGestion = new JMenu("Gestion");

        JMenuItem itemPassager = new JMenuItem("Passager");
        JMenuItem itemVol = new JMenuItem("Vol");
        JMenuItem itemAvion = new JMenuItem("Avion");
        JMenuItem itemCompagnie = new JMenuItem("Compagnie Aérienne");
        JMenuItem itemAeroport = new JMenuItem("Aéroport");

        menuGestion.add(itemPassager);
        menuGestion.add(itemVol);
        menuGestion.add(itemAvion);
        menuGestion.add(itemCompagnie);
        menuGestion.add(itemAeroport);

        // Sous-menu Opérations
        JMenu menuOperations = new JMenu("Opérations");

        JMenuItem itemReservation = new JMenuItem("Réservation");
        JMenuItem itemPaiement = new JMenuItem("Paiement");
        JMenuItem itemBillet = new JMenuItem("Billet");

        menuOperations.add(itemReservation);
        menuOperations.add(itemPaiement);
        menuOperations.add(itemBillet);

        // Ajouter sous-menus dans Action
        menuAction.add(menuGestion);
        menuAction.add(menuOperations);

        // Ajouter Action à la barre
        menuBar.add(menuAction);

        // Appliquer à la fenêtre
        setJMenuBar(menuBar);
    }

}
