package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npcommon.domain.Eksperiment;
import rs.ac.bg.fon.ai.npcommon.domain.Eksperimentator;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.panels.EksperimentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class EksperimentController {

    private Eksperiment eksperiment;
    private final EksperimentPanel panel;

    public EksperimentController() {
        eksperiment = new Eksperiment();
        panel = new EksperimentPanel();
        if (!prepareView()) {
            return;
        }
        addListeners();
        panel.setVisible(true);
    }

    public boolean prepareView() {
        clearAllErrorLabels();

        panel.getBtnSacuvaj().setEnabled(false);
        panel.getBtnObrisi().setEnabled(false);

        panel.getBtnPretrazi().setText(Coordinator.getInstance().getMessage("btn_search"));
        panel.getBtnKreiraj().setText(Coordinator.getInstance().getMessage("btn_create"));
        panel.getBtnSacuvaj().setText(Coordinator.getInstance().getMessage("btn_save"));
        panel.getBtnObrisi().setText(Coordinator.getInstance().getMessage("btn_delete"));

        panel.getLblEksperimentator().setText(Coordinator.getInstance().getMessage("lbl_experimenter"));
        panel.getLblNaziv().setText(Coordinator.getInstance().getMessage("lbl_experiment_name"));
        panel.getLblDatumOdrzavanja().setText(Coordinator.getInstance().getMessage("lbl_experiment_date"));
        panel.getLblBodovi().setText(Coordinator.getInstance().getMessage("lbl_experiment_points"));
        panel.getLblPretraga().setText(Coordinator.getInstance().getMessage("lbl_experiment_search"));

        try {
            panel.getTxtDatum().setFormatterFactory(
                    new DefaultFormatterFactory(
                            new MaskFormatter("##-##-####")));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("prepare_form_failed"));
            Coordinator.getInstance().closeMainFrame();
            return false;
        }

        try {
            List<Eksperimentator> listaEksperimentatora = new ArrayList<>();

            if (KontrolerAL.getInstance().ucitajListuEksperimentatora(listaEksperimentatora)) {
                panel.getCbEksperimentator().setModel(new DefaultComboBoxModel<>(listaEksperimentatora.toArray()));
            } else {
                throw new Exception();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("connection_failed"));
            Coordinator.getInstance().closeMainFrame();
            return false;
        }
        return true;
    }

    public void clearAllErrorLabels() {
        panel.getLblErrorPretraga().setText("");
        panel.getLblErrorNaziv().setText("");
        panel.getLblErrorBodovi().setText("");
        panel.getLblErrorDatumOdrzavanja().setText("");
    }

    public void clearAllTxtFields() {
        panel.getTxtNaziv().setText("");
        panel.getTxtBodovi().setText("");
    }

    public void addListeners() {
        panel.getBtnPretrazi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String sifraUnos = panel.getTxtSifraEksperimenta().getText().trim();

                String porukaIspravnostSifraEks = proveriSifruEksperimenta(sifraUnos);

                if (!porukaIspravnostSifraEks.equals("OK")) {
                    panel.getLblErrorPretraga().setText(porukaIspravnostSifraEks);
                    return;
                }
                panel.getLblErrorPretraga().setText("");

                Long sifra = Long.parseLong(sifraUnos);

                eksperiment = new Eksperiment(sifra);

                try {
                    if (!KontrolerAL.getInstance().pretraziEksperiment(eksperiment)) {
                        throw new Exception();
                    }

                    if (eksperiment == null) {
                        throw new Exception();
                    } else {
                        panel.getBtnSacuvaj().setEnabled(true);
                        panel.getLblErrorPretraga().setText("");
                        panel.getTxtNaziv().setText(eksperiment.getNaziv());

                        panel.getTxtBodovi().setText(String.valueOf(eksperiment.getBodovi()));
                        if (eksperiment.getDatumOdrzavanja() != null) {
                            panel.getTxtDatum().setText(df.format(eksperiment.getDatumOdrzavanja()));

                        }
                        if (eksperiment.getEksperimenatator().getIme() == null) {
                            panel.getCbEksperimentator().setSelectedIndex(-1);

                        } else {
                            panel.getCbEksperimentator().setSelectedItem(eksperiment.getEksperimenatator());
                        }
                        panel.getBtnObrisi().setEnabled(true);
                        panel.getBtnSacuvaj().setEnabled(true);
                        JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experiment_found"));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experiment_not_found"));
                }
            }
        });

        panel.getBtnKreiraj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eksperiment = new Eksperiment();

                    if (!KontrolerAL.getInstance().kreirajEksperiment(eksperiment)) {
                        throw new Exception();
                    }
                    clearAllErrorLabels();
                    panel.getBtnPretrazi().setEnabled(false);
                    panel.getBtnKreiraj().setEnabled(false);
                    panel.getBtnObrisi().setEnabled(true);
                    panel.getBtnSacuvaj().setEnabled(true);
                    clearAllTxtFields();
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experiment_created"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experiment_not_created"));
                }
            }
        });

        panel.getBtnSacuvaj().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = panel.getTxtNaziv().getText().trim();
                String bodoviUneti = panel.getTxtBodovi().getText().trim();
                String datS = panel.getTxtDatum().getText();

                
                String d = datS.substring(6,10) + "-" + datS.substring(3,5) + "-" +datS.substring(0,2);

                Date datum = Date.valueOf(d);

                if (!proveriUnos(naziv, bodoviUneti)) {
                    return;
                }

                int bodovi = Integer.parseInt(bodoviUneti);
                Eksperimentator eksperimentator = (Eksperimentator) panel.getCbEksperimentator().getModel().getSelectedItem();
                eksperiment = new Eksperiment(eksperiment.getSifra(), naziv, datum, bodovi, eksperimentator, null);

                try {
                    if (!KontrolerAL.getInstance().zapamtiEksperiment(eksperiment) || eksperiment.getSifra() == 0l) {
                        throw new Exception();
                    }
                    panel.getBtnPretrazi().setEnabled(true);
                    panel.getBtnKreiraj().setEnabled(true);
                    panel.getBtnSacuvaj().setEnabled(true);
                    panel.getBtnObrisi().setEnabled(true);
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experiment_saved"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experiment_not_saved"));
                }
            }

            private boolean proveriUnos(String naziv, String bodoviUneti) {
                if (naziv.equals("")) {
                    panel.getLblErrorNaziv().setText("Niste uneli naziv");
                    return false;
                }
                if (bodoviUneti.equals("")) {
                    panel.getLblErrorBodovi().setText("Niste uneli bodove");
                    return false;
                }
                try {
                    int bod = Integer.parseInt(bodoviUneti);
                    if (bod < 1) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    panel.getLblErrorBodovi().setText("Niste ispravno uneli bodove");
                    return false;
                }
                clearAllErrorLabels();
                return true;
            }
        });

        panel.getBtnObrisi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (!KontrolerAL.getInstance().obrisiEksperiment(eksperiment)) {
                        throw new Exception();
                    }
                    panel.getBtnObrisi().setEnabled(false);
                    panel.getBtnPretrazi().setEnabled(true);
                    panel.getBtnKreiraj().setEnabled(true);
                    panel.getBtnSacuvaj().setEnabled(false);
                    clearAllTxtFields();
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experiment_deleted"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, Coordinator.getInstance().getMessage("experiment_not_deleted"));
                }
            }
        });
    }

    public EksperimentPanel getPanel() {
        return panel;
    }

    private String proveriSifruEksperimenta(String sifra) {
        Long sifraLong = 0l;
        try {
            sifraLong = Long.parseLong(sifra);
            if (sifraLong < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            return Coordinator.getInstance().getMessage("experiment_id_input_incorrect");
        }
        return "OK";
    }
}
