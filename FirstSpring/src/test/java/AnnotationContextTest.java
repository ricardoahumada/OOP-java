import com.banana.config.FirstConfiguration;
import com.banana.modelos.IMessage;
import com.banana.modelos.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnnotationContextTest {
    @Test
    public void createContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfiguration.class);
        // IMessage mess = (IMessage) context.getBean("unMensaje");
        IMessage mess = context.getBean(IMessage.class);
        System.out.println(mess);
        assertNotNull(mess);

        User user = context.getBean(User.class);
        System.out.println(user);
        assertNotNull(user);
    }

}
