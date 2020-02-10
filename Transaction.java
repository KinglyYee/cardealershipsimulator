//Name: Kingly Yee
//ID: 500910530
import java.text.SimpleDateFormat;
import java.util.*;

public class Transaction{
    private int id;
    private Calendar dateOfPurchase;
    private Car car;
    private String salesPerson;
    private String type;
    private double price;

    public Transaction(int identity, Calendar date, Car aCar, String seller, String recordType, double cost){
        this.id = identity;
        this.dateOfPurchase = date;
        this.car = aCar;
        this.salesPerson = seller;
        this.type = recordType.toLowerCase();
        this.price = cost;
    }

    public String display(){
        String output = "";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, YYYY");
        output = "id: " + id + " " + sdf.format(dateOfPurchase.getTime()) + " " + type +  " SalesPerson: " + salesPerson + " Car: " + car.display();
        return output;
    }

    // Get Methods for general purpose
    public int getTransactionID(){return id;}
    public Calendar getDayOfPurchase(){return dateOfPurchase;}
    public Car getCar(){return car;}
    public String getSalesPerson(){return salesPerson;}
    public String getType(){return type;}
    public double getPrice(){return price;}
}