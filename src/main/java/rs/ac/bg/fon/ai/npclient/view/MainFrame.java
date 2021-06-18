package rs.ac.bg.fon.ai.npclient.view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuStudent = new javax.swing.JMenu();
        mIStudent = new javax.swing.JMenuItem();
        mIListaStudenata = new javax.swing.JMenuItem();
        mIUcesce = new javax.swing.JMenuItem();
        menuEksperiment = new javax.swing.JMenu();
        mIEksperiment = new javax.swing.JMenuItem();
        mIEksperimentator = new javax.swing.JMenuItem();
        mIRasporedEksperimenata = new javax.swing.JMenuItem();
        miSU = new javax.swing.JMenuItem();
        menuIzvestaj = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mIIzvestajUcescaNaEksperimentu = new javax.swing.JMenuItem();
        mIIzvestajSprovedeniEksperiment = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Klijent program");

        menuStudent.setText("Student");

        mIStudent.setText("Student");
        menuStudent.add(mIStudent);

        mIListaStudenata.setText("Lista studenata");
        menuStudent.add(mIListaStudenata);

        mIUcesce.setText("Učešće");
        menuStudent.add(mIUcesce);

        jMenuBar1.add(menuStudent);

        menuEksperiment.setText("Eksperiment");

        mIEksperiment.setText("Eksperiment");
        menuEksperiment.add(mIEksperiment);

        mIEksperimentator.setText("Eksperimentator");
        menuEksperiment.add(mIEksperimentator);

        mIRasporedEksperimenata.setText("Raspored eksperimenata");
        menuEksperiment.add(mIRasporedEksperimenata);

        miSU.setText("Sva učešća");
        menuEksperiment.add(miSU);

        jMenuBar1.add(menuEksperiment);

        menuIzvestaj.setText("Izveštaj");

        jMenuItem1.setText("Studenti uslov");
        menuIzvestaj.add(jMenuItem1);

        mIIzvestajUcescaNaEksperimentu.setText("Ucesca studenata");
        menuIzvestaj.add(mIIzvestajUcescaNaEksperimentu);

        mIIzvestajSprovedeniEksperiment.setText("Sprovedeni eksperimenti");
        menuIzvestaj.add(mIIzvestajSprovedeniEksperiment);

        jMenuBar1.add(menuIzvestaj);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JMenuItem getmIEksperiment() {
        return mIEksperiment;
    }

    public JMenuItem getmIEksperimentator() {
        return mIEksperimentator;
    }

    public JMenuItem getmIListaStudenata() {
        return mIListaStudenata;
    }

    public JMenuItem getmIStudent() {
        return mIStudent;
    }

    public JMenuItem getmIRasporedEksperimenata() {
        return mIRasporedEksperimenata;
    }

    public JMenuItem getmIUcesce() {
        return mIUcesce;
    }

    public JMenu getMenuEksperiment() {
        return menuEksperiment;
    }

    public JMenu getMenuStudent() {
        return menuStudent;
    }

    public JMenuItem getMiSU() {
        return miSU;
    }

    public JMenuItem getMIIzvestajStudentiSaUslovom() {
        return jMenuItem1;
    }

    public JMenuItem getMIIzvestajUcesca() {
        return mIIzvestajUcescaNaEksperimentu;
    }

    public JMenuItem getMIIzvestajSprovedniEksperimenti(){
        return mIIzvestajSprovedeniEksperiment;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mIEksperiment;
    private javax.swing.JMenuItem mIEksperimentator;
    private javax.swing.JMenuItem mIIzvestajSprovedeniEksperiment;
    private javax.swing.JMenuItem mIIzvestajUcescaNaEksperimentu;
    private javax.swing.JMenuItem mIListaStudenata;
    private javax.swing.JMenuItem mIRasporedEksperimenata;
    private javax.swing.JMenuItem mIStudent;
    private javax.swing.JMenuItem mIUcesce;
    private javax.swing.JMenu menuEksperiment;
    private javax.swing.JMenu menuIzvestaj;
    private javax.swing.JMenu menuStudent;
    private javax.swing.JMenuItem miSU;
    // End of variables declaration//GEN-END:variables
}
