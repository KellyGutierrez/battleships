package co.edu.umanizales.battleships.controller;

import co.edu.umanizales.battleships.model.UserDTO;
import co.edu.umanizales.battleships.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers()
    {
        return userService.listUsers();
    }







}
