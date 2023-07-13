package ATM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Compte {
    private String nom;
    private String prenom;
    private Adresse adresse;
    private double solde;
    private List<Transaction> historique;
    private Scanner scanner;

    public Compte(String nom, String prenom, String rue, String codePostal, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = new Adresse(rue, codePostal, ville);
        this.solde = 1000;
        this.historique = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public double getSolde() {
        return solde;
    }

    public void deposer(double montant) {
        solde += montant;
        Transaction transaction = new Transaction(new Date(), "Dépôt", montant);
        historique.add(transaction);
        System.out.println("Dépôt effectué : " + montant);
    }

    public void retirer(double montant) {
        if (montant <= solde) {
            solde -= montant;
            Transaction transaction = new Transaction(new Date(), "Retrait", montant);
            historique.add(transaction);
            System.out.println("Retrait effectué : " + montant);
        } else {
            System.out.println("Solde insuffisant !");
        }
    }

    public void afficherHistoriqueTransactions() {
        System.out.println("=== Historique des transactions ===");
        for (Transaction transaction : historique) {
            System.out.println(transaction);
        }
    }

    public void modifierInformationsCompte() {
        System.out.println("=== Modification des informations du compte ===");
        System.out.println("Veuillez entrer le nouveau nom :");
        String nouveauNom = scanner.nextLine();
        nom = nouveauNom;

        System.out.println("Veuillez entrer le nouveau prénom :");
        String nouveauPrenom = scanner.nextLine();
        prenom = nouveauPrenom;

        System.out.println("Veuillez entrer la nouvelle rue :");
        String nouvelleRue = scanner.nextLine();

        System.out.println("Veuillez entrer le nouveau code postal :");
        String nouveauCodePostal = scanner.nextLine();

        System.out.println("Veuillez entrer la nouvelle ville :");
        String nouvelleVille = scanner.nextLine();

        adresse = new Adresse(nouvelleRue, nouveauCodePostal, nouvelleVille);
        System.out.println("Informations du compte modifiées avec succès !");
    }

    @Override
    public String toString() {
        return "Nom : " + nom + "\n" +
                "Prénom : " + prenom + "\n" +
                "Adresse : " + adresse;
    }
}


