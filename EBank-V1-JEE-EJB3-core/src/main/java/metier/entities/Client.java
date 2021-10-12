package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ebank_client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* properties */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull	
	@Size(min=3, max=20)
	private String nomClient;
	
	@NotNull
	@Size(min=3, max=20)
	
	private String prenom;
	
	private String mobilePhoneNumber;
	
	@Column(nullable = false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateNaissance;

	// @OneToMany(mappedBy = "client", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@OneToMany(mappedBy = "client" , fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Compte> comptes;

	/* constructor */
	
	public Client() {
	}

	/* getters & setters */
	
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


}
