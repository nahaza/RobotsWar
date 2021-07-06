import java.util.HashMap;

public class Robot {
    private int robotLife;
    private String robotName;
    private HashMap<String, Integer> damageKeyMap;
    private int shootingDamage;

    public Robot(int robotLife, String robotName, HashMap<String, Integer> damageKeyMap) {
        this.robotLife = robotLife;
        this.robotName = robotName;
        this.damageKeyMap = damageKeyMap;
    }

    public int getRobotLife() {
        return robotLife;
    }

    public String getRobotName() {
        return robotName;
    }

    public String displayRobotLife() {
        return getRobotName() + ", " + getRobotLife();
    }

    public HashMap<String, Integer> getDamageKeyMap() {
        return damageKeyMap;
    }

    public boolean isActiveDamageKey(String element) {
        DamageKey damageKey = new DamageKey();
        if (damageKey.isShootingKey(element)) {
            if (damageKeyMap.containsKey(element)) {
                return true;
            }
        }
        if (!damageKey.isExitKey(element))
            System.out.println("The key " + element + " has been already used");
        return false;
    }

    public Integer getDamageValue(String element) {
        Integer damageValue = damageKeyMap.getOrDefault(element, 0);
        return damageValue;
    }


    public HashMap<String, Integer> removeElementFromDamageMap(String element) {
        if (isActiveDamageKey(element)) {
            Integer damageValue = getDamageValue(element);
            if (damageValue > 0) {
                robotLife -= getDamageValue(element);
                System.out.println("Good shot. Ba-bah. -" + damageValue);
            }

            damageKeyMap.remove(element);
        }
        return damageKeyMap;
    }
}
