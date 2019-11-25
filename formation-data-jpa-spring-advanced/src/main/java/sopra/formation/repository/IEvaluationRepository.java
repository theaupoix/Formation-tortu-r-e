package sopra.formation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Evaluation;

public interface IEvaluationRepository extends JpaRepository<Evaluation, Long> {

	@Query("from Evaluation e where e.stagiaire.nom = :nom and e.stagiaire.prenom = :prenom")
	Evaluation findByStagiaire(@Param("nom") String nom,@Param("prenom") String prenom);
	
	@Query("select e from Evaluation e join fetch e.stagiaire s where s.dtNaissance > :dtNais")
	List<Evaluation> findAllByDtNaissance(@Param("dtNais") Date dtNaissance);
	
	List<Evaluation> findByComportementale(Integer comportementale);
	
	@Query("from Evaluation e where e.id = :id")
	Evaluation find(@Param("id") Long id);
	
	@Query("from Evaluation e left outer join e.stagiaire s where s is null")
	List<Evaluation> findAllOrphan();
	
	@Query("from Evaluation e left outer join e.stagiaire s where s is null or s.id = :id")
	List<Evaluation> findAllOrphanAndCurrentStagiaire(@Param("id") Long stagiaireId);
}
