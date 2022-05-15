package co.edu.umanizales.battleships.service;


import co.edu.umanizales.battleships.model.TypeUser;
import co.edu.umanizales.battleships.model.User;
import co.edu.umanizales.battleships.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private User administrador;
    private User player1;
    private User player2;

    public UserService(){
        administrador= new User("kdgutierrez92072@umanizales.edu.co",
                "123456",new TypeUser(1,"Administrador"));

    }
    public List<UserDTO> listUsers()
    {
        List<UserDTO> list= new ArrayList<>();
        list.add(administrador.userToDTO());
        if(player1!=null)
        {
            list.add(player1.userToDTO());
        }
        if(player2!=null)
        {
            list.add(player2.userToDTO());
        }
        return list;
    }

    public String createPlayer(User player,byte numPlayer)
    {
        if(numPlayer==1 && player1 !=null)
        {
            return "Ya se creó el jugador1";
        }
        if(numPlayer==2 && player2 !=null)
        {
            return "Ya se creó el jugador2";
        }
        if (numPlayer==1)
        {
            player1=player;
        }
        else
        {
            player2=player;

        }
        return "Se ha creado exitosamente el jugador";


    }


}
