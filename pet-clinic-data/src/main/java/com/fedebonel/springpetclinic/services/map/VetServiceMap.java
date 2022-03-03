package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Speciality;
import com.fedebonel.springpetclinic.model.Vet;
import com.fedebonel.springpetclinic.services.SpecialityService;
import com.fedebonel.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * Implementation of the map service for vets of the clinic
 */
@Service
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object == null) return null;
        // Before saving, make sure that the specialities are saved as well
        // If not, save them and assign the new generated id to the runtime entity
        if (object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
