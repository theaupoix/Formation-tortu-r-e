package sopra.formation.model;

public enum NiveauEtude {
	BAC("Bac"), BAC_2("Bac+2"), BAC_3("Bac+3"), BAC_5("Bac+5"), BAC_8("Bac+8");

	private final String label;

	private NiveauEtude(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
