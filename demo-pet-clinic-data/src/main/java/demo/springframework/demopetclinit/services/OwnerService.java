package demo.springframework.demopetclinit.services;

import demo.springframework.demopetclinit.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

