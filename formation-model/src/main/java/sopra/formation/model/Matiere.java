package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "subject")
public class Matiere {
	@EmbeddedId
	private MatiereId id;
	@Version
	private int version;
	@Column(name = "duration")
	private Integer duree;
	@Column(name = "requirement")
	private String preRequis;
	@Column(name = "objectives")
	private String objectifs;
	@Column(name = "program")
	private String programme;
	@ManyToMany(mappedBy = "competences")
	private List<Formateur> formateurs = new ArrayList<Formateur>();

	public Matiere() {
		super();
	}

	public Matiere(String nom, NiveauMatiere niveau, Integer duree) {
		super();
		this.id = new MatiereId(nom, niveau);
		this.duree = duree;
	}

	public MatiereId getId() {
		return id;
	}

	public void setId(MatiereId id) {
		this.id = id;
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

	public String getPreRequis() {
		return preRequis;
	}

	public void setPreRequis(String preRequis) {
		this.preRequis = preRequis;
	}

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

}
