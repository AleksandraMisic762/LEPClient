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
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.IzvestajSprovedeniEksperimentiPanel;
import rs.ac.bg.fon.ai.npcommon.domain.Eksperiment;

public class IzvestajSprovedeniEksperimentiController {

    Gson gson;
    private final IzvestajSprovedeniEksperimentiPanel panel;

    public IzvestajSprovedeniEksperimentiController() {
        this.panel = new IzvestajSprovedeniEksperimentiPanel();
        gson = new GsonBuilder().setPrettyPrinting().create();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    private void prepareView() {
        panel.getBtnKreiraj().setText(Coordinator.getInstance().getMessage("btn_create"));
    }

    private void addListeners() {
        panel.getBtnKreiraj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = panel.getTxtNazivFajla().getText().trim();
                
               List<Eksperiment> eksperimenti = new ArrayList<>();
                try {
                    if (!KontrolerAL.getInstance().kreirajIzvestajSprovedenihEksperimenata(eksperimenti)) {
                        throw new Exception();
                    }
                    FileWriter file;
                    if (naziv.isEmpty()) {
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        file = new FileWriter("izvestaji/" + "izvestaj_sprovedeni_eksperimenti_" + df.format(new Date(System.currentTimeMillis())) + ".json");
                    
                    } else {
                        file = new FileWriter("izvestaji/" + naziv + ".json");
                    }
                    gson.toJson(eksperimenti, file);
                    file.flush();
                    file.close();
                    panel.getTxtPrikazIzvestaja().setText(gson.toJson(eksperimenti));
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_created"));
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_not_created"));
                }
            }
        });
    }

    public IzvestajSprovedeniEksperimentiPanel getPanel() {
        return panel;
    }
}
