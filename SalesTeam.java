//Name: Kingly Yee
//ID: 500910530
//import java.time.Month;

import java.util.*;
public class SalesTeam{
    private LinkedList<String> salesAgents;
    private Map<String, Integer> employeeSellers;
    public SalesTeam(){
        salesAgents = new LinkedList<String>();

        employeeSellers = new TreeMap<String,Integer>();

        salesAgents.add("Daredevil");
        salesAgents.add("Thanos");
        salesAgents.add("Ironman");
        salesAgents.add("Punisher");
        salesAgents.add("Blackwidow");

        for(int i = 0; i < salesAgents.size(); i++){
            employeeSellers.put(salesAgents.get(i), 0);
        }

    }

    public String salesPerson(){
        // using index of random to send an agent out
        int max = salesAgents.size();

        Random random = new Random();
        int index = random.nextInt(max);
        return salesAgents.get(index);
    }

    public String displayAgents(){

        // displays all agents usng an iterator
        String result = "";

        Iterator iter = salesAgents.iterator();
        
        while (iter.hasNext())
        {
            result = result + " " + iter.next();
        }

        return (result);
    }


    public String getTopSeller(){
        String output = "";
        int maximum = -1;
        String topseller = "";

        // goes through the key set to see which seller has the maximum
        for(String key: employeeSellers.keySet()){
            if(employeeSellers.get(key) > maximum){
                maximum = employeeSellers.get(key);
                topseller = key;
            }
        }
        // returning the output
        output = "Top SP: " + topseller + " " + maximum;
        return output;
    }

    public void updateSellerNumbers(String seller,String type){
        Integer f = employeeSellers.get(seller);
    // keep tracks of all buys
        if(type.equals("buy")){
            for(String key: employeeSellers.keySet()){
                if(key.equals(seller)){
                    employeeSellers.put(seller,f+1);
                }
            }
    // keep tracks of all returns
        } else if(type.equals("ret")) {
            for(String key: employeeSellers.keySet()){
                if(key.equals(seller)){
                    employeeSellers.put(seller,f-1);
                }
            }
        }
    }   

    // return number of agents
    public int numOfAgents(){return salesAgents.size();}
}