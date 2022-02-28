package com.fedebonel.springpetclinic.bootstrap;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.model.Vet;
import com.fedebonel.springpetclinic.services.OwnerService;
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

    /**
     * Springs generates the dependency injection by
     * itself selecting the implementation that's needed each time
     */
    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Federico");
        owner1.setLastName("Bonel");
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Antonio");
        owner2.setLastName("Tozzi");
        System.out.println("Loaded Owners ----------");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Marcos");
        vet1.setLastName("Lorenzini");
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Bartolome");
        vet2.setLastName("Veronzi");
        System.out.println("Loaded the vets ----------");
        vetService.save(vet2);
    }
}
