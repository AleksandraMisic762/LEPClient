package rs.ac.bg.fon.ai.npclient.view.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

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
import rs.ac.bg.fon.ai.npclient.view.panels.IzvestajStudentiSaUslovomPanel;
import rs.ac.bg.fon.ai.npcommon.domain.Predmet;
import rs.ac.bg.fon.ai.npcommon.domain.Student;

public class IzvestajStudentiSaUslovomController {

    Gson gson;
    private final IzvestajStudentiSaUslovomPanel panel;

    public IzvestajStudentiSaUslovomController() {
        this.panel = new IzvestajStudentiSaUslovomPanel();
        gson = new GsonBuilder().setPrettyPrinting().create();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    private void prepareView() {
        panel.getBtnKreiraj().setText(Coordinator.getInstance().getMessage("btn_create"));

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
                String naziv = panel.getTxtNazivFajla().getText().trim();
                Predmet predmet = (Predmet) panel.getCbPredmet().getModel().getSelectedItem();

               List<Student> studenti = new ArrayList<>();
                try {
                    if (!KontrolerAL.getInstance().kreirajIzvestajStudenataSaUslovom(predmet, studenti)) {
                        throw new Exception();
                    }
                    FileWriter file;
                    if (naziv.isEmpty()) {
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
                        file = new FileWriter("izvestaji/" + "izvestaj_studenti_sa_uslovom_" + df.format(new Date(System.currentTimeMillis())) + ".json");
                    
                    } else {
                        file = new FileWriter("izvestaji/" + naziv + ".json");
                    }
                    JsonObject obj = new JsonObject();
                    obj.add("predmet", gson.toJsonTree(predmet, Predmet.class));
                    obj.add("studenti", gson.toJsonTree(studenti, new TypeToken<ArrayList<Student>>() {}.getType()));
                    gson.toJson(obj, file);
                    file.flush();
                    file.close();
                    panel.getTxtPrikazIzvestaja().setText(gson.toJson(studenti));
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_created"));
                } catch (Exception ex) {
                	ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("student_list_not_created"));
                }
            }
        });
    }

    public IzvestajStudentiSaUslovomPanel getPanel() {
        return panel;
    }
}
