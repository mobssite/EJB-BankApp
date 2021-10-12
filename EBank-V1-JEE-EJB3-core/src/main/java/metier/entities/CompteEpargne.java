package metier.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private static final long serialVersionUID = 1L;

	private double taux;

	public CompteEpargne() {
		// super();
	}

	// public CompteEpargne(String numeroCompte, Date dateCreation, double
	// solde, double taux) {
	// super(numeroCompte, dateCreation, solde);
	// this.taux = taux;
	// }

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
