package metier.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.Compte;
import metier.entities.CompteCourant;
import metier.session.BanqueLocal;

/**
 * 
 * 
 * @author Malick 
 * for local test :
 *         http://localhost:8080/EbankV1-EJB3/BanqueSOAPService?wsdl
 */
@Stateless
@WebService
public class BanqueSOAPService {

	@EJB(beanName = "EBANKV3")
	private BanqueLocal metier;

	@WebMethod
	@Oneway
	public void addCompte(@WebParam(name = "solde") double solde) {
		Compte cpt = new CompteCourant();
		cpt.setActive(true);
		cpt.setDateCreation(new Date());
		metier.addCompte(cpt, null, null);

	}

	@WebMethod
	public List<Compte> consulterComptes() {
		return metier.consulterComptes();
	}

	@WebMethod
	public Compte consulterCompte(@WebParam(name = "numCpte") String numCpte) {
		return metier.consulterCompte(numCpte);
	}

	@WebMethod
	public void verser(@WebParam(name = "code") String code, @WebParam(name = "montant") double montant) {
		metier.verser(code, montant);
	}

	@WebMethod
	public void retirer(@WebParam(name = "code") String code, @WebParam(name = "montant") double montant) {
		metier.retirer(code, montant);
	}

	@WebMethod
	public void Virer(@WebParam(name = "codeCptRecepteur") String codeCptEmetteur,
			@WebParam(name = "codeCptRecepteur") String codeCptRecepteur, @WebParam(name = "montant") double montant) {
		metier.virement(montant, codeCptEmetteur, codeCptRecepteur);
	}

}
