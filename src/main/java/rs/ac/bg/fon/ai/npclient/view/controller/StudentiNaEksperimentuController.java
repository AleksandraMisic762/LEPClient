package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npcommon.domain.Eksperiment;
import rs.ac.bg.fon.ai.npcommon.domain.Student;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.StudentiNaEksperimentuPanel;
import rs.ac.bg.fon.ai.npclient.view.util.StudentTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class StudentiNaEksperimentuController {

    StudentiNaEksperimentuPanel panel;

    public StudentiNaEksperimentuController() {

        panel = new StudentiNaEksperimentuPanel();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    private void addListeners() {
        panel.getBtnIzaberite().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eksperiment eks = (Eksperiment) panel.getCbE1().getModel().getSelectedItem();

                try {
                    List<Student> sviS = new ArrayList<>();
                    if (!KontrolerAL.getInstance().vratiSvaUcesca(eks, sviS)) {
                        throw new Exception();
                    }
                    
                    ((StudentTableModel)panel.getTabelUcestvovali().getModel()).setList(sviS);

                    JOptionPane.showMessageDialog(panel, "Prikaz je uspeo");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel, "Prikaz nije uspeo");
                }
            }
        });
    }

    private void prepareView() {

        panel.getTabelUcestvovali().setModel(new StudentTableModel());

        try {
            List<Eksperiment> listaEksperimenanta = new ArrayList<>();

            if (KontrolerAL.getInstance().ucitajListuEksperimenata(listaEksperimenanta)) {
                panel.getCbE1().setModel(new DefaultComboBoxModel<>(listaEksperimenanta.toArray()));
            } else {
                throw new Exception();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("connection_failed"));
            Coordinator.getInstance().closeMainFrame();
        }
    }

    public StudentiNaEksperimentuPanel getPanel() {
        return panel;
    }

}
