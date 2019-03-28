package xmlUtils;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlUtils {
    public static void encodeToXMLformat(Object objectToEncode, String fileName) {
        XMLEncoder xmlEncoder = null;
        try {
            xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            xmlEncoder.writeObject(objectToEncode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            xmlEncoder.close();
        }
    }
}
