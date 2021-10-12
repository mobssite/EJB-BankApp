package web.jsf.bean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import metier.entities.Compte;
import metier.entities.CompteCourant;
import metier.session.BanqueLocal;

@ManagedBean
@RequestScoped
public class BanqueManagedBean {
    
	/* properties */
	
    private String numeroCompteEmetteur;
    private String numeroCompteCible;
    private double montant;
    
    /* dependency injection */
    
    @EJB
    private BanqueLocal metier;
    
    /* methods  */
    
    public String verser() {
    	metier.verser(numeroCompteCible, montant );
    	return "success";
    }
    
    public String retirer() {
    	metier.retirer(numeroCompteCible, montant );
    	return "success";
    }
    
    public String virer() {
    	metier.virement(montant, numeroCompteEmetteur, numeroCompteCible);
    	return "success";
    }
    
    public String ajouter() {
    	Compte cpt = new CompteCourant();
    	cpt.setDateCreation(new Date());
    	cpt.setSolde(montant);
    	metier.addCompte(cpt, null, null);
    	return "success";
    }
    
    
   
    
    public List<Compte> getListComptes() {
    	return metier.consulterComptes();
    }

    /* getter and setters*/ 
    
	public String getNumeroCompteEmetteur() {
		return numeroCompteEmetteur;
	}

	public void setNumeroCompteEmetteur(String numeroCompteEmetteur) {
		this.numeroCompteEmetteur = numeroCompteEmetteur;
	}

	public String getNumeroCompteCible() {
		return numeroCompteCible;
	}

	public void setNumeroCompteCible(String numeroCompteCible) {
		this.numeroCompteCible = numeroCompteCible;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
   
    
    
    

}
