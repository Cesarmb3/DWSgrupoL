package com.spartanwrath.service;

import com.spartanwrath.model.Membership;
import com.spartanwrath.model.Product;
import com.spartanwrath.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class MembershipService {

    private AtomicLong nextId = new AtomicLong(1L);
    private ConcurrentHashMap<Long, Membership> suscripciones = new ConcurrentHashMap<>();

    public Optional<Membership> findById(long id) {
        if(this.suscripciones.containsKey(id)) {
            return Optional.of(this.suscripciones.get(id));
        }
        return Optional.empty();
    }

    public List<Membership> findByIds(List<Long> ids){
        List<Membership> memberships = new ArrayList<>();
        for(long id : ids){
            memberships.add(this.suscripciones.get(id));
        }
        return memberships;
    }

    public boolean exist(long id) {
        return this.suscripciones.containsKey(id);
    }

    public List<Membership> findAll() {
        return this.suscripciones.values().stream().toList();
    }

    public Membership save(Membership suscripcion) {
        long id = nextId.getAndIncrement();
        suscripcion.setId(id);
        suscripciones.put(id, suscripcion);
        return suscripcion;
    }

    public void delete(long id) {
        this.suscripciones.remove(id);
    }


}

