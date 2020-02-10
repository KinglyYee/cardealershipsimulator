// Kingly Yee
// ID# 500910530
import java.util.Random;

public class Vehicle{

  public static final int ELECTRIC_MOTOR = 0;
  public static final int GAS_ENGINE = 1;
  public static final int MAX = 499;
  public static final int MIN = 100;
// Instance Variables
  private String mfr; // Manufacturer
  private String color;
  private int power;
  private int numWheels;
  private int VIN;


//Initialize Instance Variables 1. PART A
  public Vehicle(String manuf, String col, int pow, int numberW) {
    this.mfr = manuf;
    this.color = col;
    this.power = pow;
    this.numWheels = numberW;

    Random random = new Random();
    int randomInt = random.nextInt((MAX - MIN) + 1) + MIN;
    this.VIN = randomInt;
  }
// Get Methods 1. PART B
  public String getManufacturer(){return mfr;}
  public String getColor(){return color;}
  public int getPower(){return power;}
  public int getNumWheels(){return numWheels;}
  public int getVIN(){return VIN;}

// Set Methods 1. PART B
  public void setManufacturer(String newMFR){mfr = newMFR;}
  public void setColor(String newColor){color = newColor;}
  public void setPower(int newPower){power = newPower;}
  public void setNumWheel(int newWheels){numWheels = newWheels;}

// Test Vehicle equalitiy 1. PART C
  public boolean equals(Object other){
    Vehicle otherVehicle = (Vehicle)(other);
    // If manufacturer,power and number of wheels are equal then vehicles are equal
    if(     (mfr.equals(otherVehicle.getManufacturer()))  &&  (power == otherVehicle.getPower())   &&   (numWheels == otherVehicle.getNumWheels())    ){
      return true;
    } else {
      return false;
    }
  }
//Display methods 1. PART D
  public String display(){
    return("VIN: " + this.VIN + " " + this.mfr + " " + this.color);
  }
}
