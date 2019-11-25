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

import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.Module;
import sopra.formation.model.Salle;
import sopra.formation.repository.IFiliereRepository;
import sopra.formation.repository.IMatiereRepository;
import sopra.formation.repository.IModuleRepository;
import sopra.formation.repository.IPersonneRepository;
import sopra.formation.repository.ISalleRepository;
import sopra.formation.validator.ModuleValidator;

@Controller
@RequestMapping("/module")
public class ModuleControler {

	@Autowired
	private IModuleRepository moduleRepo;
	@Autowired
	private IFiliereRepository filiereRepo;
	private ISalleRepository salleRepo;
	private IPersonneRepository formateurRepo;
	private IMatiereRepository matiereRepo;

	public ModuleControler() {
		super();
	}

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Module> modules = moduleRepo.findAll();

		model.addAttribute("modules", modules);
		return "module/list";

	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("Filiere", new Filiere());
		model.addAttribute("Salle", new Salle());
		model.addAttribute("Formateur", new Formateur());
		model.addAttribute("Matiere", new Matiere());

		model.addAttribute("module", new Module());

		return "module/form";

	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Integer code, Model model) {

		model.addAttribute("module", moduleRepo.findById(code).get());

		model.addAttribute("Filiere", filiereRepo.findAll());
		model.addAttribute("Salle", salleRepo.findAll());
		model.addAttribute("Formateur", formateurRepo.findAll());
		model.addAttribute("Matiere", matiereRepo.findAll());
		return "module/form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("id") @Valid Module module, BindingResult result, Model model) {
		new ModuleValidator().validate(module, result);

		if (result.hasErrors()) {

			model.addAttribute("Filiere", filiereRepo.findAll());
			model.addAttribute("Salle", salleRepo.findAll());
			model.addAttribute("Formateur", formateurRepo.findAll());
			model.addAttribute("Matiere", matiereRepo.findAll());

			return "module/form";
		}

		if (module.getFiliere().getId() == null)

		{
			module.setFiliere(null);
		}
		if (module.getSalle().getNom() == null)

		{
			module.setSalle(null);
		}
		if (module.getFormateur().getId() == null)

		{
			module.setFormateur(null);
		}
		if (module.getMatiere().getId() == null)

		{
			module.setMatiere(null);
		}

		moduleRepo.save(module);

		return "redirect:/module/list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/module/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer codeModule, Model model) {
		moduleRepo.deleteById(codeModule);
		return list(model);
	};
}
