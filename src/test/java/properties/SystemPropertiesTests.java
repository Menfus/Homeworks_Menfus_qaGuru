package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
public class SystemPropertiesTests {

    @Test
    @Tag("property")
    void systemProperties4Test() {
        System.out.println(browser);
        // gradle property_test
        // mozilla

        // gradle property_test -Dbrowser=opera
        // opera

    }
}

