package ex1;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountFrequency {

    public static Map getFrequencyMap(Collection c) {
        Map res = new LinkedHashMap();
        for(Object el : c) {
            res.put(el, Collections.frequency(c, el));
        }
        return res;
    }
}
