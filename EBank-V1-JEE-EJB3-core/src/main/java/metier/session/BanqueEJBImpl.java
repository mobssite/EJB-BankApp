package metier.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Client;
import metier.entities.Compte;
import metier.entities.Employe;
import metier.entities.Groupe;
import metier.entities.Operation;

/**
 * EJB session STATELESS, sans �tat, que des m�thode, cr�e un pool d'instance
 * pour plusieur client,
 * 
 * publi� dans l'annuaire jdni avec comme nom "EBANKV3"
 * 
 * @author Malick
 *
 */
@Stateless(name = "EBANKV3")
public class BanqueEJBImpl implements BanqueRemote, BanqueLocal {

	// fait le lien avec l'unité de persistence dans persistence.xml
	@PersistenceContext(name = "UP_EBANKV3") 
	private EntityManager em;

	/* CLIENT METHOD */

	@Override
	public void addClient(Client c) {
		em.persist(c);
		em.persist(c);
	}
	
	@Override
	public List<Client> consulterClientsParNom(String mc) {
		Query req = em.createQuery("select c from Client c where c.nom like:mc");
		req.setParameter("mc", "%" + mc + "%");
		return req.getResultList();
	}

	@Override
	public List<Client> consulterClients() {
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public List<Groupe> consulterGroupes() {
		Query req = em.createQuery("select g from Groupe g");
		return req.getResultList();
	}

	/* EMPLOYE METHOD */
	
	@Override
	public void addEmploye(Employe e, Long numEmpSup) {
		Employe empSup;
		if (numEmpSup != null) {
			empSup = em.find(Employe.class, numEmpSup);
			e.setEmployeSup(empSup);
		}
		em.persist(e);
	}

	@Override
	public void addGroupe(Groupe g) {
		em.persist(g);
	}

	@Override
	public void addEmployeToGroupe(Long idGroupe, Long idEmp) {
		Employe emp = em.find(Employe.class, idEmp);
		Groupe g = em.find(Groupe.class, idGroupe);
		emp.getGroupes().add(g);
		g.getEmployes().add(emp);
		g.getEmployes().add(emp);
	}
	
	@Override
	public List<Employe> consulterEmployes() {
		Query req = em.createQuery("select eg from Employe e");
		return req.getResultList();
	}

	@Override
	public List<Employe> consulterEmployesParGroupe(Long idG) {
		Query req = em.createQuery("select e from Employe e where e.groupes.numGroupe=:x");
		req.setParameter("x", idG);
		return req.getResultList();
	}

	@Override
	public Employe consulterEmploye(Long idEmp) {
		Employe e = em.find(Employe.class, idEmp);
		if (e == null)
			throw new RuntimeException("Employe " + idEmp + "n'existe pas");
		return e;
	}

	/* COMPTE METHOD */

	@Override
	public List<Compte> consulterComptes() {
		// fetch - EAGER
		Query req = em.createQuery("select c from Compte c");
		// fetch - LAZY
		// Query req = em.createQuery("select cpt from Compte cpt left join fetch cpt.Client");
		return req.getResultList();
	};
	
	@Override
	public void addCompte(Compte c, Long numCli, Long numEmp) {
		Client cli = em.find(Client.class, numCli);
		Employe e = em.find(Employe.class, numEmp);
		c.setClient(cli);
		c.setEmploye(e);
		em.persist(c);
	}
	
	@Override
	public void addOperation(Operation op, String numCpte, Long numEmp) {
		Compte c = em.find(Compte.class, numCpte);
		Employe emp = em.find(Employe.class, numEmp);
		op.setEmploye(emp);
		op.setCompte(c);
		em.persist(op);
	}


	@Override
	public void verser(String code, double montant) {
	Compte cp = consulterCompte(code);
	cp.setSolde(cp.getSolde()+ montant);
	}
	
	@Override
	public void retirer(String code, double montant) {
	Compte cp = consulterCompte(code);
	if(cp.getSolde()<montant)throw new RuntimeException("Solde insuffisant");
	cp.setSolde(cp.getSolde()-montant);
	}
	@Override
	public void virement(double montant , String codeCptEmetteur,String codeCptRecepteur) {
		retirer(codeCptEmetteur, montant);
		verser(codeCptRecepteur, montant);
	}
	
	@Override
	public Compte consulterCompte(String numCpte) {
		Query req = em.createQuery("select cpt from Compte cpt where cpt.numeroCompte=:x");
		req.setParameter("x", numCpte);
		List<Compte> cptes = req.getResultList();
		if (cptes == null || cptes.size() == 0)
			throw new RuntimeException("Compte " + numCpte + "n'existe pas");
		return cptes.get(0);
	}



}
