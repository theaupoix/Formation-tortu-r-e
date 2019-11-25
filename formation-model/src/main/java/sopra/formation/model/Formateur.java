package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("trainer")
public class Formateur extends Personne {
	private int experience;
	@OneToMany(mappedBy = "referent")
	private List<Filiere> filieres = new ArrayList<Filiere>();
	@OneToMany(mappedBy = "formateur")
	private List<Module> modules = new ArrayList<Module>();
	@ManyToMany
	@JoinTable(name = "skill", joinColumns = @JoinColumn(name = "trainer_id"), inverseJoinColumns = {
			@JoinColumn(name = "subject_name", referencedColumnName = "name"),
			@JoinColumn(name = "subject_level", referencedColumnName = "level") })
	private List<Matiere> competences = new ArrayList<Matiere>();

	public Formateur() {
		super();
	}

	public Formateur(String nom, String prenom) {
		super(nom, prenom);
	}

	public Formateur(String nom, String prenom, int experience) {
		super(nom, prenom);
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public List<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Matiere> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Matiere> competences) {
		this.competences = competences;
	}

}
