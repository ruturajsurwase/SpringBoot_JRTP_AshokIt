
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MapKeyCleanup 
{
    public static void main(String[] args) 
    {
        // Create the original map with special characters in keys
        Map<String, String> originalMap = new HashMap<>();
        originalMap.put("key1@", "value1");
        originalMap.put("key2#", "value2");
        originalMap.put("key3$", "value3");

        // Clean the keys and create a new map
        Map<String, String> cleanedMap = new HashMap<>();
        for (Map.Entry<String, String> entry : originalMap.entrySet())
        {
            String cleanedKey = removeSpecialCharacters(entry.getKey());
            cleanedMap.put(cleanedKey, entry.getValue());
        }

        // Print the cleaned map
        for (Map.Entry<String, String> entry : cleanedMap.entrySet()) 
        {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    private static String removeSpecialCharacters(String str) {
        // Remove any character that is not a letter, digit, or underscore
        return str.replaceAll("[^a-zA-Z0-9_]", "");
    }
}
