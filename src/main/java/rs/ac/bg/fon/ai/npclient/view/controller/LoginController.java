package rs.ac.bg.fon.ai.npclient.view.controller;

import rs.ac.bg.fon.ai.npcommon.domain.Korisnik;
import rs.ac.bg.fon.ai.npclient.controller.KontrolerAL;
import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;
import rs.ac.bg.fon.ai.npclient.view.LoginFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {

    private final LoginFrame frame;
    int brojPokusaja;

    public LoginController(LoginFrame frame) {
        brojPokusaja = 0;
        this.frame = frame;
        prepareView();
        addActionListener();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addActionListener() {
        frame.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loginUser(actionEvent);
            }

            private void loginUser(ActionEvent actionEvent) {
                try {
                    String username = frame.getTxtKorisnickoIme().getText().trim();
                    char[] psch = frame.getTxtPassword().getPassword();
                    String password = String.valueOf(frame.txtPassword.getPassword());

                    if (!validateForm(username, password)) {
                        return;
                    }
                    
                    brojPokusaja++;
                    
                    Korisnik user = KontrolerAL.getInstance().login(username, password);
                    
                    if (user == null) {
                        if(brojPokusaja == Coordinator.getInstance().MAX_BR_POKUSAJA){
                        JOptionPane.showMessageDialog(
                            frame,
                            Coordinator.getInstance().getMessage("no_login_tries_left"),
                            "Login", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                        return;
                    }
                        throw new Exception();
                    }
                    JOptionPane.showMessageDialog(
                            frame,
                            Coordinator.getInstance().getMessage("greeting")+ " " + user.getUsername(),
                            "Login", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    Coordinator.getInstance().openMainFrame();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, Coordinator.getInstance().getMessage("login_failed"));
                }
            }

            private boolean validateForm(String username, String password) {
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, Coordinator.getInstance().getMessage("login_validation_failed"));
                    return false;
                }
                return true;
            }
        });
    }

    private void prepareView() {
        frame.getLblUsername().setText(Coordinator.getInstance().getMessage("lbl_username") + ":");
        frame.getLblPassword().setText(Coordinator.getInstance().getMessage("lbl_password") + ":");
    }

}
