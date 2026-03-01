package java112.project3;

import java.util.HashMap;

/**
 * standard java bean for displaying properties. was intended at one point to use a map, but a different solution was found.
 * 
 * @author TheRealMarion1999
 */
public class PropertiesBean {
    private HashMap<String, String> beanMap;
    /**
     * standard setter for a bean, unused
     * @param value setter value
     */
    public void setBeanMap(HashMap value) {
        beanMap = value;
    }
    /**
     * unused, intended to return a bean map
     * @return returns a map
     */
    public HashMap getBeanMap() {
        return beanMap;
    }
    /**
     * unused, intended to put values into a map
     * @param key key, to be taken from the properties file
     * @param value value, to be taken from the properties file
     */
    public void putBeanData(String key, String value) {
        beanMap.put(key, value);
    }
}