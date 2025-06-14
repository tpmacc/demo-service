package tpmacc.demo.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
    /**
     * A message to welcome users.
     */
    private String greeting;
}