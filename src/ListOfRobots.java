import currency.Currency;

import java.util.ArrayList;


public class ListOfRobots {
    private static ArrayList<Robot> robotList = new ArrayList();

    public static void addRobot(Robot robot) {
        robotList.add(robot);
    }

    public static void removeRobot(Robot robot) {
        robotList.remove(robot);
    }

    public static Robot getRobot(int i) {
        return robotList.get(i);
    }

    public static ArrayList<Robot> getRobotList() {
        return robotList;
    }
}