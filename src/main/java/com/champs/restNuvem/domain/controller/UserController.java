package com.champs.restNuvem.domain.controller;

import com.champs.restNuvem.domain.model.User;
import com.champs.restNuvem.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //constructor injection automatically provided by @RequiredArgsConstructor
    private final UserService userService;

    @GetMapping("/") //mostrar a mensagem de status da API
    public Map<String, String> statusRoot() {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", "API Restful da DIO está ativa!");
        return resposta;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        var createdUser = userService.create(user);

        // Create a URI for the newly created user
        // using ServletUriComponentsBuilder to build the URI based on the current request
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdUser);
    }
}
