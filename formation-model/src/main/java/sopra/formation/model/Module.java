package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "module")
public class Module {
	@Id
	private Integer code;
	@Version
	private int version;
	@Column(name = "duration")
	private Integer duree;
	@Column(name = "position")
	private Integer ordre;
	@ManyToOne
	@JoinColumn(name = "training_id")
	private Filiere filiere;
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private Formateur formateur;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "subject_name", referencedColumnName = "name"),
			@JoinColumn(name = "subject_level", referencedColumnName = "level") })
	private Matiere matiere;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "classroom_name", referencedColumnName = "name"),
			@JoinColumn(name = "classroom_capacity", referencedColumnName = "capacity") })
	private Salle salle;

	public Module() {
		super();
	}

	public Module(Integer code) {
		super();
		this.code = code;
	}

	public Module(Integer code, Integer duree, Integer ordre, Filiere filiere, Formateur formateur, Matiere matiere,
			Salle salle) {
		super();
		this.code = code;
		this.duree = duree;
		this.ordre = ordre;
		this.filiere = filiere;
		this.formateur = formateur;
		this.matiere = matiere;
		this.salle = salle;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}
