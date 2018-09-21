package avaj.aircraft;

import	avaj.weather.*;
import	avaj.aircraft.*;
import  avaj.simulator.*;

import java.util.*;
public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String>massages = new HashMap<String, String>();
        massages.put("SUN", "It's been long since we had sun, thanks God");
        massages.put("RAIN", "Can't really hold on for long rain let's it stop already!.");
        massages.put("FOG", "It's fog cant see");
        massages.put("SNOW", "Snow is too bad out here.");

        if (weather.equals("SUN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
        }
        else if (weather.equals("RAIN"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
        }

        WriteFile.getWriteFile().writetofile("JetPlain#" + this.name + "(" + this.id + "): " + massages.get(weather));
        if (this.coordinates.getHeight() == 0)
        {
            WriteFile.getWriteFile().writetofile("JetPlain#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            WriteFile.getWriteFile().writetofile("Tower says: JetPlain#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WriteFile.getWriteFile().writetofile("Tower says: JetPlain#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }

    
}