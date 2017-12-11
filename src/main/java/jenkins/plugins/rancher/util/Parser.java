package jenkins.plugins.rancher.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String BUILDER_REGEX = "(\\$\\{\\w*\\})";

    public static String paraser(String source, Map<String, String> envs) {
        Matcher matcher = Pattern.compile(BUILDER_REGEX).matcher(source);
        while (matcher.find()) {
            String param = matcher.group();
            String key = matcher.group().replace("${", "").replace("}", "");
            if (envs.keySet().contains(key)) {
                source = source.replace(param, envs.get(key));
            }
        }
        return source;
    }

}
