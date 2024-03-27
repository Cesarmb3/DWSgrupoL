package com.spartanwrath.service;

import com.spartanwrath.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private AtomicLong nextId = new AtomicLong(1L);
    private ConcurrentHashMap<Long, User> usuarios = new ConcurrentHashMap<>();

    public Optional<User> findById(long id) {
        if(this.usuarios.containsKey(id)) {
            return Optional.of(this.usuarios.get(id));
        }
        return Optional.empty();
    }

    public List<User> findByIds(List<Long> ids){
        List<User> users = new ArrayList<>();
        for(long id : ids){
            users.add(this.usuarios.get(id));
        }
        return users;
    }

    public boolean exist(long id) {
        return this.usuarios.containsKey(id);
    }

    public List<User> findAll() {
        return this.usuarios.values().stream().toList();
    }

    public User save(User user) {
        long id = nextId.getAndIncrement();
        user.setId(id);
        usuarios.put(id, user);
        return user;
    }

    public void delete(long id) {
        this.usuarios.remove(id);
    }


}

