package fr.loginapp.ihm;

import javax.swing.*;

public class AppLogin {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EcranLogin();
            }
        });
    }
}
