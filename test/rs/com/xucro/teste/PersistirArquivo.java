/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.com.xucro.teste;

import java.util.Calendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Test;
import static org.junit.Assert.*;
import rs.com.xucro.modelo.Arquivo;

/**
 *
 * @author gustavo
 */
public class PersistirArquivo {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("XucroModelo2.0PU");
        EntityManager em = emf.createEntityManager();
        
        Arquivo a = new Arquivo();
        a.setCaminho("sprites.ino");
        a.setDataUpload(Calendar.getInstance());
        a.setTamanho(300.0);
        a.setVersao(1.0);
        
        //VALIDAÇÃO
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Arquivo>> erros = validador.validate(a);
        if (erros.size() > 0) {
            for (ConstraintViolation<Arquivo> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();

    }
    
}
