package fr.loginapp.ihm;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class ActionBoutons {

    public static void actionConnect(String utilisateur, char[] motDePasse, ButtonGroup grpPolitesse, JLabel champResultat) {

        // Récupérer les données du fichier login.properties
        String users = Settings.getProperty("user");
        String passwords = Settings.getProperty("password");

        // On récupère sous la forme d'une liste les différents utilisateurs et mots de
        // passes que l'on a dans le fichier properties
        List<String> allowedUsers = Arrays.asList(users.split(",").clone());
        List<String> allowedPasswords = Arrays.asList(passwords.split(",").clone());

        String messageOK = "Connexion autorisée";
        String messagePasOK = "Connexion refusée";

        // Cast de char[] => String
        String motDePasseString = String.valueOf(motDePasse);

        // Récupérer le niveau de politesse de l'utilisateur
        String niveauDePolitesse = grpPolitesse.getSelection().getActionCommand();

        if (niveauDePolitesse.equals("Ghetto")) {
            messageOK += ", mais fais gaffe sinon je t'attrape";
            messagePasOK += ", allez dégage d'ici";
        } else if (niveauDePolitesse.equals("Poli")) {
            messageOK += ", merci d'être passé";
            messagePasOK += ", veuillez ressayer, vos désirs sont des ordres.";
        }

        // On vient chercher le couple utilisateur/mot de passe entré au clavier par
        // l'utilisateur dans les listes
        int indiceUtilisateur = allowedUsers.indexOf(utilisateur);
        int indiceMotDePasse = allowedPasswords.indexOf(motDePasseString);


        // Si les positions utilisateur/mot de passe sont les mêmes, le couple
        // d'autentification est bon (attention quand même de vérfier que les données
        // sont vraiment dans la liste (indexOf renvoie -1 si l'element n'est pas dans
        // la liste)
        if (indiceUtilisateur == indiceMotDePasse && indiceMotDePasse != -1) {
            champResultat.setText(messageOK);
        } else {
            champResultat.setText(messagePasOK);
        }
    }
}
