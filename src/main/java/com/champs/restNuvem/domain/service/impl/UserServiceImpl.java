package com.champs.restNuvem.domain.service.impl;

import com.champs.restNuvem.domain.model.User;
import com.champs.restNuvem.domain.repository.UserRepository;
import com.champs.restNuvem.domain.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Usuário não encontrado com id: " + id));
    }

    @Override
    public User create(User user) {
//        if (user.getId() != null && userRepository.existsById(user.getId())) {
//            throw new IllegalArgumentException("Usuário já existe com id: " + user.getId());
//        }//ou
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("Usuário já existe com número de conta: " + user.getAccount().getNumber());
        }
        return userRepository.save(user);
    }
}
