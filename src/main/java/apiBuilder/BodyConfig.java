package apiBuilder;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BodyConfig{

    public Map<String, String> getBody(String[] key, String[] value){
        Map<String, String> body = new HashMap<>();
        if (key.length != value.length)
            throw new RuntimeException("Invalid parameters");
        for (int i=0; i< key.length; i++){
            body.put(key[i], value[i]);
        }
        return body;
    }
}
