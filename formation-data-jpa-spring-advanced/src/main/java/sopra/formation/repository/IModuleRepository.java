package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Module;

public interface IModuleRepository extends JpaRepository<Module, Integer> {
}
