package avaj.aircraft;

import avaj.aircraft.*;
import avaj.weather.*;
import avaj.simulator.*;

public interface Flyable{
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}