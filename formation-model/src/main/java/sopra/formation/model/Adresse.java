package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Adresse {
	@Column(name = "street")
	@NotEmpty(message="Rue obligatoire")
	private String rue;
	@Column(name = "complement")
	private String complement;
	@Column(name = "zipcode")
	@NotEmpty(message="code postal obligatoire")
	private String codePostal;
	@Column(name = "city")
	@NotEmpty(message="Ville obligatoire")
	private String ville;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String complement, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
