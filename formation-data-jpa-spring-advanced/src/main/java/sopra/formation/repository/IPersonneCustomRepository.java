package sopra.formation.repository;

import java.util.List;

public interface IPersonneCustomRepository {
	<T> List<T> findAll(Class<T> clazz);
}
