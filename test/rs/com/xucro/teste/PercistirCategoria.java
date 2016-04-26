/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.teste;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Test;
import static org.junit.Assert.*;
import rs.com.xucro.modelo.Categoria;

/**
 *
 * @author gustavo
 */
public class PercistirCategoria {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("XucroModelo2.0PU");
        EntityManager em = emf.createEntityManager();
        Categoria c = new Categoria();
        c.setNome("luta");
        c.setDescricao("Categoria voltada a jogos de luta");
        c.setImagem("luta.png");
        c.setStatus(true);
        //VALIDAÇÃO
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Categoria>> erros = validador.validate(c);
        if (erros.size() > 0) {
            for (ConstraintViolation<Categoria> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();

    }

}
