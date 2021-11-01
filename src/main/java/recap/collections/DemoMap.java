package recap.collections;

import java.util.HashMap;
import java.util.Map;

public class DemoMap {

    public static void main(String[] args) {
        // collections:
        // hash = random order
        // linked = ordered items
        // tree = sorted items
        Map myMap = new HashMap();
        myMap.put("userDto", Integer.valueOf(2));

        // objects that must be compared
        // equals - how are 2 objects equal (person by age)
        // hashcode - memory code used to compare 2 objects (will be generated base on age)
    }
}
