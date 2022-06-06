package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.model.Pet;
import com.fedebonel.springpetclinic.services.OwnerService;
import com.fedebonel.springpetclinic.services.PetService;
import com.fedebonel.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Implementation of the map service for owners
 */
@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) return null;

        // If the owner has pets
        if (object.getPets() != null) {
            object.getPets().forEach(pet -> {
                if (pet.getPetType() == null) throw new RuntimeException("Pet Type is required");
                // If the pet type has not been saved yet (i.e. if the id has not been generated yet)
                if (pet.getPetType().getId() == null) {
                    // Save it and consolidate it with the returned pet
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                }
                // Check now if the pet has been saved, and if not save them
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return super.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    @Override
    public List<Owner> findByLastNameContainingIgnoreCase(String lastName) {
        Set<Owner> owners = super.findAll();
        List<Owner> matchingOwners = new ArrayList<>();

        owners.stream()
                .filter(owner -> owner.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .forEach(matchingOwners::add);

        return matchingOwners;
    }
}
