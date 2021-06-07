package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npcommon.domain.ListaStudenata;
import rs.ac.bg.fon.ai.npcommon.domain.Predmet;
import rs.ac.bg.fon.ai.npcommon.domain.Student;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.ListaStudenataPanel;
import rs.ac.bg.fon.ai.npclient.view.util.StudentTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ListaStudentController {

    ListaStudenata lista;

    private final ListaStudenataPanel panel;
    List<Student> studenti;

    public ListaStudentController() {
        studenti = new ArrayList<>();
        lista = new ListaStudenata();
        panel = new ListaStudenataPanel();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    private void prepareView() {
        panel.getTabelaStudenti().setModel(new StudentTableModel());
        panel.getBtnZapamti().setEnabled(false);
        
        panel.getLblPredmet().setText(Coordinator.getInstance().getMessage("lbl_student_subject"));
        panel.getLblRok().setText(Coordinator.getInstance().getMessage("lbl_rok"));

        panel.getBtnKreiraj().setText(Coordinator.getInstance().getMessage("btn_create"));
        panel.getBtnZapamti().setText(Coordinator.getInstance().getMessage("btn_save"));
        
        try {
            List<Predmet> listaPredmeta = new ArrayList<>();
            if (KontrolerAL.getInstance().ucitajListuPredmeta(listaPredmeta)) {
                panel.getCbPredmet().setModel(new DefaultComboBoxModel<>(listaPredmeta.toArray()));
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("connection_failed"));
            Coordinator.getInstance().closeMainFrame();
        }
    }

    private void addListeners() {
        panel.getBtnKreiraj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rok = (String) panel.getCbRok().getModel().getSelectedItem();
                Predmet predmet = (Predmet) panel.getCbPredmet().getModel().getSelectedItem();

                studenti = new ArrayList<>();
                lista = new ListaStudenata(0l, rok, predmet);
                try {
                    if (!KontrolerAL.getInstance().ucitajListuStudenataSaUslovom(lista, studenti)) {
                        throw new Exception();
                    }
                    ((StudentTableModel) panel.getTabelaStudenti().getModel()).setList(studenti);
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_created"));
                    panel.getBtnZapamti().setEnabled(true);
                    } catch (Exception ex) {

                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_not_created"));
                }
            }
        });

        panel.getBtnZapamti().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Map<String, Object> mapa = new HashMap<String, Object>();

                    mapa.put("Lista", lista);
                    mapa.put("Studenti", studenti);

                    if (!KontrolerAL.getInstance().zapamtiListuStudenata(mapa)) {
                        throw new Exception();
                    }
                    lista = (ListaStudenata) mapa.get("Lista");
                    if (lista == null) {
                        throw new Exception();
                    }
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_saved"));
                    panel.getBtnZapamti().setEnabled(false);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_not_saved"));
                }
            }
        });
    }

    public ListaStudenataPanel getPanel() {
        return panel;
    }
}
