package ATM;

import java.util.Date;

public class Transaction {
    private Date date;
    private String type;
    private double montant;

    public Transaction(Date date, String type, double montant) {
        this.date = date;
        this.type = type;
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Date : " + date +
                ", Type : " + type +
                ", Montant : " + montant;
    }
}
