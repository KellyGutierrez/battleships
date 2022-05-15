package co.edu.umanizales.battleships.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String email;
    private String password;
    private TypeUser typeUser;

    public User(String email, String password, TypeUser typeUser) {
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }

    public UserDTO userToDTO()
    {
        UserDTO userDTO= new UserDTO(this.email,this.getTypeUser().getDescription());
        return userDTO;
    }
}
