package ATM;

public class Adresse {
    private String rue;
    private String codePostal;
    private String ville;

    public Adresse(String rue, String codePostal, String ville) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    @Override
    public String toString() {
        return rue + ", " + codePostal + " " + ville;
    }
}
