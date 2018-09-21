//import java.util.ArrayList;
package avaj.simulator;
import java.io.*;
import java.lang.*;
import java.util.*;

import avaj.weather.*;
import avaj.simulator.*;
import avaj.aircraft.*;

public	class	Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] arg) throws InterruptedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			if (line != null) {
				weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0) {
					System.out.println("Invalid simulations count " + simulations);
					System.exit(1);
				}
				while ((line = reader.readLine()) != null) {
					String items[] = line.split(" "); 

					Flyable flyable = AircraftFactory.newAircraft(items[0], items[1],
						Integer.parseInt(items[2]), Integer.parseInt(items[3]),
						Integer.parseInt(items[4]));
					if (flyable != null)
						flyables.add(flyable);
				}
			

				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
				}

				for (int i = 1; i <= simulations; i++) {
					weatherTower.changeWeather();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file " + arg[0]);
		} catch (IOException e) {
			System.out.println("There was an error while reading the file " + arg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Specify simulation file");
		} catch (NullPointerException e) {
			System.out.println("value is null");
		} catch (NumberFormatException e) {
			System.out.println("not a valid number entered in file");
		} finally {
			WriteFile.getWriteFile().close();
		}
	}
}