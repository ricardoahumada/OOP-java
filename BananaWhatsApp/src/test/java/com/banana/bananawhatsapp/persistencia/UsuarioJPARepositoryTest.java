package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/*
@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.microcompany.productsservice.persistence"})
@AutoConfigureTestEntityManager
*/
@SpringBootTest
public class UsuarioJPARepositoryTest {
    @Autowired
    private UsuarioJPARepository usuarioRepo;
    @Autowired
    private MensajeJPARepository mensajeRepo;


    @Test
    void insert() throws Exception {

        System.out.println("***** CLEAN ALL");

//        mensajeRepo.truncate();
//        usuarioRepo.truncate();

        System.out.println("***** INSERT Usuario");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(null, "Juana", "juana@j.com", LocalDate.now(), true));
        usuarios.add(new Usuario(null, "Luis", "luis@l.com", LocalDate.now(), true));

        for (Usuario user : usuarios) {
            usuarioRepo.save(user);
        }


        System.out.println("***** INSERT Mensajes");

        List<Mensaje> mensajes = new ArrayList<>();

        mensajes.add(new Mensaje(null, usuarios.get(0), usuarios.get(1), "Hola, qué tal?", LocalDate.now()));
        mensajes.add(new Mensaje(null, usuarios.get(1), usuarios.get(0), "Muy bien! y tu?", LocalDate.now()));
        mensajes.add(new Mensaje(null, usuarios.get(0), usuarios.get(1), "Bien también...", LocalDate.now()));
        mensajes.add(new Mensaje(null, usuarios.get(1), usuarios.get(0), "Chachi!", LocalDate.now()));

        for (Mensaje mess : mensajes) {
            mensajeRepo.save(mess);
        }

    }


}
