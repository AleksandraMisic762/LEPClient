package rs.ac.bg.fon.ai.npclient.coordinator;

import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.view.LoginFrame;
import rs.ac.bg.fon.ai.npclient.view.controller.*;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Coordinator {

    MainController mainController;
    public final int MAX_BR_POKUSAJA;
    private static Coordinator instance;
    Locale aLocale = new Locale("sr", "RS");
    ResourceBundle messages = ResourceBundle.getBundle("Messages", aLocale);

    private Coordinator() {
        MAX_BR_POKUSAJA = 3;
    }

    public static Coordinator getInstance() {
        if (instance == null) {
            instance = new Coordinator();
        }
        return instance;
    }

    public void openLoginFrame() throws Exception{
        try {
            KontrolerAL.getInstance();
            new LoginController(new LoginFrame());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Povezivanje na server nije uspelo");
            KontrolerAL.getInstance().closeSocket();
        }
    }

    public void openMainFrame() {
        mainController = new MainController();
    }

    public EksperimentController openAddEksperiment() {
        return new EksperimentController();
    }

    public EksperimentatorController openAddEksperimentator() {
        return new EksperimentatorController();
    }

    public StudentController openAddStudenta() {
        return new StudentController();
    }

    public ListaStudentController openListaStudenata() {
        return new ListaStudentController();
    }
    
    public StudentiNaEksperimentuController openUcNaEksperimentu() {
        return new StudentiNaEksperimentuController();
    }

    public RasporedEksperimenataController openRasporedEksperimenata() {
        return new RasporedEksperimenataController();
    }

    public UcesceStudentaController openPromeniStudenta() {
        return new UcesceStudentaController();
    }

    public String getMessage(String messageType){
        return messages.getString(messageType);
    }
    
    public void clearMainFrame() {
        mainController.addPanel(new JPanel());
    }
    
    public void closeMainFrame(){
        try {
            KontrolerAL.getInstance().closeSocket();
            mainController.getFrame().dispose();
        } catch (Exception ex) {
            
        }
    }

    public IzvestajStudentiSaUslovomController openIzvestajStudentiSaUslovomPanel() {
        return new IzvestajStudentiSaUslovomController();
    }
    
     public IzvestajSprovedeniEksperimentiController openIzvestajSprovedeniEksperimentiPanel() {
        return new IzvestajSprovedeniEksperimentiController();
    }
     
      public IzvestajUcescaNaEksperimentuController openIzvestajUcescaNaEksperimentuPanel() {
        return new IzvestajUcescaNaEksperimentuController();
    }
}
