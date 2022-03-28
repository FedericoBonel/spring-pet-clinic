package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Visit;
import com.fedebonel.springpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractServiceMap<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        // Validate that it has a valid owner and pet related to it
        if (object.getPet() == null
                || object.getPet().getId() == null
                || object.getPet().getOwner() == null
                || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit, pet or owner does not exist");
        }
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
