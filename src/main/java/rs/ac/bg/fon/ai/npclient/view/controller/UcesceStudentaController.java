package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npcommon.domain.Eksperiment;
import rs.ac.bg.fon.ai.npcommon.domain.SE;
import rs.ac.bg.fon.ai.npcommon.domain.Student;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.UcesceStudentaPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class UcesceStudentaController {

    Student student;

    private final UcesceStudentaPanel panel;

    public UcesceStudentaController() {
        panel = new UcesceStudentaPanel();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    private void prepareView() {
        panel.getLblErrorPretraga().setText("");
        panel.getLblIzabranStudent().setText("");

        panel.getLblUputstvo().setText(Coordinator.getInstance().getMessage("participation_directions"));
        panel.getLblStudent().setText(Coordinator.getInstance().getMessage("lbl_menu_student"));
        panel.getLblPretraga().setText(Coordinator.getInstance().getMessage("lbl_student_search"));

        panel.getBtnPretrazi().setText(Coordinator.getInstance().getMessage("btn_search"));
        panel.getBtnSacuvaj().setText(Coordinator.getInstance().getMessage("btn_save"));

        try {
            panel.getTxtBrojIndeksaPretraga().setFormatterFactory(
                    new DefaultFormatterFactory(
                            new MaskFormatter("####/####")));

            List<Eksperiment> listaEksperimenanta = new ArrayList<>();

            if (KontrolerAL.getInstance().ucitajListuEksperimenata(listaEksperimenanta)) {
                panel.getCbEksperiment().setModel(new DefaultComboBoxModel<>(listaEksperimenanta.toArray()));
            } else {
                throw new Exception();
            }

        } catch (Exception ex) {
             JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("connection_failed"));
            Coordinator.getInstance().closeMainFrame();
        }
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
                    if (!KontrolerAL.getInstance().pretraziStudenta(student)) {
                        throw new Exception();
                    }

                    if (student == null) {
                        throw new Exception();

                    } else {
                        panel.getLblErrorPretraga().setText("");
                        panel.getLblIzabranStudent().setText(student.getBrojIndeksa() + " " + student.getIme() + " " + student.getPrezime());

                    }
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_found"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_not_found"));
                }
            }
        });

        panel.getBtnSacuvaj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (student == null) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_not_found"));
                    return;
                }

                Eksperiment eks = (Eksperiment) panel.getCbEksperiment().getModel().getSelectedItem();

                try {

                    SE ucesce = new SE(student, eks);
                    if (!KontrolerAL.getInstance().zapamtiUcesce(ucesce)) {
                        throw new Exception();
                    }

                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("participation_saved"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("participation_not_saved"));
                }
            }
        });
    }

    private String proveraBrojaIndeksa(String brojIndeksa) {
        try {
            if (brojIndeksa.length() != 9) {
                throw new NumberFormatException();
            }
            String godUpisaS = brojIndeksa.substring(0, 4);

            String brS = brojIndeksa.substring(5, 9);

            int god = Integer.parseInt(godUpisaS);

            if (god < 1990) {
                throw new NumberFormatException();
            }
            int br = Integer.parseInt(brS);

            if (br < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException pe) {
            return Coordinator.getInstance().getMessage("student_id_input_incorrect");
        }
        panel.getLblErrorPretraga().setText("");
        return "OK";
    }

    public UcesceStudentaPanel getPanel() {
        return panel;
    }

}
