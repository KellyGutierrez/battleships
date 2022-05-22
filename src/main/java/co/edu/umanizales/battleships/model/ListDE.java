package co.edu.umanizales.battleships.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ListDE {
    private NodeDE head;
    private int size;
    private int count;

    public List<ShipDistribution> enlist(){
        List<ShipDistribution> list = new ArrayList<>();
        if (this.head != null) {
            NodeDE temp = this.head;
            while (temp != null) {
                list.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return list;
    }

    public void add(ShipDistribution shipDistribution)
    {
        if(this.head == null)
        {
            this.head= new NodeDE(shipDistribution);
        }
        else {
            NodeDE temp = this.head;
            while (temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(new NodeDE(shipDistribution));
            temp.getNext().setPrevious(temp);
        }
        this.size++;
    }

    public void allToStart(ShipDistribution shipDistribution){
        shipDistribution.getShip().setId(this.size+1);
        if(this.head == null)
        {
            this.head= new NodeDE(shipDistribution);
        }
        else
        {
            NodeDE newNode = new NodeDE(shipDistribution);
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }
        this.size++;
    }

    public List<ShipDistribution> listNodes() {
        List<ShipDistribution> list = new ArrayList<>();
        NodeDE temp = this.head;
        while (temp != null)
        {
            list.add(temp.getData());
            temp = temp.getNext();
        }
        return list;
    }
    public ListDE clonelist()
    {
        ListDE listClone= new ListDE();
        NodeDE temp= this.head;
        while (temp!=null)
        {
            listClone.add(temp.getData());
            temp=temp.getNext();

        }
        return listClone;
    }
    public boolean validateCoordinatesExist(Coordinate[] coordinates)
    {
        NodeDE temp= this.head;
        while (temp!=null)
        {
            for (Coordinate coord: coordinates)
            {
                if(temp.getData().validateCoordinatesExist(coord))
                {
                    return true;
                }
            }
            temp= temp.getNext();
        }
        return false;
    }
}
