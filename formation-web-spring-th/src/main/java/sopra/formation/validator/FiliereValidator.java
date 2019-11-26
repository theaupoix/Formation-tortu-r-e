package sopra.formation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sopra.formation.model.Filiere;
import sopra.formation.model.Stagiaire;

public class FiliereValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Filiere.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Filiere filiere =(Filiere) target;		
		
		if(filiere.getReferent() == null || filiere.getReferent().getId() == null) {
			errors.rejectValue("referent.id", "notnull", "Referent obligatoire");
		}
	}

}
