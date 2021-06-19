package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npcommon.domain.Eksperiment;
import rs.ac.bg.fon.ai.npcommon.domain.RasporedEksperimenata;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.RasporedEksperimenataPanel;
import rs.ac.bg.fon.ai.npclient.view.util.EksperimentTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class RasporedEksperimenataController {

    private RasporedEksperimenata raspored;
    private final RasporedEksperimenataPanel panel;

    public RasporedEksperimenataController() {
        panel = new RasporedEksperimenataPanel();
        prepareView();
        addListeners();
        panel.setVisible(true);
    }

    private void prepareView() {
        panel.getTblRasporedEksperimenata().setModel(new EksperimentTableModel());
        panel.getBtnKreirajR().setText(Coordinator.getInstance().getMessage("btn_create"));
        panel.getLblDatumOd().setText(Coordinator.getInstance().getMessage("lbl_schedule_from"));
        panel.getLblDtumDo().setText(Coordinator.getInstance().getMessage("lbl_schedule_to"));

        try {
             panel.getTxtDatumOd().setFormatterFactory(
                    new DefaultFormatterFactory(
                            new MaskFormatter("##-##-####")));
              panel.getTxtDatumDo().setFormatterFactory(
                    new DefaultFormatterFactory(
                            new MaskFormatter("##-##-####")));
        } catch (ParseException e) {
             JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("prepare_form_failed"));
        }
        
        try {
            if (!KontrolerAL.getInstance().ucitajListuEksperimenata(new ArrayList<Eksperiment>())) {
                throw new Exception();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("connection_failed"));
            Coordinator.getInstance().closeMainFrame();
        }
    }

    private void addListeners() {
        panel.getBtnKreirajR().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String datOdS = panel.getTxtDatumOd().getText();

                String dOd = datOdS.substring(6, 10) + "-" + datOdS.substring(3, 5) + "-" + datOdS.substring(0, 2);

                Date datumOd = Date.valueOf(dOd);
                
                String datDoS = panel.getTxtDatumDo().getText();

                String dDo = datDoS.substring(6, 10) + "-" + datDoS.substring(3, 5) + "-" + datDoS.substring(0, 2);

                Date datumDo = Date.valueOf(dDo);

                if (datumDo.before(datumOd) || datumOd.equals(datumDo)) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("schedule_date_input_incorrect"));
                    return;
                }
                raspored = new RasporedEksperimenata(0l, datumOd, datumDo);
                try {
                    List<Eksperiment> eksperimentiURasporedu = new ArrayList<>();
                    if (!KontrolerAL.getInstance().zapamtiRasporedEksperimenata(raspored, eksperimentiURasporedu)) {
                        throw new Exception();
                    }
                    ((EksperimentTableModel) panel.getTblRasporedEksperimenata().getModel()).setEksperimenti(eksperimentiURasporedu);
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("schedule_saved"));

                } catch (Exception ex) {
                    ((EksperimentTableModel) panel.getTblRasporedEksperimenata().getModel()).setEksperimenti(new ArrayList<Eksperiment>());
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("schedule_not_saved"));
                }
            }
        });
    }

    public RasporedEksperimenataPanel getPanel() {
        return panel;
    }
}
