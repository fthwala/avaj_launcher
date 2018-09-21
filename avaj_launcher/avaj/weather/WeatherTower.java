package avaj.weather;

import avaj.weather.*;
import avaj.simulator.*;
import avaj.aircraft.*;

public class WeatherTower extends Tower{
    
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        this.conditionsChanged();
    }


}