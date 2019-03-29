package xmlUtils;

import org.apache.log4j.Logger;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlUtils {
    private static Logger logger = Logger.getLogger(XmlUtils.class);

    public static void encodeToXMLformat(Object objectToEncode, String fileName) {
        XMLEncoder xmlEncoder = null;
        try {
            xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            xmlEncoder.writeObject(objectToEncode);
            logger.info("Object encoded successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("File not fount, probably");
        } finally {
            xmlEncoder.close();
        }
    }
}
