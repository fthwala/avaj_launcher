package avaj.weather;

// import	avaj.weather.*;
import	avaj.aircraft.*;
import avaj.simulator.*;
import	java.util.Random;

public class WeatherProvider{

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){

    }
    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvider;
    }
    
    public String getCurrentWeather(Coordinates coordinates)
    {
        int weatherOption = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        return weather[weatherOption % 4];
    }
}