package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.MainFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class MainController {
    
    MainFrame frame;

    public MainController() {
        frame = new MainFrame();
        prepareView();
        addListeners();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void prepareView(){
        frame.setSize(400, 400);
        
        frame.getMenuStudent().setText(Coordinator.getInstance().getMessage("lbl_menu_student"));
        frame.getMenuEksperiment().setText(Coordinator.getInstance().getMessage("lbl_menu_experiment"));
        
        frame.getmIStudent().setText(Coordinator.getInstance().getMessage("lbl_menu_student"));
        frame.getmIListaStudenata().setText(Coordinator.getInstance().getMessage("lbl_menu_student_list"));
        frame.getmIUcesce().setText(Coordinator.getInstance().getMessage("lbl_menu_participation"));
        
        frame.getmIEksperiment().setText(Coordinator.getInstance().getMessage("lbl_menu_experiment"));
        frame.getmIEksperimentator().setText(Coordinator.getInstance().getMessage("lbl_menu_experimenter"));
        frame.getmIRasporedEksperimenata().setText(Coordinator.getInstance().getMessage("lbl_menu_experiment_schedule"));
    }
    
    public void addListeners(){
        frame.getmIEksperiment().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EksperimentController cntrl = Coordinator.getInstance().openAddEksperiment();
                addPanel(cntrl.getPanel());
            }
        });
        frame.getmIEksperimentator().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EksperimentatorController cntrl = Coordinator.getInstance().openAddEksperimentator();
                addPanel(cntrl.getPanel());
            }
        });
        frame.getmIStudent().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentController cntrl = Coordinator.getInstance().openAddStudenta();
                addPanel(cntrl.getPanel());
            }
        });
        frame.getmIUcesce().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UcesceStudentaController cntrl = Coordinator.getInstance().openPromeniStudenta();
                addPanel(cntrl.getPanel());
            }
        });
        frame.getmIListaStudenata().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaStudentController cntrl = Coordinator.getInstance().openListaStudenata();
                addPanel(cntrl.getPanel());
            }
        });
        frame.getmIRasporedEksperimenata().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RasporedEksperimenataController cntrl = Coordinator.getInstance().openRasporedEksperimenata();
                addPanel(cntrl.getPanel());
            }
        });
        frame.getMiSU().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentiNaEksperimentuController cntrl = Coordinator.getInstance().openUcNaEksperimentu();
                addPanel(cntrl.getPanel());
            }
        });
    }
    
    public void addPanel(JPanel panel){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        frame.pack();
    }

    public MainFrame getFrame() {
        return frame;
    }
}
