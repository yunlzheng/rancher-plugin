package jenkins.plugins.rancher.util;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentParser {
    public static Map<String, Object> parse(String environments) {
        HashMap<String, Object> map = new HashMap<>();
        String[] fragments = environments.split(",");
        for (String fragement : fragments) {
            if (fragement.contains(":")) {
                int index = fragement.indexOf(":");
                String env = fragement.substring(0, index);
                String value = fragement.substring(index + 1, fragement.length());
                map.put(env, value);
            }
        }
        return map;
    }
}
