package avaj.aircraft;
import  avaj.simulator.*;

public class Coordinates{
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height){
        if (longitude < 0)
            longitude = 0;
        else if (latitude < 0)
            latitude = 0;
        else if (height < 0)
            height = 0;
        else if (height > 100)
            height = 100;
        
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public int getLatitude(){
        return this.latitude;
    }

    public int getLongitude(){
        return this.longitude;
    }

    public int getHeight(){
        return this.height;
    }

    public void updateCoordinates(int longitude, int latitude, int height){
        this.latitude += latitude;
        this.longitude += longitude;
        this.height += height;
    }

}