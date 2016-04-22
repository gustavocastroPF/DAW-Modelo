/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Test;
import static org.junit.Assert.*;
import rs.com.xucro.modelo.Usuario;

/**
 *
 * @author gustavo
 */
public class PercistirUsuario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("XucroModelo2.0PU");
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        
        u.setNome("Gustavo");
        u.setLogin("gustavo123");
        u.setSenha("senha132456");
        u.setImagem("image.png");
        u.setDataNascimento(new GregorianCalendar(1900, Calendar.OCTOBER,25));
        u.setEmail("gustavo@email.com.rs");
        u.setAdministrador(true);
        u.setStatus(true);
        //VALIDAÇÃO
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Usuario>> erros = validador.validate(u);
        if (erros.size() > 0) {
            for (ConstraintViolation<Usuario> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();

    }

}
