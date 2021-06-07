package rs.ac.bg.fon.ai.npclient.view.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EksperimentatorPanel extends javax.swing.JPanel {

    public EksperimentatorPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblErrorIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        lblErrorPrezime = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(400, 202));
        setPreferredSize(new java.awt.Dimension(400, 202));

        lblIme.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblIme.setText("Ime:");

        lblErrorIme.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorIme.setText("error");

        lblPrezime.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblPrezime.setText("Prezime:");

        lblErrorPrezime.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorPrezime.setText("error");

        btnSacuvaj.setText("Sacuvaj");

        btnKreiraj.setText("Kreiraj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblIme)
                                .addComponent(lblPrezime))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblErrorIme)
                                .addComponent(lblErrorPrezime)
                                .addComponent(txtPrezime)
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(219, 219, 219)
                            .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(btnKreiraj)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorIme)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorPrezime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public JLabel getLblErrorIme() {
        return lblErrorIme;
    }

    public JLabel getLblErrorPrezime() {
        return lblErrorPrezime;
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

    public JLabel getLblIme() {
        return lblIme;
    }

    public JLabel getLblPrezime() {
        return lblPrezime;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel lblErrorIme;
    private javax.swing.JLabel lblErrorPrezime;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables
}
