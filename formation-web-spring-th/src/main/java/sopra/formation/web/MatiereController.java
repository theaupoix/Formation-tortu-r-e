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

import sopra.formation.model.Matiere;
import sopra.formation.model.MatiereId;
import sopra.formation.model.NiveauMatiere;
import sopra.formation.repository.IMatiereRepository;

@Controller
@RequestMapping("/matiere")
public class MatiereController {
	@Autowired
	private IMatiereRepository matiereRepo;

	public MatiereController() {
		super();
	}

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Matiere> matieres = matiereRepo.findAll();

		model.addAttribute("matieres", matieres);

		return "matiere/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("niveauMatieres", NiveauMatiere.values());
		model.addAttribute("matiere", new Matiere());

		return "matiere/form";
	}

	@GetMapping("/edit")
//	public String edit(@RequestParam("id") MatiereId id, Model model) {
	public String edit(@RequestParam("nom") String nom, @RequestParam("niveau") NiveauMatiere niveauMatiere, Model model) {
		model.addAttribute("niveauMatieres", NiveauMatiere.values());
		
		MatiereId matiereId = new MatiereId(nom, niveauMatiere);

		model.addAttribute("matiere", matiereRepo.findById(matiereId).get());

		return "matiere/form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("matiere") @Valid Matiere matiere,@RequestParam("nom") String nom, @RequestParam("niveau") NiveauMatiere niveauMatiere, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "matiere/form";
		}
		MatiereId matiereId = null;
		matiereId = new MatiereId(nom, niveauMatiere);
		matiere.setId(matiereId);
		matiereRepo.save(matiere);

		return "redirect:/matiere/list";

	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/matiere/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("nom") String nom, @RequestParam("niveau") NiveauMatiere niveauMatiere, Model model) {
		MatiereId matiereId = null;
		matiereId = new MatiereId(nom, niveauMatiere);
		matiereRepo.deleteById(matiereId);

		return list(model);
	}
}
