package com.study.springrestfulapi.services;

import com.study.springrestfulapi.domain.User;
import com.study.springrestfulapi.dto.UserDTO;
import com.study.springrestfulapi.repository.UserRepository;
import com.study.springrestfulapi.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User insert(User obj){
       return repo.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public void update(User obj){
        User newObj = repo.findById(obj.getId()).orElseThrow(()-> new ObjectNotFoundException(obj.getId()));
        updateData(newObj, obj);
        repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
