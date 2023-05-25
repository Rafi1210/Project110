package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class CAR implements Serializable {
private int CarID;
private String CarName;
private String CarModel;
private String Manufacturer;
private String ManufacturerYear;
private double Price;
private double Mileage;
public String Color;
private String SalesmanID;
private String CustomerID;
ArrayList<CAR> PurchasedcarList ;

ArrayList<CAR> cars = new ArrayList<>();
public CAR() {}
//this constructor to add or search car
CAR(int CarID, String CarName,String CarModel, double Price, String Manufacturer, String ManufacturerYear, double Mileage, String Color){
	this.CarID = CarID;
	this.CarName = CarName;
	this.CarModel = CarModel;
	this.Price = Price;
	this.Manufacturer = Manufacturer;
	this.ManufacturerYear = ManufacturerYear;
	this.Mileage = Mileage;
	this.Color = Color;
	PurchasedcarList = new ArrayList<>();  //Customer carList	
}
//this constructor to buy car
CAR(int id ){
	this.CarID = id;
}
public String getColor() {
	return Color;
}
public void setColor(String color) {
	this.Color = color;
}
CAR(String CarModel){          //to purchase a car
	this.CarModel = CarModel;
}
public int getCarID() {
	return CarID;
}
public void setCarID(int CarID) {
	this.CarID = CarID;
}
public String getCarName() {
	return CarName;
}
public void setCarName(String CarName) {
	this.CarName = CarName;
}
public String getCarModel() {
	return CarModel;
}
public void setCarModel(String CarModel) {
	this.CarModel = CarModel;
}
public String getManufacturer() {
	return Manufacturer;
}
public void setManufacturer(String Manufacturer) {
	this.Manufacturer = Manufacturer;
}
public String getManufacturerYear() {
	return ManufacturerYear;
}
public void setManufacturerYear(String ManufacturerYear) {
	this.ManufacturerYear = ManufacturerYear;
}
public double getPrice() {
	return Price;
}
public void setPrice(double Price) {
	this.Price = Price;
}
public double getMileage() {
	return Mileage;
}
public void setMileage(double Mileage) {
	this.Mileage = Mileage;
}
@Override
public String toString() {
	return 				"CarID : "+CarID+
					    "\nCarName : "+CarName+
					    "\nCarModel : "+CarModel+
					    "\nPrice : "+Price+
					    "\nManufacturer :"+Manufacturer+
					    "\nManufacturerYear : "+ManufacturerYear+
					    "\nMileage : "+Mileage+
					    "\nCar Color : "+Color;
}

public void addCar(CAR car) {
	for (int i = 0; i < cars.size(); i++) {
		cars.add(car);

	}
	
}

}
