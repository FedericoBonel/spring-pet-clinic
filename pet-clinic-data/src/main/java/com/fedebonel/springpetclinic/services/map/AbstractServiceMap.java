package com.fedebonel.springpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Abstract implementation of the services with Maps as Storage [Instead of a DB]
 * it basically contains the logic, and the extensions of this will implement it with values
 * @param <T> Type of object to store
 * @param <ID> Type of the object's id
 */
public abstract class AbstractServiceMap<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        // Return all values of the keys as a set
        return new HashSet<T>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T object) {
        map.put(id, object);

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
}
