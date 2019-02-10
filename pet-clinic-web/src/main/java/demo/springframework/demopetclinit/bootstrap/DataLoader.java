package demo.springframework.demopetclinit.bootstrap;

import demo.springframework.demopetclinit.model.Owner;
import demo.springframework.demopetclinit.model.Pet;
import demo.springframework.demopetclinit.model.PetType;
import demo.springframework.demopetclinit.model.Vet;
import demo.springframework.demopetclinit.services.OwnerService;
import demo.springframework.demopetclinit.services.PetTypeService;
import demo.springframework.demopetclinit.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, PetTypeService petTypeService, VetService vetService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("kjj Bricker");
        owner1.setCity("Miami");
        owner1.setTelephone("3302525");

        Pet mikePet = new Pet();
        mikePet.setPetType(savedDogPetType);
        mikePet.setOwner(owner1);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Rosco");
        owner1.getPets().add(mikePet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner1.setAddress("52 K 23 Villa Linda");
        owner1.setCity("Miami");
        owner1.setTelephone("3302525");
        ownerService.save(owner2);

        Pet fionaPet = new Pet();
        fionaPet.setOwner(owner1);
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setName("Garfield");
        fionaPet.setPetType(savedCatPetType);
        owner2.getPets().add(fionaPet);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam1");
        vet2.setLastName("Axe2");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
