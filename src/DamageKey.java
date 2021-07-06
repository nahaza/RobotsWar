import java.util.*;

public class DamageKey {
    static int numberOfShoottingKey = 9;
    static int numberOfDamageKey = 5;
    static int defaultShootingPower = 0;
    static int damageShootingPower = 20;
    public static ArrayList<String> shootingKey = new ArrayList<>();
    boolean shootingList = Collections.addAll(shootingKey, "Q", "W", "E", "A", "S", "D", "Z", "X", "C");


    public boolean isShootingKey(String element) {
        if (shootingKey.contains(element.toUpperCase())) {
            return true;
        } else if (!isExitKey(element)) {
            System.out.println("Wrong key. Please, use key from the scope of QWEASDZXC");
        }
        ;
        return false;
    }


    public boolean isExitKey(String element) {
        if (element == "L") {
            return true;
        } else return false;
    }

    public ArrayList<Integer> createShootingPowerArray() {
        ArrayList<Integer> shootingPowerList = new ArrayList<>();
        for (int i = 0; i < numberOfShoottingKey; i++) {
            shootingPowerList.add(defaultShootingPower);
        }
        return shootingPowerList;
    }

    public int generateRandomInteger() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(numberOfShoottingKey);
    }

    public ArrayList<Integer> createDamagePowerIndexArray() {
        ArrayList<Integer> damagePowerIndexArray = new ArrayList();
        do {
            int damagePowerIndex = generateRandomInteger();
            if (!damagePowerIndexArray.contains(damagePowerIndex)) {
                damagePowerIndexArray.add(damagePowerIndex);
            }
            Collections.shuffle(createShootingPowerArray());
        } while (damagePowerIndexArray.size() < numberOfDamageKey);
        Collections.sort(damagePowerIndexArray);
        return damagePowerIndexArray;
    }

    public ArrayList<Integer> fillingShootingPowerArray() {
        ArrayList<Integer> shootingPowerList = createShootingPowerArray();
        ArrayList<Integer> damagePowerList = createDamagePowerIndexArray();
        for (int i = 0; i < damagePowerList.size(); i++) {
            shootingPowerList.set(damagePowerList.get(i), damageShootingPower);
        }
        return shootingPowerList;
    }

    public HashMap<String, Integer> damageMap() {
        HashMap<String, Integer> damageMap = new HashMap<>();
        ArrayList<Integer> damagePowerListFilled = fillingShootingPowerArray();
        for (int i = 0; i < numberOfShoottingKey; i++) {
            damageMap.put(shootingKey.get(i), damagePowerListFilled.get(i));
        }
        return damageMap;
    }

}

