package rs.ac.bg.fon.ai.npclient.view.panels;

import com.toedter.calendar.JCalendar;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

public class RasporedEksperimenataPanel extends javax.swing.JPanel {

    public RasporedEksperimenataPanel() {
        initComponents();
        dateChooser1 = new JCalendar(new Date(System.currentTimeMillis()));
        this.add(dateChooser1);
        dateChooser2 = new JCalendar(new Date(System.currentTimeMillis()));
        this.add(dateChooser2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDatumOd = new javax.swing.JLabel();
        lblDtumDo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRasporedEksperimenata = new javax.swing.JTable();
        btnKreirajR = new javax.swing.JButton();

        lblDatumOd.setText("Datum od:");

        lblDtumDo.setText("Datum do:");

        tblRasporedEksperimenata.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRasporedEksperimenata);

        btnKreirajR.setText("Kreiraj raspored");
        btnKreirajR.setMaximumSize(new java.awt.Dimension(130, 25));
        btnKreirajR.setMinimumSize(new java.awt.Dimension(130, 25));
        btnKreirajR.setPreferredSize(new java.awt.Dimension(130, 25));
        btnKreirajR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDatumOd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDtumDo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKreirajR, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatumOd)
                    .addComponent(lblDtumDo))
                .addGap(38, 38, 38)
                .addComponent(btnKreirajR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKreirajRActionPerformed

    public JButton getBtnKreirajR() {
        return btnKreirajR;
    }

    public JCalendar getdCDtumDo() {
        return dateChooser2;
    }

    public JCalendar getdCDtumOd() {
        return dateChooser1;
    }

    public JTable getTblRasporedEksperimenata() {
        return tblRasporedEksperimenata;
    }

    public JLabel getLblDatumOd() {
        return lblDatumOd;
    }

    public JLabel getLblDtumDo() {
        return lblDtumDo;
    }
    
    
    JCalendar dateChooser1;
    JCalendar dateChooser2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreirajR;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatumOd;
    private javax.swing.JLabel lblDtumDo;
    private javax.swing.JTable tblRasporedEksperimenata;
    // End of variables declaration//GEN-END:variables
}
