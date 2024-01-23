package es.netmind.mypersonalbankapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyPersonalBankAPIApplicationTest {

     @PersistenceContext
     EntityManager em;

    @Test
    public void load() {
        assertNotNull(em);
        assertTrue(true);
    }

}