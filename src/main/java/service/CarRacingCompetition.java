package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRacingCompetition {

    private List<Car> joinCarList = null;

    private CarRacingCompetition(){
        this.joinCarList = new ArrayList<Car>();
    }

    public static void startRacing(String strJoinCarList){
        CarRacingCompetition carRacingCompetition = new CarRacingCompetition();
        carRacingCompetition.setJoinCarList(strJoinCarList);
    }

    private void setJoinCarList(String strJoinCarList) throws NullPointerException, IllegalArgumentException{
        checkNull(strJoinCarList, "참여하는 자동차의 명단이 null 입니다.");
        checkSpliterOnString(strJoinCarList);
        setJoinCarList(strJoinCarList.split(",", 0));
    }

    private void setJoinCarList(String[] arrJoinCarName){
        for(String joinCarName : arrJoinCarName){
            checkSpaceOnString(joinCarName);
            addCar(new Car(joinCarName));
        }
    }

    private void addCar(Car car){
        this.joinCarList.add(car);
    }

    private void checkSpaceOnString(String carName) throws IllegalArgumentException{
        if(!carName.contentEquals(" ")){
            return;
        }
        throw new IllegalArgumentException("참여 자동차명이 공백값 입니다.");
    }

    private void checkNull(String strCarList, String massage) throws NullPointerException{
        if(strCarList!=null){
            return;
        }
        throw new NullPointerException(massage);
    }

    private void checkSpliterOnString(String strCarList) throws IllegalArgumentException{
        if(!strCarList.contains(",,")) {
            return;
        }
        throw new IllegalArgumentException(",가 2개 이상 연속적으로 입력되었습니다.");
    }
}
