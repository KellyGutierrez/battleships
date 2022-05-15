package co.edu.umanizales.battleships.model;


import lombok.Data;

@Data
public class Ship {
    private int id;
    private String name;
    private byte numPlace;

    public Ship(String name, byte numPlace){
        this.name = name;
        this.numPlace = numPlace;

    }
}
