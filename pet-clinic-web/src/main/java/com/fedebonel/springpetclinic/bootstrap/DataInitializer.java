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

    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Federico");
        owner1.setLastName("Bonel");
        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner2.setFirstName("Antonio");
        owner2.setLastName("Tozzi");
        System.out.println("Loaded Owners ----------");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Marcos");
        vet1.setLastName("Lorenzini");
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Bartolome");
        vet2.setLastName("Veronzi");
        System.out.println("Loaded the vets ----------");
    }
}
