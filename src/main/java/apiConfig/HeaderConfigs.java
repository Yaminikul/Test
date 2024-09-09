package apiConfig;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

    public Map<String, String> defaultHeader(){
        Map<String, String> header = new HashMap<>();
        header.put("content-type", "application/json");
        return header;
    }

    public Map<String, String> headerwithToken(){
        Map<String, String> header = new HashMap<>();
        header.put("content-type", "application/json");
        header.put("access-token", "adadas");
        return header;
    }
}
