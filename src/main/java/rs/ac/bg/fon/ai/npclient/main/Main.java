package rs.ac.bg.fon.ai.npclient.main;

import rs.ac.bg.fon.ai.npclient.coordinator.Coordinator;

public class Main {

    public static void main(String[] args) {
        try {
            Coordinator.getInstance().openLoginFrame();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
