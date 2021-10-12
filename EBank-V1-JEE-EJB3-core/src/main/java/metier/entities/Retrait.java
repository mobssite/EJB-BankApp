package metier.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ebank_operation_retrait")
@DiscriminatorValue("R")
public class Retrait extends Operation implements Serializable {

	private static final long serialVersionUID = 1L;
	
}
