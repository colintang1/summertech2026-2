public class Car {
    //attributes
    private int wheelnumber;
    private int steeringwheel;
    private String model;
    private int mileage;
    
    //Constructor
    public Car(int wn, int s, String m){
        wheelnumber = wn;
        steeringwheel = s;
        model = m;
        mileage = 0;
    }
    public Car(int s, String m){
        wheelnumber = 4;
        steeringwheel = s;
        model = m;
        mileage = 0;
    }
    //Getters
    public int GetWheelNumber(){
        return wheelnumber;   
    }
    //Setters
    public void IncreaseMileage(int milesToIncrease){
        mileage += milesToIncrease;
    }
    public String toString(){
        return model + " Car with " + wheelnumber + " wheels, " + steeringwheel + " steering wheels, and " + mileage + " mileage.";
    }
}
