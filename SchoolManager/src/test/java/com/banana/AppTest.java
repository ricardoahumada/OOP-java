package com.banana;

import com.banana.models.Student;
import com.banana.persistence.StudentsRepositoryInf;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        assertNotNull(context);
    }


}
