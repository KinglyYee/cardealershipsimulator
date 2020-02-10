// Kingly Yee
// ID# 500910530
public class Car extends Vehicle implements Comparable<Car>{

// Constants used for model
  public static final int SEDAN = 0;
  public static final int SUV = 1;
  public static final int SPORTS = 2;
  public static final int MINIVAN = 3;

// Instance Variables
  private int model;
  private int maxRange;
  private double safetyRating;
  private boolean AWD; // All Wheel Drive
  private double price;

// Initializing the Instance Variable 2. PART A
  public Car(String manufa,String col1, int pow, int numberWheels, int mod, int mRange,double sRating, boolean AllWD, double cost){
    //Super class constructor takes manufacturer,color, power and number of Wheels
    super(manufa,col1,pow,numberWheels);

    //Car Instance Variables
    this.model = mod;
    this.maxRange = mRange;
    this.safetyRating = sRating;
    this.AWD = AllWD;
    this.price = cost;
  }

  public String convertModel(){
    String currentModel = "";
    
    switch(model){
      case SEDAN:
        currentModel = "SEDAN";
        break;
      case SUV:
        currentModel = "SUV";
        break;
      case SPORTS:
        currentModel = "SPORTS";
        break;
      case MINIVAN:
        currentModel = "MINIVAN";
    }

    return currentModel;
  }
// Overriding the display method 2. PART B -----------------------------------------------------
  public String display(){
    return(super.display() + " " + convertModel() + " $" + price + " SF: " + safetyRating + " RNG: " + maxRange);
  }

  // Car equality check method 2. PART C -------------------------------------------------------
  public boolean equals(Object other){
    Car otherCar = (Car)(other);
  // Calls super method equals to compare manufacturer, power and numWheels 
    boolean j = super.equals(otherCar);
    boolean k = false;

    if( (convertModel().equals(otherCar.convertModel()))  &&  (AWD == otherCar.AWD) ){
      k = true;
    }

    if(j && k){return true;}

    return false;
  }

  public boolean getAWD(){return AWD;}
  public double getPrice(){return price;}
  public double getSafetyRating(){return safetyRating;}
  public int getMaxRange(){return maxRange;}

  // Comparing the price of this car object with other car object ------------------------------
  public int compareTo(Car other){
    if(price > other.price){
      return 1;
    } else if(price < other.price){
      return -1;
    } else {
      return 0;
    }
  }
}
