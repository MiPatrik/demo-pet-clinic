package demo.springframework.demopetclinit.repositories;

import demo.springframework.demopetclinit.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
