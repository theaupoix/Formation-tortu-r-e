
package sopra.formation.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.model.Formateur;
import sopra.formation.model.MatiereId;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.NiveauMatiere;
import sopra.formation.model.Stagiaire;
import sopra.formation.repository.IEvaluationRepository;
import sopra.formation.repository.IMatiereRepository;
import sopra.formation.repository.IPersonneRepository;
import sopra.formation.validator.StagiaireValidator;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

	@Autowired
	private IPersonneRepository personneRepo;

	@Autowired
	private IMatiereRepository matiereRepo;

	public FormateurController() {
		super();
	}

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Formateur> formateurs = personneRepo.findAllFormateur();

		model.addAttribute("formateurs", formateurs);

		return "formateur/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("formateur", new Formateur());
		model.addAttribute("competences", matiereRepo.findAll());

		return "formateur/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		model.addAttribute("formateur", personneRepo.findById(id).get());
		model.addAttribute("competences", matiereRepo.findAll());

		return "formateur/form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("formateur") @Valid Formateur formateur, BindingResult result, Model model,
			@RequestParam("comps") String comps) {

		if (result.hasErrors()) {
			return "formateur/form";
		}

		String listComp[] = comps.split(",");

		for (int i = 0; i < listComp.length; i++) {
			String matiere[] = listComp[i].split(":");

			MatiereId matiereId = new MatiereId(matiere[0], NiveauMatiere.valueOf(matiere[1]));

			formateur.getCompetences().add(matiereRepo.findById(matiereId).get());
		}
//		if(formateur.getCompetences().get==null) {
//			formateur.setEvaluation(null);
//		}

		personneRepo.save(formateur);

		return "redirect:/formateur/list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/formateur/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long idEval, Model model) {
		personneRepo.deleteById(idEval);

		return list(model);
	}
}
