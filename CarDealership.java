// Kingly Yee
// ID# 500910530
//import java.time.DayOfWeek;
import java.util.*;

public class CarDealership{
// Instance ArrayList
    private ArrayList<Car> cars;
    private double minimumPrice;
    private double maximumPrice;
    private AccountingSystem system;
    private SalesTeam sales;

    private boolean onlyElectric = false; //filter
    private boolean onlyAWD = false; // filter
    private boolean onlyPriceRange = false; //filter
    private boolean sortPrice = false;
    private boolean sortSafety = false;
    private boolean sortMaxRange = false;

//Initialize instance ArrayList
    public CarDealership(){
        ArrayList<Car> newCars = new ArrayList<Car>();
        system = new AccountingSystem();
        sales = new SalesTeam();
        
        cars = newCars;
        minimumPrice = 0;
        maximumPrice = 0;

        onlyElectric = false; //filter
        onlyAWD = false; // filter
        onlyPriceRange = false; //filter
        sortPrice = false;
        sortSafety = false;
        sortMaxRange = false;     

    }

//4. PART B Add new cars to the list
    public void addCars(ArrayList<Car> newCars){
        for(int j = 0; j < newCars.size() ; j++){
            cars.add(newCars.get(j));
		}
    }
    public int getSize(){return cars.size();}

//4. PART C If conditions are right, remov0e the selected indexed car
    public String buyCar(int VIN){
        String seller = "";
        String receipt = "";
        String action = "buy";

        Car boughtCar = null;

        double price = 0;
        boolean found = false;

        Random random = new Random();
        //SalesTeam sales = new SalesTeam();
        Calendar calendar = new GregorianCalendar();
        //AccountingSystem system = new AccountingSystem();

        seller = sales.salesPerson();

        int day;
        int month = random.nextInt(Calendar.DECEMBER + 1);
        int year = 2019; // Year always 2019

        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        day = random.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
        calendar.set(Calendar.DAY_OF_MONTH, day);

        if(cars.size() > 0){
            for(int i = 0; i < cars.size(); i ++){
                if(cars.get(i).getVIN() == VIN){

                    boughtCar = (Car) (cars.get(i));
                    price = boughtCar.getPrice();
                    receipt = system.add(calendar, boughtCar, seller, action, price);

                    cars.remove(i);
                    found = true;
                } 
            }
        } else {
            return ("The ArrayList is Empty!");
        }

        if(found){
            sales.updateSellerNumbers(seller,action);
            system.updateMonthNumbers(calendar,action);
            return receipt;
        } else {
            return ("Such VIN does not exist");
        }


        /* Car recentCar = null;
        if( (index <= cars.size()) && (index >= 0) && (cars.size() > 0)){
            recentCar = cars.get(index);
            cars.remove(cars.get(index));
            return recentCar;
            
        } else {
            System.out.println("That car number does not exist");
            return null;
        }

        */
        // A1 CODE
    }
    public AccountingSystem getInfo(){
        return system;
    }

    public SalesTeam getSalesInfo(){
       return sales;
    }
//4. PART D Append the car reference back into arraylist
    public String returnCar(String transaction){
        // if(car != null){cars.add(car);} A1 CODE
        /*Car returnedCar = null; 
        AccountingSystem system = new AccountingSystem();
        Random random = new Random();
        Calendar calendar = new GregorianCalendar();
        Transaction trans;
*/     
/*
        Random random = new Random();
        Transaction mostRecent = system.getTransaction(transaction);
        Calendar returnDate = mostRecent.getDayOfPurchase();
        String output = "";
        */
        Random random = new Random();
        Calendar returnDate = new GregorianCalendar();
        

        String output = "";
        if(!transaction.equals("") && !transaction.equals(null)){
            Scanner sc = new Scanner(transaction);
            sc.next();
            int id = sc.nextInt();
            Transaction boughtCar = system.getTransaction(id);

            sales.updateSellerNumbers(boughtCar.getSalesPerson(), "ret");
            system.updateMonthNumbers(boughtCar.getDayOfPurchase(), "ret");

            Calendar currentDate = boughtCar.getDayOfPurchase();
            int maxDay = returnDate.getActualMaximum(Calendar.DAY_OF_MONTH) + 1;
            int minDay = returnDate.get(Calendar.DAY_OF_MONTH);
    
            int newDay = maxDay;
            if( (maxDay - minDay) != 0){
                newDay = random.nextInt((maxDay - minDay) + 1) + minDay;
            } 
            
            returnDate.set(Calendar.YEAR, 2019);
            returnDate.set(Calendar.MONTH, currentDate.get(Calendar.MONTH));
            returnDate.set(Calendar.DAY_OF_MONTH, newDay);      
            cars.add(boughtCar.getCar());
            
            output = system.add(returnDate, boughtCar.getCar(), boughtCar.getSalesPerson(), "ret", boughtCar.getPrice());
        }

        return (output);
        
    }

