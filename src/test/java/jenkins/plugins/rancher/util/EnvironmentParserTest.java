package jenkins.plugins.rancher.util;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EnvironmentParserTest {

    @Test
    public void should_parase_evironment_when_value_are_urls() {
        Map<String, Object> parse = EnvironmentParser.parse("CONFIG_SERVER_URL:http://config:8888");
        System.out.println(parse);
        assertThat(parse.get("CONFIG_SERVER_URL"), is("http://config:8888"));
    }

}