package step3.domain;

import java.util.*;

public class Winners {

    private static List<String> winners;

    public static List<String> findWinners(Map<String, Car> carInfoMap, int positionMax) {
        winners = new ArrayList<>();

        for (String carName : carInfoMap.keySet()) {
            Car car = carInfoMap.get(carName);
            verifyWinner(winners, car, positionMax);
        }
        return winners;
    }

    private static List<String> verifyWinner(List<String> winnerNames, Car car, int positionMax) {
        if (car.getPosition() == positionMax) {
            winnerNames.add(car.getCarName());
        }
        return winnerNames;
    }

    public static int findMaxPosition(Map<String, Car> carInfoMap) {
        return carInfoMap.values()
                .stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .position;
    }
}