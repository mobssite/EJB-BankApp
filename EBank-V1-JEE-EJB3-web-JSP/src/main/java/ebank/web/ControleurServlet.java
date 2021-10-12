package ebank.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.entities.Compte;
import metier.session.BanqueLocal;

@WebServlet(name = "cs", urlPatterns = { "/controleur" })
public class ControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// référence vers l'EJB session via l'interface local
	@EJB
	private BanqueLocal metier;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if (action.equals("Tous Les comptes")) {
				request.setAttribute("comptes", metier.consulterComptes());
			}
		} catch (Exception e) {
			request.setAttribute("exception", e.getMessage());
		}
		request.getRequestDispatcher("Banque.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if (action != null) {
				if (action.equals("Consulter")) {
					// Long code = Long.parseLong(request.getParameter("code"));
					String numeroCompte = request.getParameter("numeroCompte");
					request.setAttribute("numeroCompte", numeroCompte);
					Compte cp = metier.consulterCompte(numeroCompte);
					request.setAttribute("compte", cp);
				} 
				else if ((action.equals("Verser")) || (action.equals("Retirer"))) {
					double montant = Double.parseDouble(request.getParameter("montant"));
					// Long code = Long.parseLong(request.getParameter("code"));
					String numeroCompte = request.getParameter("code");
					request.setAttribute("montant", montant);
					request.setAttribute("numeroCompte", numeroCompte);
					if (action.equals("Verser")) {
						metier.verser(numeroCompte, montant);
					} else {
						metier.retirer(numeroCompte, montant);
					}
					request.setAttribute("compte", metier.consulterCompte(numeroCompte));
				}
			}
		} catch (Exception e) {
			request.setAttribute("exception", e.getMessage());
		}
		request.getRequestDispatcher("Banque.jsp").forward(request, response);
	}
}
