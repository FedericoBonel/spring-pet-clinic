package com.fedebonel.springpetclinic.bootstrap;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.model.Pet;
import com.fedebonel.springpetclinic.model.PetType;
import com.fedebonel.springpetclinic.model.Vet;
import com.fedebonel.springpetclinic.services.OwnerService;
import com.fedebonel.springpetclinic.services.PetTypeService;
import com.fedebonel.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Class that creates data and inserts it into the web app when it first opens
 * By implementing CommandLineRunner, SpringBoot will know that it has to execute whatever is in the run method
 * on starting the application
 */
@Component
public class DataInitializer implements CommandLineRunner {

   private final OwnerService ownerService;
   private final VetService vetService;
   private final PetTypeService petTypeService;

    /**
     * Springs generates the dependency injection by
     * itself selecting the implementation that's needed each time
     */
    public DataInitializer(OwnerService ownerService,
                           VetService vetService,
                           PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        // ------------------------ Pet Types

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        System.out.println("Loaded PetTypes ----------");

        // ------------------------ Owners and Pets

        Owner owner1 = new Owner();
        owner1.setFirstName("Federico");
        owner1.setLastName("Bonel");
        owner1.setAddress("123 Strada");
        owner1.setCity("Cordoba");
        owner1.setTelephone("123123123");

        Pet owner1Pet = new Pet();
        owner1Pet.setName("Beto");
        owner1Pet.setPetType(dog);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setOwner(owner1);
        owner1.getPets().add(owner1Pet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Antonio");
        owner2.setLastName("Tozzi");
        owner2.setAddress("125 Strada");
        owner2.setCity("Buenos Aires");
        owner2.setTelephone("123123122");

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Beto");
        owner2Pet.setPetType(cat);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setOwner(owner2);
        owner2.getPets().add(owner2Pet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners ----------");

        // ------------------------ Vets

        Vet vet1 = new Vet();
        vet1.setFirstName("Marcos");
        vet1.setLastName("Lorenzini");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bartolome");
        vet2.setLastName("Veronzi");

        vetService.save(vet2);

        System.out.println("Loaded the vets ----------");
    }
}
