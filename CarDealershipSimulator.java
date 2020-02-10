// Name: Kingly Yee
// ID: 500910530
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarDealershipSimulator 
{
    public static void main(String[] args)
    {
	  // Create a CarDealership object
	  	  
	  // Then create an (initially empty) array list of type Car
      // Then create some new car objects of different types
		// See the cars file for car object details
	ArrayList<Car> newCars = new ArrayList<Car>();
		
// Normal Car object parameters: String name, String color, int model, int Powersoure, double safetyRating, maxRange,boolean AWD, int price
// Electric car object parameters: String name, String color, int model. int PowerSource, double safetyRating, maxRange, boolean AWD, int price, int RCH
/*

*/
	// Objects to call methods
	CarDealership carObj = new CarDealership();
	
	AccountingSystem saleSystem = carObj.getInfo();
	SalesTeam salesTeam = carObj.getSalesInfo();
	String manufac; String color; int carPower; 
	int numbWheels; int modelx; int mxRange;
	double safeRate; int rcH;

		
	try {
		File inputFile = new File("cars.txt");
		Scanner scanner = new Scanner(inputFile);
		ArrayList<String> carParameters = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String sentence = scanner.nextLine();
			Scanner scanner2 = new Scanner(sentence);

			while(scanner2.hasNext()){
				carParameters.add(scanner2.next());
			}
			// Using the parameters to make a new car object to add
		
			manufac = carParameters.get(0); color = carParameters.get(1); carPower = Integer.parseInt(carParameters.get(2));
			numbWheels = Integer.parseInt(carParameters.get(3)); modelx =  Integer.parseInt(carParameters.get(4)); mxRange = Integer.parseInt(carParameters.get(5));
			safeRate = Double.parseDouble(carParameters.get(6)); boolean awdrive = Boolean.parseBoolean(carParameters.get(7)); double money = Double.parseDouble(carParameters.get(8));
		
			if(carParameters.size() == 9){
				//Gas Engine
				newCars.add(new Car(manufac, color, carPower, numbWheels, modelx, mxRange, safeRate, awdrive, money));
			} else {
				// Electric Motor
				rcH = Integer.parseInt(carParameters.get(9));
				newCars.add(new ElectricCar(manufac, color, carPower, numbWheels, modelx, mxRange, safeRate, awdrive, money, rcH));
			}

			scanner2.close();

			carParameters.clear();
		}
		scanner.close();

	} catch (IOException exception) {
		System.out.println(exception.getMessage());
	} catch (NumberFormatException exception){
		System.out.println("Arguments do not line up");
	} catch (IndexOutOfBoundsException exception) {
		System.out.println("The lengths do not line up in text file");
	}

	  // Add the car objects to the array list
      // The ADD command should hand this array list to CarDealership object via the addCars() method	  
		// Create a scanner object

		// Initialize words and numbers
	Scanner sc = new Scanner(System.in);
	String input = ""; 
	String firstWord = "";
	int secondWord = 0;
	int thirdWord= 0;
	String secondWord1 = "";
	String receipt = "";
	// Car boughtCar = null;

	do{
		//Check if there is user input
		if(sc.hasNextLine()){
			input = sc.nextLine();
			Scanner commandLine = new Scanner(input);
			String output = "";
			// Set firstword as -1 to skip empty spaces
			if(!input.isEmpty()){
				input.toLowerCase();
				firstWord = commandLine.next();
				firstWord = firstWord.toLowerCase();
			} else {
				firstWord = "-1";
			}

			if(firstWord.equals("buy")){
				if (commandLine.hasNextInt()){
					secondWord = commandLine.nextInt();
					if( (secondWord >=0 && (newCars.size() > 0) )){
						

						output = carObj.buyCar(secondWord);

						for(int i = 0 ; i < newCars.size(); i++){
							if(newCars.get(i).getVIN() == secondWord){
								newCars.remove(i);
								
							}
						}
						receipt = output;
						System.out.println(output);
					}           
				} else {
					//If they do not enter a valid buy + ___ invalid output
					System.out.println("Invalid input");
				}

			} else if(firstWord.equals("fpr")){
				//Check to see if user puts in correct values after the fpr command
				if(commandLine.hasNextInt()){
					secondWord = commandLine.nextInt();
				} else {
					System.out.println("Not a valid number input after the command");
				}

				if(commandLine.hasNextInt()){
					thirdWord = commandLine.nextInt();
					if( (secondWord > 0) && (secondWord < thirdWord) ){
						carObj.filterByPrice(secondWord,thirdWord);
					} else {
						//
					}
				} else {
					System.out.println("Not a valid number input after the command");
				}
					// Sales for month
			// Display list method
			} else if(firstWord.equals("l")){
				System.out.println();
				carObj.displayInventory();

			// Return most recent car to the list
			} else if(firstWord.equals("ret")) {
				// Checks last receipt
				String returnreceipt = carObj.returnCar(receipt);
				System.out.println(returnreceipt);
				receipt = "";
			// Add the list into it 
			} else if(firstWord.equals("add")){
				carObj.addCars(newCars);
			// Sort them by price range
			} else if(firstWord.equals("spr")){
				carObj.sortByPrice();
			// Sort them by safety rating
			} else if(firstWord.equals("ssr")){
				carObj.sortBySafetyRating();
			} else if(firstWord.equals("smr")){
			// Sort them by max range
				carObj.sortByMaxRange();
			} else if(firstWord.equals("fel")){
			// Filter only electric vehicles
				carObj.filterByElectric();
			} else if(firstWord.equals("faw")){
			// Only want all wheel drive vehicles
				carObj.filterByAWD();
			} else if(firstWord.equals("fcl")){
			// Clear all filters
				carObj.filtersClear();
			} else if(firstWord.equals("q")){
			// Quit the program
				System.out.println("End of program");
				commandLine.close();
				return;

			} else if(firstWord.equals("sales")){
					// if first word is sales, check if its alone
						// print transaction list in 2019
				if(commandLine.hasNextInt()){
					int index = commandLine.nextInt();
					if(index <= 11 && index > 0){
						//passes in month
						saleSystem.getSalesOfMonth(index);
					} else {
						System.out.println("That's not a valid month index");
					}
				} else if(commandLine.hasNext()){
					secondWord1 = commandLine.next();
					secondWord1 = secondWord1.toLowerCase();
					// print all agents
					if(secondWord1.equals("team")){
						System.out.println(salesTeam.displayAgents());
						System.out.println();
					// print top seller
					} else if (secondWord1.equals("topsp")){
						System.out.println();
						System.out.println(salesTeam.getTopSeller());
					// print all stas
					} else if (secondWord1.equals("stats")){	
						saleSystem.getStats();
					} else {
						System.out.println("Invalid input");
					}
				} else {
					// input is only sales then print all transactions
					saleSystem.printTransactions();
				}
			} else {
				System.out.println("Invalid input");
			}


			
			commandLine.close();
		}
		System.out.println();
	} while(!input.equals("q"));
	sc.close();
		
    }			
}