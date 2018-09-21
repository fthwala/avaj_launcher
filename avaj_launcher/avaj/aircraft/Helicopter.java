package avaj.aircraft;

import	avaj.weather.*;
import	avaj.aircraft.*;
import  avaj.simulator.*;

import java.util.*;
public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String>masseges = new HashMap<String, String>();
        masseges.put("SUN", "For the we are having a good weather, thanks God");
        masseges.put("RAIN", "Rain is not good for my helicopter.");
        masseges.put("FOG", "Can't see beyond, the for is killing me");
        masseges.put("SNOW", "Snow is not best friend with these machines");

        if (weather.equals("SUN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
        }
        else if (weather.equals("RAIN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        }

        WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): " + masseges.get(weather));
        if (this.coordinates.getHeight() == 0)
        {
            WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            WriteFile.getWriteFile().writetofile("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WriteFile.getWriteFile().writetofile("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }

    
}