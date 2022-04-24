package model;

public class Car {
    private String carName;
    private int carLocation;

    public Car(String carName){
        this.carName = carName;
    }

    public String getCarName(){
        return carName;
    }

    public void go(){
        carLocation++;
    }
}
