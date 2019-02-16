package demo.springframework.demopetclinit.repositories;

import demo.springframework.demopetclinit.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
