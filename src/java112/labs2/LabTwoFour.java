package java112.labs2;
import java.util.*;

public class LabTwoFour {
    Map<String, Integer> labMap;
    public static void main(String[] args) {
        LabTwoFour labTwoFour = new LabTwoFour();
        labTwoFour.run();

    }

    public void run() {
        labMap = new HashMap<>();
        labMap.put("One", 1);
        labMap.put("Two", 2);
        labMap.put("Three", 3);
        
        for (Map.Entry<String, Integer> entryMap : labMap.entrySet()) {
            System.out.println("Key: " + entryMap.getKey() + ", Value: " + entryMap.getValue());
        }

    }
}