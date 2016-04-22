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
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import rs.com.xucro.modelo.Aplicacao;
import rs.com.xucro.modelo.Aplicativo;
import rs.com.xucro.modelo.Arquivo;
import rs.com.xucro.modelo.Autor;
import rs.com.xucro.modelo.Categoria;

/**
 *
 * @author gustavo
 */
public class PercistirAplicacao {

    EntityManagerFactory emf;
    EntityManager em;

    public PercistirAplicacao() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("XucroModelo2.0PU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public  void teste() {
        boolean exception = false;
        try {
            Aplicativo a = new Aplicativo();
            
            a.setAutor(em.find(Autor.class, 5));
            a.setClassificacaoIndicativa("10 anos");
            a.setDataUpload(Calendar.getInstance());
            a.setDownloads(20000);
            a.setManual("manual.pdf");
            a.setNome("Aplicação teste");
            a.setSinopse("Esta é uma aplicação de teste");
            a.setStatus(true);
            a.setTamanhoTotal(3000.0);
            a.setCategoria(em.find(Categoria.class, 1));
            a.setImagemIcone("img.icon");
            
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}