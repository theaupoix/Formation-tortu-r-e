package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Salle;
import sopra.formation.model.SalleId;

public interface ISalleRepository extends JpaRepository<Salle, SalleId> {
}
