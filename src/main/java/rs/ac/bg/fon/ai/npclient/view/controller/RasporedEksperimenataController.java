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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

//                Calendar calendar = panel.getdCDtumOd().getSelectedDate();
                Date datumOd = new Date(panel.getdCDtumOd().getDate().getTime());
//
//                calendar = panel.getdCDtumDo().getSelectedDate();
//
//                Date datumDo = new Date(calendar.getTimeInMillis());

                Date datumDo = new Date(panel.getdCDtumDo().getDate().getTime());

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
