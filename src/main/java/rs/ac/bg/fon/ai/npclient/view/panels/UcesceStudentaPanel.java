package rs.ac.bg.fon.ai.npclient.view.panels;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class UcesceStudentaPanel extends javax.swing.JPanel {

    public UcesceStudentaPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblPretraga = new javax.swing.JLabel();
        lblErrorPretraga = new javax.swing.JLabel();
        txtBrojIndeksaPretraga = new javax.swing.JFormattedTextField();
        btnPretrazi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblStudent = new javax.swing.JLabel();
        lblIzabranStudent = new javax.swing.JLabel();
        lblUputstvo = new javax.swing.JLabel();
        cbEksperiment = new javax.swing.JComboBox<>();
        btnSacuvaj = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pretraga"));

        lblPretraga.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblPretraga.setText("Pretraga po broju indeksa:");

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Učešće u ekperimentu"));

        lblStudent.setText("Student:");

        lblIzabranStudent.setText("jLabel1");

        lblUputstvo.setText("Izaberite eksperiment u kom je student učestvovao:");

        btnSacuvaj.setText("Sačuvaj");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblStudent)
                            .addGap(18, 18, 18)
                            .addComponent(lblIzabranStudent))
                        .addComponent(lblUputstvo)
                        .addComponent(cbEksperiment, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudent)
                    .addComponent(lblIzabranStudent))
                .addGap(18, 18, 18)
                .addComponent(lblUputstvo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbEksperiment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public JButton getBtnPretrazi() {
        return btnPretrazi;
    }

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public JComboBox<Object> getCbEksperiment() {
        return cbEksperiment;
    }

    public JLabel getLblErrorPretraga() {
        return lblErrorPretraga;
    }

    public JLabel getLblIzabranStudent() {
        return lblIzabranStudent;
    }

    public JLabel getLblPretraga() {
        return lblPretraga;
    }

    public JLabel getLblStudent() {
        return lblStudent;
    }

    public JLabel getLblUputstvo() {
        return lblUputstvo;
    }

   

    public JFormattedTextField getTxtBrojIndeksaPretraga() {
        return txtBrojIndeksaPretraga;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cbEksperiment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblErrorPretraga;
    private javax.swing.JLabel lblIzabranStudent;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblUputstvo;
    private javax.swing.JFormattedTextField txtBrojIndeksaPretraga;
    // End of variables declaration//GEN-END:variables
}
