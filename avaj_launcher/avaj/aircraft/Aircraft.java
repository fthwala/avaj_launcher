package avaj.aircraft;

import	avaj.aircraft.*;

public class Aircraft{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates){
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;

    }

    private long nextId(){
        //this.idCounter = 0;
        return Aircraft.idCounter++;
    }
}