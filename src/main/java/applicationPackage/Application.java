package applicationPackage;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    private final static String DECODED_FILE_NAME = "decod.txt";

    public static void main(String[] args) {
        List<Map<List<Set<Integer>>, String>> list = createMultiLayoutList();
        XMLEncoder xmlEncoder = null;
        try {
            xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(DECODED_FILE_NAME)));
            xmlEncoder.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            xmlEncoder.close();
        }
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
