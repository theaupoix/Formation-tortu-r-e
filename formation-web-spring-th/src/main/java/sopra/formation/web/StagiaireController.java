package sopra.formation.web;

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

import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;
import sopra.formation.repository.IEvaluationRepository;
import sopra.formation.repository.IPersonneRepository;
import sopra.formation.validator.StagiaireValidator;

@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {
	@Autowired
	private IEvaluationRepository evaluationRepo;

	@Autowired
	private IPersonneRepository personneRepo;

	public StagiaireController() {
		super();
	}

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Stagiaire> stagiaires = personneRepo.findAllStagiaire();

		model.addAttribute("stagiaires", stagiaires);

		return "stagiaire/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("niveauEtudes", NiveauEtude.values());
		model.addAttribute("stagiaire", new Stagiaire());

		model.addAttribute("evaluations", evaluationRepo.findAllOrphan());

		return "stagiaire/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		model.addAttribute("stagiaire", personneRepo.findById(id).get());
		model.addAttribute("niveauEtudes", NiveauEtude.values());

		model.addAttribute("evaluations", evaluationRepo.findAllOrphanAndCurrentStagiaire(id));

		return "stagiaire/form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("stagiaire") @Valid Stagiaire stagiaire, BindingResult result, Model model) {
		new StagiaireValidator().validate(stagiaire, result);
		
		if (result.hasErrors()) {
			model.addAttribute("niveauEtudes", NiveauEtude.values());

			if (stagiaire.getId() != null) {
				model.addAttribute("evaluations", evaluationRepo.findAllOrphanAndCurrentStagiaire(stagiaire.getId()));
			} else {
				model.addAttribute("evaluations", evaluationRepo.findAllOrphan());
			}

			return "stagiaire/form";
		}
		
		if(stagiaire.getEvaluation().getId()==null) {
			stagiaire.setEvaluation(null);
		}

		personneRepo.save(stagiaire);

		return "redirect:/stagiaire/list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/stagiaire/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long idEval, Model model) {
		personneRepo.deleteById(idEval);

		return list(model);
	}
}
