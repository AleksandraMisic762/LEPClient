package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npcommon.domain.Eksperiment;
import rs.ac.bg.fon.ai.npcommon.domain.Eksperimentator;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.EksperimentatorPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EksperimentatorController {

    private Eksperimentator eksperimentator;
    private final EksperimentatorPanel panel;

    public EksperimentatorController() {
        eksperimentator = new Eksperimentator();
        panel = new EksperimentatorPanel();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    public void prepareView() {
        clearAllErrorLabels();

        panel.getLblIme().setText(Coordinator.getInstance().getMessage("lbl_student_firstname"));
        panel.getLblPrezime().setText(Coordinator.getInstance().getMessage("lbl_student_lastname"));
        
        panel.getBtnSacuvaj().setEnabled(false);
        
        panel.getBtnKreiraj().setText(Coordinator.getInstance().getMessage("btn_create"));
        panel.getBtnSacuvaj().setText(Coordinator.getInstance().getMessage("btn_save"));
        
        try {
            if (!KontrolerAL.getInstance().ucitajListuEksperimenata(new ArrayList<Eksperiment>())) {
                throw new Exception();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("connection_failed"));
            Coordinator.getInstance().closeMainFrame();
        }
    }

    public void clearAllErrorLabels() {
        panel.getLblErrorIme().setText("");
        panel.getLblErrorPrezime().setText("");
    }

    public void addListeners() {
        panel.getBtnKreiraj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eksperimentator = new Eksperimentator();
                    if(!KontrolerAL.getInstance().kreirajEksperimentatora(eksperimentator)){
                        throw new Exception();
                    }
                    panel.getBtnSacuvaj().setEnabled(true);
                    panel.getBtnKreiraj().setEnabled(false);
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experimenter_created"));
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experimenter_not_created"));
                }
            }
        });
        panel.getBtnSacuvaj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = panel.getTxtIme().getText().trim();
                
                boolean ispravno = true;
                
                if(ime.equals("") || ime.length() < 2){
                    panel.getLblErrorIme().setText(Coordinator.getInstance().getMessage("experimenter_firstname_input_incorrect"));
                    ispravno = false;
                } else {
                    panel.getLblErrorIme().setText("");
                }
                
                String prezime = panel.getTxtPrezime().getText().trim();

                if(prezime.equals("") || prezime.length() < 2){
                    panel.getLblErrorPrezime().setText(Coordinator.getInstance().getMessage("experimenter_lastname_input_incorrect"));
                    ispravno = false;
                } else {
                    panel.getLblErrorPrezime().setText("");
                }
                
                
                if(!ispravno){
                    return;
                }
                clearAllErrorLabels();
                
                eksperimentator = new Eksperimentator(eksperimentator.getSifra(), ime, prezime);

                try {
                    
                    if(!KontrolerAL.getInstance().zapamtiEksperimentator(eksperimentator)){
                        throw new Exception();
                    }
                    
                    panel.getBtnKreiraj().setEnabled(true);
                    panel.getBtnSacuvaj().setEnabled(false);
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experimenter_saved"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experimenter_not_saved"));
                }
            }
        });
    }

    public EksperimentatorPanel getPanel() {
        return panel;
    }
}
