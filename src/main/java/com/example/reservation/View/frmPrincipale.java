package com.example.reservation.View;

import javax.swing.*;

public class frmPrincipale extends JFrame {
    private JPanel panel1=new JPanel();

    public frmPrincipale() {
        setTitle("Système de Réservation");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuGestion = new JMenu("Gestion");

        JMenuItem mnuPassager = new JMenuItem("Passager");
        JMenuItem mnuVol = new JMenuItem("Vol");
        JMenuItem mnuReservation = new JMenuItem("Réservation");
        JMenuItem mnuPaiement = new JMenuItem("Paiement");
        JMenuItem mnuBillet = new JMenuItem("Billet");

        menuGestion.add(mnuPassager);
        menuGestion.add(mnuVol);
        menuGestion.add(mnuReservation);
        menuGestion.add(mnuPaiement);
        menuGestion.add(mnuBillet);

        menuBar.add(menuGestion);
        setJMenuBar(menuBar);
    }

}
