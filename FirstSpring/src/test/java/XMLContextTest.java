import com.banana.modelos.IMessage;
import com.banana.modelos.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class XMLContextTest {
    @Test
    public void createContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");
        assertNotNull(context);

        IMessage obj = (IMessage) context.getBean("aMessage");
        String mss = obj.getMessage();
        System.out.println("Your Message : " + mss);

        User user1 = (User) context.getBean("aUser");
        System.out.println(user1);
        assertNotNull(user1);

        User user2 = context.getBean(User.class);
        System.out.println(user2);
        assertNotNull(user2);
    }

}
