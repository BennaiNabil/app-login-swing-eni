package fr.loginapp.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe EcranLogin qui hérite de JFrame.
 * <p>
 * Elle contiendra les composants et les appels nécessaires à leurs interventions dans
 * une classe ActionBoutons
 */
public class EcranLogin extends JFrame {

    private JLabel lblUser;
    private JLabel lblPwd;
    private JLabel lblVerif;

    private JTextField txtUser;
    private JPasswordField txtPwd;

    private JButton btnConnect;

    private ButtonGroup grpBtnPolitesse;
    private JRadioButton btnPoli;
    private JRadioButton btnGhetto;

    /**
     * Constructeur de la classe EcranLogin qui va gérer:
     * - l'action à executer lors de la fermeture de la fenêtre
     * - la taille initiale de la fenêtre
     * - le titre de la fenêtre
     * - la visibilité de la fenêtre
     * - le placement de ses composants délégué à la méthode initIHM()
     */
    public EcranLogin() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 325);
        setTitle("Fenêtre de login");
        setVisible(true);
        initIHM();
    }

    /**
     * La méthode initIHM() va mettre en place les composants nécéssaires
     * à l'écran de l'application
     */
    private void initIHM() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);

        // Ligne utilisateur
        gbc.gridy = 0;
        gbc.gridx = 0;
        panelPrincipal.add(getLblUser(), gbc);

        gbc.gridx = 1;
        panelPrincipal.add(getTxtUser(), gbc);

        // Ligne mot de passe
        gbc.gridy = 1;
        gbc.gridx = 0;
        panelPrincipal.add(getLblPwd(), gbc);

        gbc.gridx = 1;
        panelPrincipal.add(getTxtPwd(), gbc);

        // Ligne boutons radio de politesse

        // Création du ButtonGroup et ajout des JButton dans le ButtonGroup
        grpBtnPolitesse = getGrpBtnPolitesse();
        grpBtnPolitesse.add(getBtnPoli());
        grpBtnPolitesse.add(getBtnGhetto());

        gbc.gridy = 2;
        gbc.gridx = 0;
        panelPrincipal.add(getBtnPoli(), gbc);

        gbc.gridx = 1;
        panelPrincipal.add(getBtnGhetto(), gbc);

        // Ligne bouton connexion
        gbc.gridy = 3;
        gbc.gridx = 0;
        panelPrincipal.add(getBtnConnect(), gbc);

        // Ligne affichage vérification
        gbc.gridy = 4;
        gbc.gridx = 1;
        panelPrincipal.add(getLblVerif(), gbc);


        setContentPane(panelPrincipal);
    }

    //---------------- Getters des composants ---------------

    public JLabel getLblUser() {
        if (lblUser == null) {
            lblUser = new JLabel("Utilisateur");
        }
        return lblUser;
    }

    public JTextField getTxtUser() {
        if (txtUser == null) {
            txtUser = new JTextField(20);
        }
        return txtUser;
    }

    public JLabel getLblPwd() {
        if (lblPwd == null) {
            lblPwd = new JLabel("Mot de passe");
        }
        return lblPwd;
    }

    public JPasswordField getTxtPwd() {
        if (txtPwd == null) {
            txtPwd = new JPasswordField(20);
            txtPwd.setEchoChar('*');
        }
        return txtPwd;
    }

    public ButtonGroup getGrpBtnPolitesse() {
        if (grpBtnPolitesse == null) {
            grpBtnPolitesse = new ButtonGroup();
        }
        return grpBtnPolitesse;
    }

    public JRadioButton getBtnPoli() {
        if (btnPoli == null) {
            btnPoli = new JRadioButton("Poli", true);
            btnPoli.setActionCommand("Poli");
        }
        return btnPoli;
    }

    public JRadioButton getBtnGhetto() {
        if (btnGhetto == null) {
            btnGhetto = new JRadioButton("Ghetto");
            btnGhetto.setActionCommand("Ghetto");
        }
        return btnGhetto;
    }

    public JButton getBtnConnect() {
        if (btnConnect == null) {
            btnConnect = new JButton("Connect");
            btnConnect.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ActionBoutons.actionConnect(getTxtUser().getText(),
                                                getTxtPwd().getPassword(),
                                                getGrpBtnPolitesse(), getLblVerif());
                }
            });

        }
        return btnConnect;
    }

    public JLabel getLblVerif() {
        if (lblVerif == null) {
            lblVerif = new JLabel();
        }
        return lblVerif;
    }
}
