package project;

import java.io.*;
import java.util.ArrayList;

public class Inventory implements Serializable{
	
	
	ArrayList<CAR> cars;
	Inventory(){
		cars = new ArrayList<>(); //Car List
	}

	    public void addCarInfo(CAR car) {
	    	for (int i = 0; i < cars.size(); i++) {
	    		cars.add(car);
			}
	        
	    }

	    public ArrayList<CAR> getCarInfo() {
	        return cars;
	    }
	
	}
	
