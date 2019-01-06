package com.github.chandanv89.telephonedirectory.utility;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Utilities.
 */
public class Utilities {
    private static final Logger LOGGER = LogManager.getLogger(Utilities.class);

    private Utilities() {
        // do not allow instantiating this class!
    }

    /**
     * To string.
     *
     * @param object the object
     * @return the string
     */
    public static String toString(Object object) {
        if (object == null) {
            return "{}";
        }

        try {
            return new ObjectMapper()
                    .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
                    .writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.warn(Utilities.class.getSimpleName(), "Exception @ toString!", e);
            return object.toString();
        }
    }

    /**
     * Current date string in the format <code>yyyy/MM/dd HH:mm:ss</code>.
     *
     * @return the string
     */
    public static String currentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
