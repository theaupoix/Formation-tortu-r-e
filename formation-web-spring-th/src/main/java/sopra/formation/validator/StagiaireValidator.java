package sopra.formation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sopra.formation.model.Stagiaire;

public class StagiaireValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Stagiaire.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Stagiaire stagiaire = (Stagiaire) target;		
		
		if(stagiaire.getEvaluation() == null || stagiaire.getEvaluation().getId() == null) {
			errors.rejectValue("evaluation.id", "notnull", "Evaluation obligatoire");
		}
	}

}
