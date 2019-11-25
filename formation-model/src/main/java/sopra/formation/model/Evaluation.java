package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rating")
public class Evaluation {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "behavior")
	@NotNull(message = "{evaluation.comportementale.notnull}")
	@Min(value = 0, message = "{evaluation.comportementale.min}")
	@Max(value = 20, message = "{evaluation.comportementale.max}")
	private Integer comportementale;
	@Column(name = "technical")
	private Integer technique;
	@Size(min = 1, message = "{evaluation.commentaires.size}")
	@Column(name = "comments")
	private String commentaires;
	@OneToOne(mappedBy = "evaluation", fetch = FetchType.LAZY)
	private Stagiaire stagiaire;

	public Evaluation() {
		super();
	}

	public Evaluation(Long id, Integer comportementale, Integer technique, String commentaires) {
		super();
		this.id = id;
		this.comportementale = comportementale;
		this.technique = technique;
		this.commentaires = commentaires;
	}
	
	

	public Evaluation(Integer comportementale, Integer technique, String commentaires) {
		super();
		this.comportementale = comportementale;
		this.technique = technique;
		this.commentaires = commentaires;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getComportementale() {
		return comportementale;
	}

	public void setComportementale(Integer comportementale) {
		this.comportementale = comportementale;
	}

	public Integer getTechnique() {
		return technique;
	}

	public void setTechnique(Integer technique) {
		this.technique = technique;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

}
