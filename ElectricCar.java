// Kingly Yee
// ID# 500910530
public class ElectricCar extends Car{
//Electric car Instance variables
  private int rechargeTime;
  private String batteryType;
//Initializing the instance variables 3. PART A
  public ElectricCar(String manufac,String col2, int powe, int numOfWheels, int mod, int mRange,double sRating, boolean AllWD, double cost, int rechargeT){
    super(manufac,col2,powe,numOfWheels,mod,mRange,sRating,AllWD,cost);
    this.rechargeTime = rechargeT;
    this.batteryType = "EL. BAT: Lithium"; 
  }

//Get methods 3. PART B
  public int getRecharge(){return rechargeTime;}
  public String getBatteryType(){return batteryType;}

//Set methods 3. PART break;
  public void setRechargeTime(int recTime){rechargeTime = recTime;}
  public void setBatteryType(String batteryT){batteryType = batteryT;}

//Display method 3. PART C
  public String display(){
    return(super.display() + " " + batteryType + " RCH: " + rechargeTime);
  }
}
