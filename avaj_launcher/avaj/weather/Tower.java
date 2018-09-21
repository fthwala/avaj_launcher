
package avaj.weather;

import avaj.weather.*;
import avaj.aircraft.*;
import avaj.simulator.*;
import java.util.*;

public class Tower{
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    

    public void register(Flyable flyable){
        if(observers.contains(flyable))
            return ;
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
    }

}