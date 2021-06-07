package rs.ac.bg.fon.ai.npclient.view.util;

import rs.ac.bg.fon.ai.npcommon.domain.Eksperiment;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EksperimentTableModel extends AbstractTableModel {

    List<Eksperiment> list;
    String[] kolone = new String[]{
        Coordinator.getInstance().getMessage("table_column_name"), 
        Coordinator.getInstance().getMessage("table_column_date"), 
        Coordinator.getInstance().getMessage("table_column_points"), 
        Coordinator.getInstance().getMessage("table_column_experimenter")};
    
    
    public EksperimentTableModel() {
        list = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Eksperiment e = list.get(rowIndex);
       
       switch(columnIndex){
           default:
               return "n/a";
           case 0:
               return e.getNaziv();
           case 1:
               return e.getDatumOdrzavanja();
           case 2:
               return e.getBodovi();
           case 3:
               return e.getEksperimenatator().toString();
       }
    }

    public void setEksperimenti(List<Eksperiment> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public List<Eksperiment> getEksperimenti() {
        return list;
    }
    
    
}
