package project;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarMainProject {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<Salesman> salesmans = new ArrayList<>();
		ArrayList<Customer> customers = new ArrayList<>();
		ArrayList<CAR> cars = new ArrayList<>();  //available cars
		ArrayList<CAR> PurchasedcarList = new ArrayList<>();  //Customer carList
		
		boolean exit = false;
		
        while (!exit){
		System.out.println("*************** Welcome to Cars Sales System ***************");
		System.out.println("            +-------------------------------+");
		System.out.println("	    |Press (1) for User Registration|");
		System.out.println("	    |_______________________________|");
		System.out.println("	    |Press (2) for User Login       |");
		System.out.println("	    |_______________________________|");
		System.out.println("	    |Press (3) to Exit              |");
		System.out.println("	    |_______________________________|");

		
		System.out.print("Enter any option to operate(1 to 3)  - ");
		 try{
		int option = input.nextInt();
		switch (option) {
		//User Registration 
		case 1: {
			boolean innerExit = false;
			while(!innerExit) {
				System.out.println("            +------------------------------------+");
				System.out.println("	    |Press (1) for Customer Registration |");
				System.out.println("	    |____________________________________|");
				System.out.println("	    |Press (2) for Salesman Registration |");
				System.out.println("	    |____________________________________|");
				System.out.println("	    |Press (3) to Back                   |");
				System.out.println("	    |____________________________________|");
				
				System.out.print("Choose option - ");

				int registrationOption = input.nextInt();
				switch (registrationOption){
				case 1: {
					//Customer Register Process
					try(FileOutputStream fos = new FileOutputStream("CustomerList.txt");
						ObjectOutputStream oos = new ObjectOutputStream(fos))
					{
						
						for (int i = 0; i < 1000; i++) {
			
					User objUsercus = new Customer();  // polymorphism
					int userRegId =  objUsercus.UserUniqueID();
					System.out.println("Enter user first name : ");
					String cusRegFirstName = input.next();
					System.out.println("Enter user last name : ");
					String cusRegLastName = input.next();
					input.nextLine();
					System.out.println("Enter user address : ");
					String cusRegAddress = input.nextLine();
					System.out.println("Enter user Phone number : ");
					String cusRegNumber = input.next();
					input.nextLine();
					System.out.println("Enter user password : ");
					String cusRegPassword = input.nextLine();
					Customer cusRegObj = new Customer(userRegId, cusRegFirstName, cusRegNumber,cusRegAddress, cusRegPassword);
					
					customers.add(cusRegObj);
					
					System.out.println("\nSuccessfylly Registered!\n");
					System.out.println("+--------------------------------------------+");
					System.out.println("|First Name     : "+ cusRegFirstName);
					System.out.println("|____________________________________________|");
					System.out.println("|Last Name      : "+ cusRegLastName);
					System.out.println("|____________________________________________|");
					System.out.println("|User Unique ID : #C"+userRegId);
					System.out.println("|____________________________________________|");
					System.out.println("|Address        : "+ cusRegAddress);
					System.out.println("|____________________________________________|");
					System.out.println("|Phone Number   : "+ cusRegNumber);
					System.out.println("|____________________________________________|");
					
					
					
					break;
				
					}
						//customer file...starts
						oos.writeObject(customers);			 
						oos.close();
						fos.close();
						
						//customer file...ends
				 System.out.println("Customer data saved successfully.");
//				 oos.close();
//				 fos.close();
				} catch (IOException e) {
				    System.out.println("Error while saving customer data: " + e.getMessage());
				}
					catch (InputMismatchException e) {
						System.out.println(e);
					} 
					break;
				}
				
				case 2:{
					//Salesman Register Process
						try(FileOutputStream fos = new FileOutputStream("SalesmanList.txt");
								ObjectOutputStream oos = new ObjectOutputStream(fos))
							{
						for (int i = 0; i < 20; i++) {
					User objUsersales = new Salesman();//user refrence and salesman object
					int userRegId =  objUsersales.UserUniqueID();
					System.out.println("Enter user first name : ");
					String salesRegFirstName = input.next();
					System.out.println("Enter user last name : ");
					String salesRegLastName = input.next();
					input.nextLine();
					System.out.println("Enter user address : ");
					String salesRegAddress = input.nextLine();
					System.out.println("Enter user Phone number : ");
					String salesRegNumber = input.next();
					input.nextLine();
					System.out.println("Enter user password : ");
					String salesRegPassword = input.nextLine();
					Salesman salesRegObj = new Salesman(userRegId, salesRegFirstName, salesRegNumber, salesRegAddress, salesRegPassword);
					salesmans.add(salesRegObj);
					
					
					System.out.println("\nSuccessfylly Registered!\n");
					System.out.println("+----------------------------------------------+");
					System.out.println("|First Name     : "+ salesRegFirstName);
					System.out.println("|______________________________________________|");
					System.out.println("|Last Name      : "+ salesRegLastName);
					System.out.println("|______________________________________________|");
					System.out.println("|User Unique ID : #S"+userRegId);
					System.out.println("|______________________________________________|");
					System.out.println("|Address        : "+ salesRegAddress);
					System.out.println("|______________________________________________|");
					System.out.println("|Phone Number   : "+ salesRegNumber);
					System.out.println("|______________________________________________|");
				
					break;
						}
						//salesman file...starts
						oos.writeObject(salesmans);			 
						oos.close();
						fos.close();
						
						//salesman file...ends
						
						 System.out.println("Salesman data saved successfully.");
						} catch (IOException e) {
						    System.out.println("Error while saving salesman data: " + e.getMessage());
						}
							catch (InputMismatchException e) {
								System.out.println(e);
							} 
							break;
						}
				//Back to Registration or Login Page 
				case 3:{
					   innerExit = true;
	                    break;
				}
			default:
				//exit
				System.out.println("Invaid operation!!!(Choose between 1 to 3)\nProgram exit!");
				break;									
				}
			}
			break;
		}
		// User Login 
		case 2: {
			boolean innerExit = false;
			while(!innerExit) {
				System.out.println("            +-------------------------------+");
				System.out.println("	    |Press (1) for Customer Login   |");
				System.out.println("	    |_______________________________|");
				System.out.println("	    |Press (2) for Salesman Login   |");
				System.out.println("	    |_______________________________|");
				System.out.println("	    |Press (3) to Back              |");
				System.out.println("	    |_______________________________|");

				
				System.out.print("Choose option - ");

				int loginOption = input.nextInt();
				switch (loginOption){
				case 1: {
					
					//Customer Login Process				
					
					    System.out.println("Enter First Name : ");
					    String cusLoginName = input.next();
						input.nextLine();
					    System.out.println("Enter Password : ");
					    String cusLoginPassword = input.nextLine();
					    
					    try(FileInputStream	fis = new FileInputStream("CustomerList.txt");
								ObjectInputStream ois = new ObjectInputStream(fis)) {
					    	boolean isloggedin  = false;
					    	customers = (ArrayList<Customer>) ois.readObject();
					    	
							
					    	   try {
					    for (int i = 0; i < customers.size(); i++) {
					    if (cusLoginName.equals(customers.get(i).getCustomerUsername())
					    		&& cusLoginPassword.equals(customers.get(i).getCustomerPassword())
					    		&& customers.get(i).getCustomerPassword() != null ) {
					    	    isloggedin = true;
					            System.out.println("Successfully Logged In !");
					            System.out.println("Welcome " + customers.get(i).getCustomerUsername()+" !");
					            
		 //Customer Profile starts here...
					            boolean innerInnerExit = false;
								
								while(!innerInnerExit) {
					            System.out.println("1. View your profile information");
					            System.out.println("2. Edit your profile information");
					            System.out.println("3. Purchase a  Car ");
					            System.out.println("4. Search Car ");
					            System.out.println("5. Print Car List ");
					            System.out.println("6. Logout ");

					            System.out.println("Enter an option number to continue:");
					            int CustomerAccOption = input.nextInt();

					            switch (CustomerAccOption) {
				// Option 1 profile info of customer...
					            case 1 : {
									
										customers.get(i).display();
										break;
					            }
					            
			   // Option 1 ends here for customer 

					            //Option 2 edit profile info 
					            case 2 : {     
					            		System.out.println("Enter new User Name : ");
						            	String cusUpdatename = input.next();
					            		customers.get(i).setCusFirstname(cusUpdatename);
					                	System.out.println(customers.get(i).getCusFirstname());
					                	System.out.println("User Name Updated!");
									    break;
					            }
					            //Option 2 ends here for customer 
					            
					            //Option 3 Purchase a  Car
					            case 3 : {
		                            try (FileOutputStream fos = new FileOutputStream("PurchasedCarCustomerList.txt");
		   		            		     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
		   		            		input.nextLine(); // consume newline character
		   		            		System.out.println("Enter Car ID to buy : ");
		   		            		int carID = input.nextInt();
		   		            		
		   					    	System.out.println("Congratulations! You have purchased the Car. ");
		   					    	
		   					    	
		   					    	for (int x = 0; x < cars.size(); x++){
		   					            if (cars.get(x).getCarID() == carID){           
		   					                PurchasedcarList.add(cars.get(x));
		   					                cars.remove(cars.get(x));

		   					                System.out.println("You have purchased a car, car count " + cars.size());
		   					                System.out.println("purchased car count " + PurchasedcarList.size());
		   					                System.out.println("Car Information - ");
		   					             System.out.println(PurchasedcarList.get(x).toString());
		   					                break;
		   					            }
		   					         else {
		   					            System.out.println("Sorry, the car you have selected is not available.");
		   					        }                                                             
		   					    }
		   					    			   					    	
		   					    	
		   					    	oos.writeObject(cars);
		   		            	   
		   					    	oos.close();
		   					    	fos.close();
		   		            	} catch (IOException e) {
		   		            	   System.out.println("Error while saving cars data: " + e.getMessage());
		   		            	}
		   		            	break;
		   				            }
					            //Option 3 ends here for customer 
					            
					            //Option 4 Search a  Car

					            case 4 : {

					            	boolean InnerinnerInnerExit = false;
					            	while (!InnerinnerInnerExit) {
										System.out.println("\n");
										System.out.println("1. Search by Car ID");
										System.out.println("2. Search by Car Name");
										System.out.println("3. Search by Manufacturer Name");
										System.out.println("4. Search by Manufactur Year");
										System.out.println("5. Exit");
										System.out.println("Enter Search Option : ");
										int searchoption = input.nextInt();	
										switch(searchoption) {
										case 1 :{
											System.out.println("Enter Car ID : ");
											int cId = input.nextInt();
										    boolean carFound = false;

											for (int j = 0; j < cars.size(); j++) {
												if (cId == cars.get(j).getCarID()) {
													System.out.println(cars.get(j).toString());
													 carFound = true;
											            break;
												}
											
												
											}
											if (!carFound) {
												System.out.println("Car Not Found!");

											}
											break;
										}
										case 2:{
											System.out.println("Enter Car Name : ");
							            	input.nextLine();
							            	String cName = input.nextLine();
										    boolean carFound = false;

											for (int j = 0; j < cars.size(); j++) {
												if (cName.equals(cars.get(j).getCarName())) {
													System.out.println(cars.get(j).toString());
													carFound = true;
													break;
													
												}
												
											}
											if (!carFound) {
												System.out.println("Car Not Found!");

											}
											break;

										}
										case 3: {
											System.out.println("Enter Car Manufacturer Name : ");
											input.nextLine();
							            	String cManufac = input.nextLine();
										    boolean carFound = false;

							            	for (int j = 0; j < cars.size(); j++) {
												if (cManufac.equals(cars.get(j).getManufacturer())) {
													System.out.println(cars.get(j).toString());
													carFound = true;
													break;
												}
											
											}	
							            	if (!carFound) {
												System.out.println("Car Not Found!");

											}
							            	break;
										}
										
										case 4: {
											System.out.println("Enter Car Manufacturer Year : ");
											input.nextLine();
							            	String cManufacYear = input.nextLine();
										    boolean carFound = false;

							            	for (int j = 0; j < cars.size(); j++) {
												if (cManufacYear.equals(cars.get(j).getManufacturerYear()) ) {
													System.out.println(cars.get(j).toString());
													carFound = true;
													break;
												}
												
											}
							            	if (!carFound) {
												System.out.println("Car Not Found!");

											}
							            	break;
										}
										case 5 :{ 
											InnerinnerInnerExit = true;
											break;
										}
										default :{
											System.out.println("Invaid operation!!!(Choose between 1 to 5)\n~~~Program exit!~~~");
										break;
										}
										
										}
					            	}
					            	
					            
					            	break;
					            }
					            //Option 4 ends here for customer 
					            
					            //Option 5  Print Car List
					            case 5 : {
					            	
					            	  try (FileInputStream cfis = new FileInputStream("cars.txt");
					            	    	     ObjectInputStream cois = new ObjectInputStream(cfis)) {
					            	    	
					            		  cars= (ArrayList<CAR>) cois.readObject();
					            		   
					            		System.out.println("*****List of Cars*****");
					            		System.out.println("Specification of Available Car : ");	
					            		for (int j = 0; j <cars.size(); j++) {
					            		    System.out.println("\n"+ cars.get(j)+"\n");
					            		}
					            		cois.close();
					            		cfis.close();

					            	    } catch (IOException | ClassNotFoundException e) {
					            		    System.out.println("Error while loading cars data: " + e.getMessage());
					            		}
					            	    

					            	    break;
					            }
					            //Option 5 ends here for customer 
					            
					            //Option 6 view prurchased car
					            
		        //CustomerAccOption switch ends
			            
					            
								case 6:{
									System.out.println("Logged out !");
									innerInnerExit = true;
					                break;
								}
								default :
									System.out.println("Invaid operation!!!(Choose between 1 to 7)\nProgram exit!");
					                break;
					
								}
						         //Customer Profile ends here...

						}
					            
					    }// condition ends here
					    if (!isloggedin) {
					    	 System.out.println("Invalid Name or password...");
						} 					    
				          
					} //loop ends here
					    fis.close();
					    ois.close();
					    	   }catch (Exception e) {
					    		   break;							
					    		   }
					    	   
					    } catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					break;
				} // Case 1 : Customer Login ends here
				case 2:{
					
					//Salesman Login Process
					
						
						System.out.println("Enter First Name : ");
						String salesLoginName = input.next();
						input.nextLine();
						System.out.println("Enter Password : ");
						String salesLoginPassword = input.nextLine();
						
						  try(FileInputStream	fis = new FileInputStream("SalesmanList.txt");
									ObjectInputStream ois = new ObjectInputStream(fis)) {
						    	boolean isloggedin  = false;
						    	salesmans = (ArrayList<Salesman>) ois.readObject();
						
						try {
						for (int i = 0; i < salesmans.size(); i++) {
						if (salesLoginName.equals(salesmans.get(i).getSalesmanUsername())
								&& salesLoginPassword.equals(salesmans.get(i).getSalesmanPassword())
								&& salesmans.get(i).getSalesmanPassword() != null ){
							
				    	    isloggedin = true;
							System.out.println("Successfully Logged In !");
							System.out.println("Welcome "+salesmans.get(i).getSalesmanUsername()+" !");
						
			 //Salesman Profile starts here...
							boolean innerInnerExit = false;
							
							while(!innerInnerExit) {
				            
				            System.out.println("1. View your profile information");
				            System.out.println("2. Edit your profile information");
				            System.out.println("3. Add car information");
				            System.out.println("4. Print Car List");
				            System.out.println("5. Sell a Car ");
				            System.out.println("6. Search Car ");
				            System.out.println("7. Logout");
				            

				            System.out.println("Enter an option number to continue:");
				            int SalesmanAccOption = input.nextInt();

				            switch (SalesmanAccOption) {
			// Option 1 profile info of salesman ...
				            case 1:{
									salesmans.get(i).display();
									break;
								}
							   // Option 1 ends here for salesman 

				            //Option 2 edit profile info of salesman
				            case 2: {
				                
				        		System.out.println("Enter new User Name : ");
				            	String salesUpdatename = input.next();
				        		salesmans.get(i).setSalesFirstname(salesUpdatename);
				            	System.out.println(salesmans.get(i).getSalesFirstname());
				            	System.out.println("User Name Updated!");
							    break;
				        
				            }
							   // Option 2 ends here for salesman 

				            case 3:{
				            	
				            	try (FileOutputStream fos = new FileOutputStream("cars.txt");
				            		     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				            		   
				            	
				            	for (int j = 0; j < 20; j++) {      //store the car information at a time
				            	System.out.print("Enter CarID : ");
				            	int invID = input.nextInt();
				            	input.nextLine();
				            	System.out.println("Enter Car Name : ");
				            	String invCarName = input.nextLine();
				            	System.out.println("Enter Car Model : ");
				            	String invCarModel = input.nextLine();
				            	System.out.println("Enter Car Price : ");
				            	double invCarPrice = input.nextDouble();
				            	input.nextLine();
				            	System.out.println("Enter Manufacturer Name : ");
				            	String invCarManufac = input.nextLine();
				            	System.out.println("Enter Car Manufactur Year : ");
				            	String invCarManufacYear = input.nextLine();
				            	System.out.println("Enter Car Mileage : ");
				            	double invCarMileage = input.nextDouble();
				            	input.nextLine();
				            	System.out.println("Enter Car Color : ");
				            	String invCarColor = input.nextLine();
				            	
				            	CAR carInventory = new CAR(invID,invCarName,invCarModel,invCarPrice,invCarManufac,invCarManufacYear,invCarMileage,invCarColor);
				            	cars.add(carInventory);
				            	int carNo = 0;
								System.out.println("Specification of Car no. "+(carNo ++)+ " : ");
				            	System.out.println(carInventory.toString());
				            	break;
				            	
				            	 }
				            	 oos.writeObject(cars);
			            		    System.out.println("Cars data saved successfully.");
			            		    
			            		    oos.close();
			            		    fos.close();
			            		} catch (IOException e) {
			            		    System.out.println("Error while saving cars data: " + e.getMessage());
			            		}
				            	break;
				            }
				            case 4 : {
				                try (FileInputStream cfis = new FileInputStream("cars.txt");
				                	     ObjectInputStream cois = new ObjectInputStream(cfis)) {
				                	
				            	  cars= (ArrayList<CAR>) cois.readObject();
			                	   
				            	System.out.println("*****List of Cars*****");
			                	System.out.println("Specification of Available Car ");	
			                	for (int j = 0; j <cars.size(); j++) {
			                	    System.out.println("\n"+ cars.get(j)+"\n");
								}
			                	cois.close();
			                	cfis.close();
			               
				                } catch (IOException | ClassNotFoundException e) {
			                	    System.out.println("Error while loading cars data: " + e.getMessage());
			                	}
				                

				                break;
				            }
				            case 5 :{
                            try (FileOutputStream fos = new FileOutputStream("PurchasedCarCustomerList.txt");
		            		     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
		            		input.nextLine(); // consume newline character
		            		System.out.println("Enter Car ID to buy for the customer: ");
		            		int carID = input.nextInt();
		            		
					    	System.out.println("Congratulations! You have purchased the Car. ");
					    	
					    	
					    	for (int x = 0; x < cars.size(); x++){
					            if (cars.get(x).getCarID() == carID){           
					                PurchasedcarList.add(cars.get(x));
					                cars.remove(cars.get(x));

					                System.out.println("You have purchased a car, car count " + cars.size());
					                System.out.println("purchased car count " + PurchasedcarList.size());
					                System.out.println("Car Information - ");
					                System.out.println( PurchasedcarList.toString());
					            }
					         else {
					            System.out.println("Sorry, the car you have selected is not available.");
					        }                                                             
					    }
					    	
					    	
					    	oos.writeObject(cars);
		            	   
					    	oos.close();
					    	fos.close();
		            	} catch (IOException e) {
		            	   System.out.println("Error while saving cars data: " + e.getMessage());
		            	}
		            	break;
				            }
				            case 6 : {
				            	
				            	boolean InnerinnerInnerExit = false;
				            	while (!InnerinnerInnerExit) {
									System.out.println("\n");
									System.out.println("1. Search by Car ID");
									System.out.println("2. Search by Car Name");
									System.out.println("3. Search by Manufacturer Name");
									System.out.println("4. Search by Manufactur Year");
									System.out.println("5. Exit");
									System.out.println("Enter Search Option : ");
									int searchoption = input.nextInt();	
									switch(searchoption) {
									case 1 :{
										System.out.println("Enter Car ID : ");
										int cId = input.nextInt();
									    boolean carFound = false;

										for (int j = 0; j < cars.size(); j++) {
											if (cId == cars.get(j).getCarID()) {
												System.out.println(cars.get(j).toString());
												 carFound = true;
										            break;
											}
											
										}
										if (!carFound) {
											System.out.println("Car Not Found!");

										}
										break;
									}
									case 2:{
										System.out.println("Enter Car Name : ");
						            	input.nextLine();
						            	String cName = input.nextLine();
									    boolean carFound = false;

										for (int j = 0; j < cars.size(); j++) {
											if (cName.equals(cars.get(j).getCarName())) {
												System.out.println(cars.get(j).toString());
												carFound = true;
												break;
												
											}
											
										}
										if (!carFound) {
											System.out.println("Car Not Found!");

										}
										break;

									}
									case 3: {
										System.out.println("Enter Car Manufacturer Name : ");
										input.nextLine();
						            	String cManufac = input.nextLine();
									    boolean carFound = false;

						            	for (int j = 0; j < cars.size(); j++) {
											if (cManufac.equals(cars.get(j).getManufacturer())) {
												System.out.println(cars.get(j).toString());
												carFound = true;
												break;
											}
										
										}	
						            	if (!carFound) {
											System.out.println("Car Not Found!");

										}
						            	break;
									}
									
									case 4: {
										System.out.println("Enter Car Manufacturer Year : ");
										input.nextLine();
						            	String cManufacYear = input.nextLine();
									    boolean carFound = false;

						            	for (int j = 0; j < cars.size(); j++) {
											if (cManufacYear.equals(cars.get(j).getManufacturerYear()) ) {
												System.out.println(cars.get(j).toString());
												carFound = true;
												break;
											}
											
										}
						            	if (!carFound) {
											System.out.println("Car Not Found!");

										}
						            	break;
									}
									case 5 :{ 
										InnerinnerInnerExit = true;
										break;
									}
									default :{
										System.out.println("Invaid operation!!!(Choose between 1 to 5)\n~~~Program exit!~~~");
									break;
									}
									
									}
				            	}
				            	
				            
				            	break;
				            }
				          
				            case 7:{
								System.out.println("Logged out !");
				                innerInnerExit = true;
				                break;
							}
				            //option 8 print customer list starts here 
				       
							default :
								System.out.println("Invaid operation!!!(Choose between 1 to 7)\nProgram exit!");
				                break;
				
							}// innerinner Switch ends 
				            
		   // Option 1 ends here for salesman
				            
							} 
					            
     //Salesman Profile ends here...
							}
						 // if condition ends 
						if(!isloggedin) {
							System.out.println("Invalid Name or password...");
						}
						}//for loop ends 
						ois.close();
						fis.close();
						}catch (Exception e) {
							break	;
							}
						
						}
						  catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						break;
						} 
				//Case 2 : Salesman Login Process ends here
				
			case 3:{
					   innerExit = true;
	                    break;
				}
			}
		}
			break;
		}

		
		case 3:{
			exit = true;
            break;
    	}
    	
		default :{
			System.out.println("Invaid operation!!!(Choose between 1 to 3)\nProgram exit!");
		}
	} // reg or login switch ends
        if (!exit) {
        }	
		  System.out.println("Have a relax, see you not for mind!😜");
		 } //while loop ends
		 catch (InputMismatchException e) {
			  System.out.println("Invalid input. Please enter a number.");
	            input.nextLine(); // Clear the invalid input from the scanner
		 }
	}
	
	}
}