package service;

import model.BlackBox;
import model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRacingCompetition {

    private List<Car> joinCarList = null;

    private CarRacingCompetition(String strJoinCarList){
        this.joinCarList = new ArrayList<Car>();
        setJoinCarList(strJoinCarList);
    }

    public static CarRacingCompetition getCarRacingCompetion(String strJoinCarList){
        return new CarRacingCompetition(strJoinCarList);
    }

    public List<Car> startRacing(String strAccelCount) {
        int accelCount = convertStrAccelLimitToAccelCount(strAccelCount);
        startRacing(accelCount);
        return getResult();
    }

    private void startRacing(int accelCount) {
        for(Car car : joinCarList){
            car.tryAccel(accelCount);
        }
    }

    private List<Car> getResult(){
        return this.joinCarList;
    }

    private int convertStrAccelLimitToAccelCount(String strAccelCount) throws NumberFormatException{
        try{
            int result = Integer.parseInt(strAccelCount);
            if(result>=0){
                return result;
            }
            throw new IllegalStateException("0 미만의 숫자값이 입력되었습니다.");
        }catch (NumberFormatException e){
            throw new NumberFormatException("숫자가 아닌 다른 값이 입력되었습니다.");
        }
    }

    private void setJoinCarList(String strJoinCarList){
        checkNull(strJoinCarList, "참여하는 자동차의 명단이 null 입니다.");
        checkSpliterOnString(strJoinCarList);
        setJoinCarList(strJoinCarList.split(",", 0));
    }

    private void setJoinCarList(String[] arrJoinCarName){
        for(String joinCarName : arrJoinCarName){
            joinCarName = joinCarName.trim();
            checkSpaceOnString(joinCarName);
            checkNameLength(joinCarName);
            addCar(new Car(joinCarName, new BlackBox()));
        }
    }

    private void checkNameLength(String joinCarName) throws IllegalStateException {
        if(joinCarName.length()<=5){
            return;
        }
        throw new IllegalStateException("참가 자동차의 이름이 6글자 이상입니다.");
    }

    private void addCar(Car car){
        this.joinCarList.add(car);
    }

    private void checkSpaceOnString(String carName) throws IllegalArgumentException{
        if(!carName.equals("")){
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
