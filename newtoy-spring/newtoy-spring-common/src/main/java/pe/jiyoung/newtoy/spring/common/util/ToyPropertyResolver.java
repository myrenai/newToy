package pe.jiyoung.newtoy.spring.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ToyPropertyResolver {

    private static Map<String, String> propertiesMap = new HashMap<String, String>();

    public void setLocations(final String[] locations) throws IOException {

        for(final String location : locations){
            final Resource resource = ToyResourceLoader.getResource(location);
            final Properties props = new Properties();
            props.load(resource.getInputStream());
            final Iterator iter = props.keySet().iterator();
            while(iter.hasNext()){
                final String key = (String) iter.next();
                final String value = props.getProperty(key);
                propertiesMap.put(key, value);
            }
        }
    }

    public static String getProperty(final String name) {
        return propertiesMap.get(name);
    }

    public static String setProperty(final String name, final String value) {
        return propertiesMap.put(name, value);
    }

    public static boolean getPropertyAsBoolean(final String key) {
        return Boolean.valueOf(propertiesMap.get(key));
    }

    public static int getPropertyAsInt(final String key) {
        return Integer.valueOf(propertiesMap.get(key));
    }

    public static Properties loadProperties(final String fileName) throws FileNotFoundException, IOException {
        final Resource resource = ToyResourceLoader.getResource(fileName);
        return PropertiesLoaderUtils.loadProperties(resource);
    }


}
