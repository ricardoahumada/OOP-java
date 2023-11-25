package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        System.out.println("*****INSERT Usuario");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());
        usuarios.add(new Usuario());

        for (Usuario user : usuarios) {
            usuarioRepo.save(user);
        }


        System.out.println("*****INSERT Mensajes");

        List<Mensaje> mensajes = new ArrayList<>();

        mensajes.add(new Mensaje());
        mensajes.add(new Mensaje());
        mensajes.add(new Mensaje());
        mensajes.add(new Mensaje());

        for (Mensaje mess : mensajes) {
            mensajeRepo.save(mess);
        }

    }


}
