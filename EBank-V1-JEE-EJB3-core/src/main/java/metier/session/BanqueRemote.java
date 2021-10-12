package metier.session;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Client;
import metier.entities.Compte;
import metier.entities.Employe;
import metier.entities.Groupe;
import metier.entities.Operation;

/**
 * Pour les accée à distance depuis un client lourd java 
 * @author Malick
 *
 */
@Local
public interface BanqueRemote {

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
	
	public void addCompte(Compte c,Long numCli,Long numEmp );
	public Compte consulterCompte(String numCpte);
	
	public void addOperation(Operation op,String numCpte,Long numEmp);
	
}
