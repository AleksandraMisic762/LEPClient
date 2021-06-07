package rs.ac.bg.fon.ai.npclient.view.panels;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentPanel extends javax.swing.JPanel {

    public StudentPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKreiraj = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblPredmet = new javax.swing.JLabel();
        cbPredmet = new javax.swing.JComboBox<>();
        lblBrojIndeksa = new javax.swing.JLabel();
        txtBrojIndeksa = new javax.swing.JFormattedTextField();
        lblErrorBrojIndeksa = new javax.swing.JLabel();
        lblIme = new javax.swing.JLabel();
        lblErrorIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        lblErrorPrezime = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblPretraga = new javax.swing.JLabel();
        lblErrorPretraga = new javax.swing.JLabel();
        txtBrojIndeksaPretraga = new javax.swing.JFormattedTextField();
        btnPretrazi = new javax.swing.JButton();

        btnKreiraj.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnKreiraj.setText("Kreiraj");

        btnSacuvaj.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnSacuvaj.setText("Sačuvaj");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student"));

        lblPredmet.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblPredmet.setText("Predmet:");

        cbPredmet.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        lblBrojIndeksa.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblBrojIndeksa.setText("Broj indeksa:");

        lblErrorBrojIndeksa.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorBrojIndeksa.setText("error");

        lblIme.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblIme.setText("Ime:");

        lblErrorIme.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorIme.setText("error");

        lblPrezime.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblPrezime.setText("Prezime:");

        lblErrorPrezime.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorPrezime.setText("error");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBrojIndeksa)
                    .addComponent(lblIme)
                    .addComponent(lblPrezime)
                    .addComponent(lblPredmet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblErrorBrojIndeksa)
                    .addComponent(lblErrorIme)
                    .addComponent(lblErrorPrezime)
                    .addComponent(txtIme)
                    .addComponent(txtPrezime)
                    .addComponent(txtBrojIndeksa)
                    .addComponent(cbPredmet, 0, 344, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojIndeksa)
                    .addComponent(txtBrojIndeksa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorBrojIndeksa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIme)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorIme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorPrezime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPredmet)
                    .addComponent(cbPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pretraga"));

        lblPretraga.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblPretraga.setText("Pretraga po broju indeksa:");

        lblErrorPretraga.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorPretraga.setText("error");

        btnPretrazi.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnPretrazi.setText("Pretraži");
        btnPretrazi.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPretraga)
                        .addContainerGap(179, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBrojIndeksaPretraga)
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
                .addGap(18, 18, 18)
                .addComponent(txtBrojIndeksaPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorPretraga)
                .addGap(11, 11, 11)
                .addComponent(btnPretrazi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnKreiraj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cbPredmet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBrojIndeksa;
    private javax.swing.JLabel lblErrorBrojIndeksa;
    private javax.swing.JLabel lblErrorIme;
    private javax.swing.JLabel lblErrorPretraga;
    private javax.swing.JLabel lblErrorPrezime;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPredmet;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JFormattedTextField txtBrojIndeksa;
    private javax.swing.JFormattedTextField txtBrojIndeksaPretraga;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public JComboBox<Object> getCbPredmet() {
        return cbPredmet;
    }

    public JLabel getLblBrojIndeksa() {
        return lblBrojIndeksa;
    }

    public JLabel getLblErrorBrojIndeksa() {
        return lblErrorBrojIndeksa;
    }

    public JLabel getLblErrorIme() {
        return lblErrorIme;
    }

    public JLabel getLblErrorPrezime() {
        return lblErrorPrezime;
    }

    public JLabel getLblIme() {
        return lblIme;
    }

    public JLabel getLblPredmet() {
        return lblPredmet;
    }

    public JLabel getLblPrezime() {
        return lblPrezime;
    }

    public JFormattedTextField getTxtBrojIndeksa() {
        return txtBrojIndeksa;
    }

    public JTextField getTxtIme() {
        return txtIme;
    }

    public JTextField getTxtPrezime() {
        return txtPrezime;
    }

    public JButton getBtnKreiraj() {
        return btnKreiraj;
    }

    public JButton getBtnPretrazi() {
        return btnPretrazi;
    }

    public JLabel getLblErrorPretraga() {
        return lblErrorPretraga;
    }

    public JFormattedTextField getTxtBrojIndeksaPretraga() {
        return txtBrojIndeksaPretraga;
    }

    public JLabel getLblPretraga() {
        return lblPretraga;
    }
    
    
}
