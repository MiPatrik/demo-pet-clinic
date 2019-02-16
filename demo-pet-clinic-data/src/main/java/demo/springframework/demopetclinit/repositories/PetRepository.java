package demo.springframework.demopetclinit.repositories;

import demo.springframework.demopetclinit.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
