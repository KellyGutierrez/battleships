package co.edu.umanizales.battleships.controller;

import co.edu.umanizales.battleships.model.GenericResponse;
import co.edu.umanizales.battleships.model.PlayerDTO;
import co.edu.umanizales.battleships.model.User;
import co.edu.umanizales.battleships.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user")
    public ResponseEntity<GenericResponse> getUsers()
    {
        return new ResponseEntity<GenericResponse>(
                new GenericResponse(200,userService.listUsers(),null),
                HttpStatus.OK
        );
    }


    @PostMapping(path = "/createplayer")
    public ResponseEntity<GenericResponse> createPlayer(@RequestBody @Valid PlayerDTO player)
    {
        return new ResponseEntity<GenericResponse>(
                new GenericResponse(200,userService.createPlayer(player.getPlayer(), player.getNumPlayer()),
                        null),
                HttpStatus.OK
        );
    }
    @PostMapping(path = "login")
    public ResponseEntity<GenericResponse> login(@RequestParam("code") int code,@RequestParam("email")String email,@RequestParam("password")String password,@RequestParam("description")String description)
    {
        String token= getJWTToken(email);
        return new ResponseEntity<GenericResponse>(
                new GenericResponse(200,token,
                        null),
                HttpStatus.OK
        );
    }
    private String getJWTToken(String user)
    {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(user)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;



    }





}
