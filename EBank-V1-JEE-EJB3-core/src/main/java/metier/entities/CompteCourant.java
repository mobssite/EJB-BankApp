package metier.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	
	private static final long serialVersionUID = 1L;
	
	private double decouvert;

	public CompteCourant() {
//		super();
	}

//	public CompteCourant(String numeroCompte, Date dateCreation, double solde, double decouvert) {
//		super(numeroCompte, dateCreation, solde);
//		this.decouvert = decouvert;
//	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
}
