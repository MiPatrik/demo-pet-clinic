package demo.springframework.demopetclinit.repositories;

import demo.springframework.demopetclinit.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
