package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private List<Compte> comptes;

    public Menu() {
        scanner = new Scanner(System.in);
        comptes = new ArrayList<>();
    }

    public void afficherMenu() {
        boolean quitter = false;

        while (!quitter) {
            System.out.println("=== MENU ===");
            System.out.println("1. Créer un compte");
            System.out.println("2. Consulter un compte");
            System.out.println("3. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    creerCompte();
                    break;
                case 2:
                    consulterCompte();
                    break;
                case 3:
                    quitter = true;
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        }
    }

    private void creerCompte() {
        System.out.println("=== Création d'un compte ===");
        System.out.println("Veuillez entrer votre nom :");
        String nom = scanner.nextLine();

        System.out.println("Veuillez entrer votre prénom :");
        String prenom = scanner.nextLine();

        System.out.println("Veuillez entrer votre adresse :");
        System.out.print("Rue : ");
        String rue = scanner.nextLine();

        System.out.print("Code postal : ");
        String codePostal = scanner.nextLine();

        System.out.print("Ville : ");
        String ville = scanner.nextLine();

        Compte compte = new Compte(nom, prenom, rue, codePostal, ville);
        comptes.add(compte);

        System.out.println("Compte créé avec succès !");
        System.out.println(compte);
    }

    private void consulterCompte() {
        System.out.println("=== Consultation de compte ===");
        System.out.println("Veuillez entrer le nom du compte à consulter :");
        String nom = scanner.nextLine();

        Compte compte = null;
        for (Compte c : comptes) {
            if (c.getNom().equals(nom)) {
                compte = c;
                break;
            }
        }

        if (compte != null) {
            afficherMenuCompte(compte);
        } else {
            System.out.println("Le compte \"" + nom + "\" n'existe pas !");
        }
    }

    private void afficherMenuCompte(Compte compte) {
        boolean retourMenu = false;

        while (!retourMenu) {
            System.out.println("=== MENU COMPTE ===");
            System.out.println("1. Consulter le solde");
            System.out.println("2. Faire un dépôt");
            System.out.println("3. Faire un retrait");
            System.out.println("4. Consulter l'historique des transactions");
            System.out.println("5. Modifier les informations du compte");
            System.out.println("6. Retour au menu principal");

            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) { //switch-case pour éviter les if-else
                case 1:
                    System.out.println("Solde : " + compte.getSolde());
                    break;
                case 2:
                    System.out.println("Montant du dépôt : ");
                    double montantDepot = scanner.nextDouble();
                    scanner.nextLine(); 
                    compte.deposer(montantDepot);
                    break;
                case 3:
                    System.out.println("Montant du retrait : ");
                    double montantRetrait = scanner.nextDouble();
                    scanner.nextLine(); 
                    compte.retirer(montantRetrait);
                    break;
                case 4:
                    compte.afficherHistoriqueTransactions();
                    break;
                case 5:
                    compte.modifierInformationsCompte();
                    break;
                case 6:
                    retourMenu = true;
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        }
    }
}
