package applicationPackage;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static xmlUtils.XmlUtils.encodeToXMLformat;

public class Application {
    private final static String DECODED_FILE_NAME = "decod.txt";

    public static void main(String[] args) {
        List<Map<List<Set<Integer>>, String>> list = createMultiLayoutList();
        encodeToXMLformat(list, DECODED_FILE_NAME);
    }

    private static List<Map<List<Set<Integer>>, String>> createMultiLayoutList() {
        List<Map<List<Set<Integer>>, String>> list = new ArrayList<Map<List<Set<Integer>>, String>>();
        Set<Integer> set = new TreeSet<Integer>();
        Set<Integer> integerSet = new TreeSet<Integer>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        List<Set<Integer>> setList = new ArrayList<Set<Integer>>();
        setList.add(integerSet);
        Map<List<Set<Integer>>, String> map = new HashMap<List<Set<Integer>>, String>();
        map.put(setList, "First");
        list.add(map);
        return list;
    }
}
