package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Filiere;

public interface IFiliereRepository extends JpaRepository<Filiere, Long> {
}
