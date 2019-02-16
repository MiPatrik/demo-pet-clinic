package demo.springframework.demopetclinit.bootstrap;

import demo.springframework.demopetclinit.model.*;
import demo.springframework.demopetclinit.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final VetService vetService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, PetTypeService petTypeService, VetService vetService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        if(ownerService.findAll().size() == 0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

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


        Pet fionaPet = new Pet();
        fionaPet.setOwner(owner1);
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setName("Garfield");
        fionaPet.setPetType(savedCatPetType);
        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(fionaPet);
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam1");
        vet2.setLastName("Axe2");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
