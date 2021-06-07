package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npcommon.domain.Predmet;
import rs.ac.bg.fon.ai.npcommon.domain.Student;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.StudentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class StudentController {

    Student student;

    private final StudentPanel panel;

    public StudentController() {
        panel = new StudentPanel();
        student = new Student();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    private void prepareView() {
        clearAllErrorLabels();

        try {
            List<Predmet> listaPredmeta = new ArrayList<>();
            if(KontrolerAL.getInstance().ucitajListuPredmeta(listaPredmeta)){
                panel.getCbPredmet().setModel(new DefaultComboBoxModel<>(listaPredmeta.toArray()));
            } else {
                 JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("connection_failed"));
            Coordinator.getInstance().closeMainFrame();
            }
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("connection_failed"));
            Coordinator.getInstance().closeMainFrame();
        }
        
        try {
            panel.getTxtBrojIndeksaPretraga().setFormatterFactory(
                    new DefaultFormatterFactory(
                            new MaskFormatter("####/####")));

            panel.getTxtBrojIndeksa().setFormatterFactory(
                    new DefaultFormatterFactory(
                            new MaskFormatter("####/####")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        panel.getBtnPretrazi().setText(Coordinator.getInstance().getMessage("btn_search"));
        panel.getBtnKreiraj().setText(Coordinator.getInstance().getMessage("btn_create"));
        panel.getBtnSacuvaj().setText(Coordinator.getInstance().getMessage("btn_save"));
        
        panel.getLblBrojIndeksa().setText(Coordinator.getInstance().getMessage("lbl_student_id"));
        panel.getLblPretraga().setText(Coordinator.getInstance().getMessage("lbl_student_search"));
        panel.getLblIme().setText(Coordinator.getInstance().getMessage("lbl_student_firstname"));
        panel.getLblPrezime().setText(Coordinator.getInstance().getMessage("lbl_student_lastname"));
        panel.getLblPredmet().setText(Coordinator.getInstance().getMessage("lbl_student_subject"));
        
        panel.getBtnSacuvaj().setEnabled(false);

    }

    private void clearAllErrorLabels() {
        panel.getLblErrorPretraga().setText("");
        panel.getLblErrorBrojIndeksa().setText("");
        panel.getLblErrorIme().setText("");
        panel.getLblErrorPrezime().setText("");
    }

    private void addListeners() {
        panel.getBtnPretrazi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String brojIndeksa = panel.getTxtBrojIndeksaPretraga().getText().trim();

                String porukaIspravanBrIndeksa = proveraBrojaIndeksa(brojIndeksa);

                if (!porukaIspravanBrIndeksa.equals("OK")) {
                    panel.getLblErrorPretraga().setText(porukaIspravanBrIndeksa);
                    return;
                }
                student = new Student();

                student.setBrojIndeksa(brojIndeksa);

                try {

                     if(!KontrolerAL.getInstance().pretraziStudenta(student)){
                        throw new Exception();
                    }

                    if (student == null) {
                        throw new Exception();
                    } else {
                        panel.getTxtBrojIndeksa().setText(student.getBrojIndeksa());

                        panel.getTxtIme().setText(student.getIme());
                        panel.getTxtPrezime().setText(student.getPrezime());

                        if (student.getPredmet().getNaziv() == null) {
                            panel.getCbPredmet().setSelectedIndex(-1);

                        } else {
                            panel.getCbPredmet().setSelectedItem(student.getPredmet());
                        }

                        panel.getBtnSacuvaj().setEnabled(true);
                        clearAllErrorLabels();
                        JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_found"));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_not_found"));
                }

            }

        });
        panel.getBtnKreiraj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    student = new Student();
                    if(!KontrolerAL.getInstance().kreirajStudenta(student)){
                        throw new Exception();
                    }
                    
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_created"));

                    panel.getTxtBrojIndeksa().setText("");
                    panel.getTxtIme().setText("");
                    panel.getTxtPrezime().setText("");
                    panel.getCbPredmet().setSelectedIndex(0);

                    panel.getBtnSacuvaj().setEnabled(true);
                    panel.getBtnPretrazi().setEnabled(false);
                    panel.getBtnKreiraj().setEnabled(false);
                    clearAllErrorLabels();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_not_created"));
                }
            }

        });
        panel.getBtnSacuvaj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String brojIndeksa = panel.getTxtBrojIndeksa().getText().trim();

                String ime = panel.getTxtIme().getText().trim();
                String prezime = panel.getTxtPrezime().getText().trim();

                Predmet p = (Predmet) panel.getCbPredmet().getModel().getSelectedItem();

                if (!proveriUnetePodatke(brojIndeksa, ime, prezime)) {
                    return;
                }

                student = new Student(student.getSifra(), brojIndeksa, ime, prezime, false, p);

                try {
                    if(!KontrolerAL.getInstance().zapamtiStudenta(student)){
                        throw new Exception();
                    }
                    panel.getBtnSacuvaj().setEnabled(false);
                    panel.getBtnPretrazi().setEnabled(true);
                    panel.getBtnKreiraj().setEnabled(true);

                    clearAllErrorLabels();
                    panel.getTxtBrojIndeksa().setText("");
                    panel.getTxtIme().setText("");
                    panel.getTxtPrezime().setText("");
                    panel.getCbPredmet().setSelectedIndex(0);

                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_saved"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_not_saved"));
                }
            }

            private boolean proveriUnetePodatke(String brojIndeksa, String ime, String prezime) {

                //provera unosa broj indeksa
                String porukaIspravanBrIndeksa = proveraBrojaIndeksa(brojIndeksa);

                if (!porukaIspravanBrIndeksa.equals("OK")) {
                    panel.getLblErrorBrojIndeksa().setText(porukaIspravanBrIndeksa);
                    return false;
                }

                //provera unosa imena i prezimena
                if (ime.equals("") || ime.length() < 2) {
                    panel.getLblErrorIme().setText(Coordinator.getInstance().getMessage("student_lastname_input_incorrect"));
                    return false;
                }

                panel.getLblErrorIme().setText("");

                if (prezime.equals("") || prezime.length() < 2) {
                    panel.getLblErrorPrezime().setText(Coordinator.getInstance().getMessage("student_firstname_input_incorrect"));
                    return false;
                }
                panel.getLblErrorPrezime().setText("");

                return true;
            }
        });
    }

    private String proveraBrojaIndeksa(String brojIndeksa) {
        if (brojIndeksa.length() != 9) {
            return Coordinator.getInstance().getMessage("student_id_input_incorrect");
        }
        String godUpisaS = brojIndeksa.substring(0, 4);

        String brS = brojIndeksa.substring(5, 9);

        try {
            int god = Integer.parseInt(godUpisaS);

            if (god < 1990) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException pe) {
            return Coordinator.getInstance().getMessage("student_id_input_incorrect");
        }
        try {
            int br = Integer.parseInt(brS);

            if (br < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException pe) {
            return Coordinator.getInstance().getMessage("student_id_input_incorrect");
        }

        panel.getLblErrorBrojIndeksa().setText("");
        return "OK";
    }

    public StudentPanel getPanel() {
        return panel;
    }
}