    public void displayInventory(){
       // ArrayList<Car> updatedList = new ArrayList<Car>();


        for(int i = 0; i < cars.size(); i++){
            if (onlyElectric && onlyAWD && onlyPriceRange){
                Car theCar = (Car) cars.get(i);
                if((theCar.getPower() == 0) && (theCar.getAWD() == true) && (theCar.getPrice() > minimumPrice && theCar.getPrice() < maximumPrice)){
                    System.out.print(theCar.display());
                    System.out.println();
                }
            } else if (!onlyElectric && onlyAWD && onlyPriceRange){
                Car theCar = (Car) cars.get(i);
                if((theCar.getAWD() == true) && (theCar.getPrice() > minimumPrice && theCar.getPrice() < maximumPrice)){
                    System.out.print(theCar.display());
                    System.out.println();
                }

            } else if (onlyElectric && !onlyAWD && onlyPriceRange){
                Car theCar = (Car) cars.get(i);
                if((theCar.getPower() == 0) && (theCar.getPrice() > minimumPrice && theCar.getPrice() < maximumPrice)){
                    System.out.print(theCar.display());
                    System.out.println();
                }

            } else if (onlyElectric && onlyAWD && !onlyPriceRange){
                Car theCar = (Car) cars.get(i);
                if((theCar.getPower() == 0) && (theCar.getAWD() == true)){
                    System.out.print(theCar.display());
                    System.out.println();
                }

            } else if (!onlyElectric && !onlyAWD && onlyPriceRange){
                Car theCar = (Car) cars.get(i);
                if( (theCar.getPrice() >= minimumPrice && theCar.getPrice() <= maximumPrice)){
                    System.out.print(theCar.display());
                    System.out.println();
                }
            } else if (!onlyElectric && onlyAWD && !onlyPriceRange){
                Car theCar = (Car) cars.get(i);
                if( (theCar.getAWD() == true)){
                    System.out.print(theCar.display());
                    System.out.println();
                }
            } else if (onlyElectric && !onlyAWD && !onlyPriceRange){
                Car theCar = (Car) cars.get(i);
                if((theCar.getPower() == 0)){
                    System.out.print(theCar.display());
                    System.out.println();
                }
            } else {
                Car theCar = (Car) cars.get(i);
                System.out.print(theCar.display());
                System.out.println();
            }
        }

    }
   // what does it mean to implement what you want to have happen

    public void filterByElectric(){
        if(onlyElectric == false){onlyElectric = true;}
    }

    public void filterByAWD(){
        if(onlyAWD == false){onlyAWD = true;}
    }

    public void filterByPrice(double minPrice, double maxPrice){
        this.minimumPrice = minPrice;
        this.maximumPrice = maxPrice;


        if(onlyPriceRange == false){onlyPriceRange = true;}
    }

    public void sortByPrice(){
        if(sortPrice == false){sortPrice = true;}
        Collections.sort(cars);
    }
    class safetyComparison implements Comparator<Car>{
        public int compare(Car a, Car b){
            if(a.getSafetyRating() < b.getSafetyRating())
            { 
                return 1;
            } 
            else if(a.getSafetyRating() > b.getSafetyRating())
            {
                return -1;
            } 
            else 
            {
                return 0; 
            }
        }
    }

    public void sortBySafetyRating(){
        if(sortSafety == false){sortSafety = true;}
        Collections.sort(cars, new safetyComparison());


    }
    class maxRangeComparison implements Comparator<Car>{
        public int compare(Car a, Car b){
            if(a.getMaxRange() < b.getMaxRange())
            { 
                return 1;
            } 
            else if(a.getMaxRange() > b.getMaxRange())
            {
                return -1;
            } 
            else 
            {
                return 0; 
            }
        }
    }
    public void sortByMaxRange(){
        if(sortMaxRange == false){sortMaxRange = true;}
        Collections.sort(cars, new maxRangeComparison());

        
    }

    public void filtersClear(){
        onlyElectric = false; //filter
        onlyAWD = false; // filter
        onlyPriceRange = false; //filter

        sortPrice = false;
        sortSafety = false;
        sortMaxRange = false;
    }
}
