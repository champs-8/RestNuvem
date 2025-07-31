package com.champs.restNuvem.domain.service;

import com.champs.restNuvem.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(Long id);
    User create(User user);
}
