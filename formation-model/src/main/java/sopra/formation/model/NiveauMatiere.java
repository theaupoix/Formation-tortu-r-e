package sopra.formation.model;

public enum NiveauMatiere {
	FACILE("Facile"), MOYEN("Moyen"), DIFFICILE("Difficile"), IMPOSSIBLE("Impossible");
	
	private final String label;

	private NiveauMatiere(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
	
}



