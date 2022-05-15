package co.edu.umanizales.battleships.model;

import lombok.Data;

@Data
public class Game
{
    private int id;
    private Board boardPlayer1;
    private Board boardPlayer2;
    private byte shipsNumber;
    private byte turn;
    private byte hitsplayer1;
    private byte hitsplayer2;

    public Game(User player1,User player2,ListDE shipList )
    {
        createBoards(player1,player2,shipList);
        this.shipsNumber= (byte)shipList.getSize();


    }
    private void createBoards(User player1,User player2,ListDE shipList)
    {
        if(shipList.getSize()<=9)
        {
            this.boardPlayer1=new Board((byte)10,(byte)10,player1,shipList );
            this.boardPlayer2=new Board((byte)10,(byte)10,player2,shipList );
        }
        else if(shipList.getSize()>=10 && shipList.getSize()<=20)
        {
            this.boardPlayer1=new Board((byte)20,(byte)20,player1,shipList );
            this.boardPlayer2=new Board((byte)20,(byte)20,player2,shipList );

        }
        else
        {
            this.boardPlayer1=new Board((byte)30,(byte)30,player1,shipList );
            this.boardPlayer2=new Board((byte)30,(byte)30,player2,shipList );
        }

    }
    private User validateWinner()
    {
        return null;

    }

    public String validateShoot(int x, int y,User player)
    {
        return null;
    }



}
