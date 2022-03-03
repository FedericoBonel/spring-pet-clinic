package com.fedebonel.springpetclinic.bootstrap;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.model.PetType;
import com.fedebonel.springpetclinic.model.Vet;
import com.fedebonel.springpetclinic.services.OwnerService;
import com.fedebonel.springpetclinic.services.PetTypeService;
import com.fedebonel.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Class that creates data and inserts it into the web app when it first opens
 * By implementing CommanLineRunner, SpringBoot will know that it has to execute whatever is in the run method
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

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        System.out.println("Loaded PetTypes ----------");

        Owner owner1 = new Owner();
        owner1.setFirstName("Federico");
        owner1.setLastName("Bonel");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Antonio");
        owner2.setLastName("Tozzi");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ----------");

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
