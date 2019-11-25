package sopra.formation.model;

public class DispositifBis {
	public static final DispositifBis CPRO = new DispositifBis("Contrat de professionnalisation");
	public static final DispositifBis POEI = new DispositifBis("Pr�paration Op�rationnelle � l'Emploi Individuelle");

	private final String label;

	private DispositifBis(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
