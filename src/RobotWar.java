import java.util.HashMap;

public class RobotWar {
    public static void main(String[] args) {
        DamageKey damageKey = new DamageKey();
        DataFromConsole dataFromConsole = new DataFromConsole();
        String robot1Name = dataFromConsole.getRobotNameFromConsole();
        String robot2Name = dataFromConsole.getRobotNameFromConsole();
        HashMap<String, Integer> robot1DamageMap = damageKey.damageMap();
        HashMap<String, Integer> robot2DamageMap = damageKey.damageMap();
        //Disclosed DamageMap to be deleted, they are displayed to check the app quickly
        System.out.println(robot1DamageMap);
        System.out.println(robot2DamageMap);
        Robot robot1 = new Robot(100, robot1Name, robot1DamageMap);
        Robot robot2 = new Robot(100, robot2Name, robot2DamageMap);
        ListOfRobots listOfRobots = new ListOfRobots();
        listOfRobots.addRobot(robot1);
        listOfRobots.addRobot(robot2);
        boolean isFinish = false;
        String shootingKey1;
        do {
            for (int i = 0; i < ListOfRobots.getRobotList().size(); i++) {
                Robot currentRobot = ListOfRobots.getRobot(i);
                shootingKey1 = dataFromConsole.getShootingKeyFromConsole(currentRobot.getRobotName());
                if (shootingKey1.equals("L")) {
                    System.out.println("Goodbye");
                    isFinish = true;
                    break;
                } else if (damageKey.isShootingKey(shootingKey1)) {
                    currentRobot.removeElementFromDamageMap(shootingKey1);
                    if (currentRobot.getRobotLife() <= 0) {
                        System.out.println(currentRobot.getRobotName() + " was killed.");
                        listOfRobots.removeRobot(currentRobot);
                        if (ListOfRobots.getRobotList().size() == 1) {
                            System.out.println("The winner is " + ListOfRobots.getRobot(0).getRobotName());
                        }
                        isFinish = true;
                        break;
                    }
                } else
                    i -= 1;
            }
            System.out.println("------------");
            for (int j = 0; j < ListOfRobots.getRobotList().size(); j++) {
                System.out.println(ListOfRobots.getRobotList().get(j).displayRobotLife());
            }
            System.out.println("------------");
        }
        while (ListOfRobots.getRobotList().size() > 0 & !isFinish);
    }
}