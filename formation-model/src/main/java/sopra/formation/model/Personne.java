package sopra.formation.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name = "lastname")
	@NotEmpty(message="Nom obligatoire")
	private String nom;
	@NotEmpty(message="Prénom obligatoire")
	@Column(name = "firstname")
	private String prenom;
	@Column(unique = true)
	@NotEmpty(message="Courriel obligatoire")
	@Email(message="Courriel mal formé")
	private String email;
	@Column(name = "phonenumber")
	@Pattern(regexp = "^[0-9]{10}$", message = "Numéro sur 10 chiffres")
	private String telephone;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "rue", column = @Column(name = "p_street")),
			@AttributeOverride(name = "complement", column = @Column(name = "p_complement")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "p_zipcode")),
			@AttributeOverride(name = "ville", column = @Column(name = "p_city")) })
	@Valid
	private Adresse adresse;

	public Personne() {
		super();
	}

	public Personne(Long id, int version, String nom, String prenom, String email, String telephone, Adresse adresse) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
