package sopra.formation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sopra.formation.model.Module;

public class ModuleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Module.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Module module = (Module) target;
		
		if (module.getMatiere() == null || module.getMatiere().getId() == null) {
			errors.rejectValue("matiere.id", "notnull", "Matiere obligatoire");
		}
		if (module.getFiliere() == null || module.getFiliere().getId() == null) {
			errors.rejectValue("filiere.id", "notnull", "Filiere obligatoire");
		}
		if (module.getFormateur() == null || module.getFormateur().getId() == null) {
			errors.rejectValue("formateur.id", "notnull", "Formateur obligatoire");
		}
		if (module.getSalle() == null || module.getSalle().getNom() == null) {
			errors.rejectValue("salle.nom", "notnull", "Salle obligatoire");
		}

	}

}
