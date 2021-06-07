package rs.ac.bg.fon.ai.npclient.view.util;

import rs.ac.bg.fon.ai.npcommon.domain.Student;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel{

    List<Student> list = new ArrayList<>();
    String[] kolone = new String[]{
        Coordinator.getInstance().getMessage("table_column_student_id"), 
        Coordinator.getInstance().getMessage("table_column_firstname"), 
        Coordinator.getInstance().getMessage("table_column_lastname")}; 
    
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
        Student s = list.get(rowIndex);
        switch(columnIndex){
            default:
                return "n/a";
            case 0:
                return s.getBrojIndeksa();
            case 1:
                return s.getIme();
            case 2:
                return s.getPrezime();
        }
    }

    public void setList(List<Student> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    
    
}
