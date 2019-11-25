package sopra.formation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@SuppressWarnings("serial")
@Embeddable
public class MatiereId implements Serializable {
	@Column(name = "name")
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "level")
	private NiveauMatiere niveau;

	public MatiereId() {
		super();
	}

	public MatiereId(String nom, NiveauMatiere niveau) {
		super();
		this.nom = nom;
		this.niveau = niveau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public NiveauMatiere getNiveau() {
		return niveau;
	}

	public void setNiveau(NiveauMatiere niveau) {
		this.niveau = niveau;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatiereId other = (MatiereId) obj;
		if (niveau != other.niveau)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
