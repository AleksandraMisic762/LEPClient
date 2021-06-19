package rs.ac.bg.fon.ai.npclient.view.panels;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EksperimentPanel extends javax.swing.JPanel {

    public EksperimentPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblErrorNaziv = new javax.swing.JLabel();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblDatumOdrzavanja = new javax.swing.JLabel();
        lblBodovi = new javax.swing.JLabel();
        txtBodovi = new javax.swing.JTextField();
        lblErrorBodovi = new javax.swing.JLabel();
        lblErrorDatumOdrzavanja = new javax.swing.JLabel();
        lblEksperimentator = new javax.swing.JLabel();
        cbEksperimentator = new javax.swing.JComboBox<>();
        txtDatum = new javax.swing.JFormattedTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblPretraga = new javax.swing.JLabel();
        lblErrorPretraga = new javax.swing.JLabel();
        btnPretrazi = new javax.swing.JButton();
        txtSifraEksperimenta = new javax.swing.JTextField();
        btnObrisi = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(880, 300));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(880, 300));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Eksperiment"));

        lblErrorNaziv.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNaziv.setText("error");

        lblNaziv.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblNaziv.setText("Naziv:");

        lblDatumOdrzavanja.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblDatumOdrzavanja.setText("Datum odrzavanja:");

        lblBodovi.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblBodovi.setText("Bodovi:");

        lblErrorBodovi.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorBodovi.setText("error");

        lblErrorDatumOdrzavanja.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorDatumOdrzavanja.setText("error");

        lblEksperimentator.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblEksperimentator.setText("Eksperimentator:");

        cbEksperimentator.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNaziv)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblErrorNaziv)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNaziv)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEksperimentator)
                        .addGap(18, 18, 18)
                        .addComponent(cbEksperimentator, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorDatumOdrzavanja)
                            .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBodovi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorBodovi)
                            .addComponent(lblBodovi))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDatumOdrzavanja)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNaziv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorNaziv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBodovi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDatumOdrzavanja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBodovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrorDatumOdrzavanja)
                    .addComponent(lblErrorBodovi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEksperimentator)
                    .addComponent(cbEksperimentator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSacuvaj.setText("Sacuvaj");

        btnKreiraj.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnKreiraj.setText("Kreiraj");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pretraga"));

        lblPretraga.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblPretraga.setText("Pretraga po šifri eksperimenta:");

        lblErrorPretraga.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorPretraga.setText("error");

        btnPretrazi.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnPretrazi.setText("Pretraži");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPretraga)
                        .addContainerGap(156, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSifraEksperimenta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblErrorPretraga)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblPretraga)
                .addGap(12, 12, 12)
                .addComponent(txtSifraEksperimenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblErrorPretraga)
                .addGap(11, 11, 11)
                .addComponent(btnPretrazi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnObrisi.setText("Obriši");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKreiraj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnObrisi))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox<Object> getCbEksperimentator() {
        return cbEksperimentator;
    }

    public JLabel getLblErrorBodovi() {
        return lblErrorBodovi;
    }

    public JLabel getLblErrorDatumOdrzavanja() {
        return lblErrorDatumOdrzavanja;
    }

    public JLabel getLblErrorNaziv() {
        return lblErrorNaziv;
    }

    public JTextField getTxtBodovi() {
        return txtBodovi;
    }

    public JTextField getTxtNaziv() {
        return txtNaziv;
    }

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public JButton getBtnKreiraj() {
        return btnKreiraj;
    }

    public JButton getBtnObrisi() {
        return btnObrisi;
    }

    public JButton getBtnPretrazi() {
        return btnPretrazi;
    }

    public JLabel getLblErrorPretraga() {
        return lblErrorPretraga;
    }

    public JTextField getTxtSifraEksperimenta() {
        return txtSifraEksperimenta;
    }

    public JLabel getLblBodovi() {
        return lblBodovi;
    }

    public JLabel getLblDatumOdrzavanja() {
        return lblDatumOdrzavanja;
    }

    public JLabel getLblEksperimentator() {
        return lblEksperimentator;
    }

    public JLabel getLblNaziv() {
        return lblNaziv;
    }

    public JLabel getLblPretraga() {
        return lblPretraga;
    }

    public JFormattedTextField getTxtDatum() {
        return txtDatum;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cbEksperimentator;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBodovi;
    private javax.swing.JLabel lblDatumOdrzavanja;
    private javax.swing.JLabel lblEksperimentator;
    private javax.swing.JLabel lblErrorBodovi;
    private javax.swing.JLabel lblErrorDatumOdrzavanja;
    private javax.swing.JLabel lblErrorNaziv;
    private javax.swing.JLabel lblErrorPretraga;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JTextField txtBodovi;
    private javax.swing.JFormattedTextField txtDatum;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSifraEksperimenta;
    // End of variables declaration//GEN-END:variables
}
