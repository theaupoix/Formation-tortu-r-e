package sopra.formation.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SalleId implements Serializable {
	private String nom;
	private Integer capacite;

	public SalleId() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacite == null) ? 0 : capacite.hashCode());
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
		SalleId other = (SalleId) obj;
		if (capacite == null) {
			if (other.capacite != null)
				return false;
		} else if (!capacite.equals(other.capacite))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
