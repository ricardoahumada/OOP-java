import com.banana.config.FirstConfiguration;
import com.banana.modelos.IMessage;
import com.banana.modelos.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FirstConfiguration.class)
//@ActiveProfiles("dev") // comment if default
public class AnnotationContextTestProfiles {
    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private IMessage mess;

    @Autowired
    Environment env;

    @Value("${jdbc.url}")
    String url;


    @Test
    public void createContext() {
        assertNotNull(ctx);

        assertNotNull(mess);

        User user = ctx.getBean(User.class);
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    public void propertiesValidation() {
        String url2 = env.getProperty("jdbc.url", String.class);

        System.out.println("url: " + url);
        System.out.println("url: " + url2);

        assertNotNull(url);
        assertNotNull(url2);

    }

}
