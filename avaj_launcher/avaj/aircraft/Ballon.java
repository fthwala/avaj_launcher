package avaj.aircraft;

import	avaj.weather.*;
import	avaj.aircraft.*;
import  avaj.simulator.*;
import java.util.*;

public class Ballon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Ballon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String>massages = new HashMap<String, String>();
        massages.put("SUN", "Let's enjoy the good weather and take some pics.");
        massages.put("RAIN", "Damn you rain! You messed up my baloon.");
        massages.put("FOG", "there is fog I can't see well");
        massages.put("SNOW", "It's snowing. We're  gonna crash.");

        if (weather.equals("SUN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
        }
        else if (weather.equals("RAIN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        }

        WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): " + massages.get(weather));
        if (this.coordinates.getHeight() == 0)
        {
            WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            WriteFile.getWriteFile().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WriteFile.getWriteFile().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}