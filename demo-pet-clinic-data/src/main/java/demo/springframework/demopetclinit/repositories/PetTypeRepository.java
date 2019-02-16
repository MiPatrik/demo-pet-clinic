package demo.springframework.demopetclinit.repositories;

import demo.springframework.demopetclinit.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
