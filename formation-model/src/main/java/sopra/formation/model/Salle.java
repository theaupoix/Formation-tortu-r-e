package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "classroom")
@IdClass(SalleId.class)
public class Salle {
	@Id
	@Column(name = "name")
	private String nom;
	@Id
	@Column(name = "capacity")
	private Integer capacite;
	@Version
	private int version;
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "salle")
	private List<Module> modules = new ArrayList<Module>();

	public Salle() {
		super();
	}

	public Salle(String nom, Integer capacite) {
		super();
		this.nom = nom;
		this.capacite = capacite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite() {
		return capacite;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

}
