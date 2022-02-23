package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.BaseEntity;

import java.util.*;

/**
 * Abstract implementation of the services with Maps as Storage [Instead of a DB]
 * it basically contains the logic, and the extensions of this will implement it with values
 * @param <T> Type of object to store [has to extend baseEntity, hence have an ID]
 * @param <ID> Type of the object's id [has to extend or be a Long object]
 */
public abstract class AbstractServiceMap<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        // Return all values of the keys as a set
        return new HashSet<T>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object == null) throw new RuntimeException("Object cannot be null");
        // Generate or use its id to save it into the map
        if (object.getId() == null) {
            object.setId(getNewId());
        }
        map.put(object.getId(), object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        // Returns a set of pairs key:value, and then for each one of them we
        // remove only the one that has a value equal to the object we want to delete
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNewId(){
        Long newId;
        // If there's nothing in the map set the new id to 1, otherwise get the max id value and add 1 to it
        if (map.size() == 0) newId = 1L;
        else newId = Collections.max(map.keySet()) + 1;
       return newId;
    }
}
