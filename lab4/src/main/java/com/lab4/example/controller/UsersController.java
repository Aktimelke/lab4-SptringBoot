package com.lab4.example.controller;

import com.lab4.example.dto.UsersDto;
import com.lab4.example.exception.ValidationException;
import com.lab4.example.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
@CrossOrigin
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException {
        log.info("Handling save users: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers() {
        log.info("Handling find all users request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
