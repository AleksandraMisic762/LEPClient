package rs.ac.bg.fon.ai.npclient.view.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.IzvestajUcescaNaEksperimentuPanel;
import rs.ac.bg.fon.ai.npcommon.domain.Eksperiment;
import rs.ac.bg.fon.ai.npcommon.domain.Student;

public class IzvestajUcescaNaEksperimentuController {

    Gson gson;
    private final IzvestajUcescaNaEksperimentuPanel panel;

    public IzvestajUcescaNaEksperimentuController() {
        this.panel = new IzvestajUcescaNaEksperimentuPanel();
        gson = new GsonBuilder().setPrettyPrinting().create();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    private void prepareView() {
        panel.getBtnKreiraj().setText(Coordinator.getInstance().getMessage("btn_create"));

        try {
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
        panel.getBtnKreiraj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = panel.getTxtNazivFajla().getText().trim();
                Eksperiment eksperiment = (Eksperiment) panel.getCbEksperiment().getModel().getSelectedItem();

               List<Student> studenti = new ArrayList<>();
                try {
                    if (!KontrolerAL.getInstance().kreirajIzvestajUcescaNaEksperimentu(eksperiment, studenti)) {
                        throw new Exception();
                    }
                    FileWriter file;
                    if (naziv.isEmpty()) {
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        file = new FileWriter("izvestaji/" + "izvestaj_ucesca_na_eksperimentu_" + df.format(new Date(System.currentTimeMillis())) + ".json");
                    
                    } else {
                        file = new FileWriter("izvestaji/" + naziv + ".json");
                    }
                    gson.toJson(eksperiment,file);
                    gson.toJson(studenti, file);
                    file.flush();
                    panel.getTxtPrikazIzvestaja().setText(gson.toJson(studenti));
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_created"));
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_not_created"));
                }
            }
        });
    }

    public IzvestajUcescaNaEksperimentuPanel getPanel() {
        return panel;
    }
}
