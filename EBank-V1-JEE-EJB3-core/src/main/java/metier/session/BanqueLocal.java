package metier.session;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Client;
import metier.entities.Compte;
import metier.entities.Employe;
import metier.entities.Groupe;
import metier.entities.Operation;

/**
 * Interface Locale accesible depuis une interface web ou web service
 * 
 * @author Malick
 *
 */
@Remote
public interface BanqueLocal {

	/* Client */
	
	public void addClient(Client c);
	public void addEmploye(Employe e,Long numEmpSup);
	public void addGroupe(Groupe g);
	public void addEmployeToGroupe(Long idGroupe,Long idEmp);
	
	public List<Client> consulterClientsParNom(String mc);
	public List<Client> consulterClients();
	public List<Groupe> consulterGroupes();
	public List<Employe> consulterEmployes();
	public List<Employe> consulterEmployesParGroupe(Long idG);
	public Employe consulterEmploye(Long idEmp);
	
	/* Compte */
	public List<Compte> consulterComptes();
	public void addCompte(Compte c,Long numCli,Long numEmp );
	public Compte consulterCompte(String numCpte);
	public void addOperation(Operation op,String numCpte,Long numEmp);
	
	public void verser(String code, double montant);	
	public void retirer(String code, double montant);
	public void virement(double montant , String codeCptEmetteur,String codeCptRecepteur);
				
}
