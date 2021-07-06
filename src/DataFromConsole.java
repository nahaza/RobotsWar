import com.sun.istack.internal.NotNull;

import java.util.Scanner;

public class DataFromConsole {
    public String getRobotNameFromConsole() {
        System.out.println("Enter the name of Robot:");
        Scanner scanner = new Scanner(System.in);
        String robotNameFromConsole = scanner.nextLine();
        while (robotNameFromConsole.isEmpty()) {
            System.out.println("The name cannot be empty. Enter the name of Robot:");
            robotNameFromConsole = scanner.nextLine();
        }
        return robotNameFromConsole;
    }


    public String getShootingKeyFromConsole(String robotName) {
        System.out.println("To exit from the game enter L");
        System.out.println("Shoot at robot: " + robotName);
        System.out.println("Your step: press key (QWEASDZXC)");
        Scanner scanner = new Scanner(System.in);
        String shootingKeyFromConsole = scanner.nextLine();
        return shootingKeyFromConsole;
    }
}

