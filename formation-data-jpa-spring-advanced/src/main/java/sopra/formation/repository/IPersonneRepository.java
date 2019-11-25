package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Formateur;
import sopra.formation.model.Personne;
import sopra.formation.model.Stagiaire;

public interface IPersonneRepository extends JpaRepository<Personne, Long>, IPersonneCustomRepository {
	@Query("from Stagiaire")
	List<Stagiaire> findAllStagiaire();

	@Query("from Formateur")
	List<Formateur> findAllFormateur();

	@Query("select distinct s from Stagiaire s join fetch s.evaluation e where s.id = :id")
	Stagiaire findWithEvaluation(@Param("id") Long id);
}
