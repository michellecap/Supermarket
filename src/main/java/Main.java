import supermarket.CashRegisterUI;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static CashRegisterUI MFRAME;

    public static void main(String[] args) {

        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main.MFRAME = new CashRegisterUI(/*init parms to constructor*/);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.MFRAME.setVisible(true);
            }
        });
    }
}
