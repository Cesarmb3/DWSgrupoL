package com.spartanwrath.service;

import com.spartanwrath.model.CombatClass;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class CombatClassService {
    private AtomicLong nextId = new AtomicLong(1L);
    private ConcurrentHashMap<Long, CombatClass> clases = new ConcurrentHashMap<>();

    public Optional<CombatClass> findById(long id) {
        if(this.clases.containsKey(id)) {
            return Optional.of(this.clases.get(id));
        }
        return Optional.empty();
    }

    public boolean exist(long id) {
        return this.clases.containsKey(id);
    }

    public List<CombatClass> findAll() {
        return this.clases.values().stream().toList();
    }

    public CombatClass save(CombatClass clase) {
        long id = nextId.getAndIncrement();
        clase.setId(id);
        clases.put(id, clase);
        return clase;
    }

    public void delete(long id) {
        this.clases.remove(id);
    }
}