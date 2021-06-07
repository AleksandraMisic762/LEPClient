package rs.ac.bg.fon.ai.npclient.view.panels;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

public class ListaStudenataPanel extends javax.swing.JPanel {

    public ListaStudenataPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRok = new javax.swing.JLabel();
        cbRok = new javax.swing.JComboBox<>();
        lblPredmet = new javax.swing.JLabel();
        cbPredmet = new javax.swing.JComboBox<>();
        btnKreiraj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaStudenti = new javax.swing.JTable();
        btnZapamti = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(30, 0));

        lblRok.setText("Izaberite rok:");

        cbRok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januar", "Februar", "Jun", "Jul", "Septembar", "Oktobar" }));

        lblPredmet.setText("Predmet:");

        btnKreiraj.setText("Kreiraj listu");

        tabelaStudenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaStudenti);

        btnZapamti.setText("Zapamti listu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRok)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbRok, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPredmet)
                                .addGap(54, 54, 54)
                                .addComponent(cbPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnZapamti, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRok)
                    .addComponent(cbRok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPredmet)
                    .addComponent(btnKreiraj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnZapamti)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnKreiraj() {
        return btnKreiraj;
    }

    public JButton getBtnZapamti() {
        return btnZapamti;
    }

    public JComboBox<Object> getCbPredmet() {
        return cbPredmet;
    }

    public JComboBox<String> getCbRok() {
        return cbRok;
    }

    public JTable getTabelaStudenti() {
        return tabelaStudenti;
    }

    public JLabel getLblPredmet() {
        return lblPredmet;
    }

    public JLabel getLblRok() {
        return lblRok;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnZapamti;
    private javax.swing.JComboBox<Object> cbPredmet;
    private javax.swing.JComboBox<String> cbRok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPredmet;
    private javax.swing.JLabel lblRok;
    private javax.swing.JTable tabelaStudenti;
    // End of variables declaration//GEN-END:variables
}
