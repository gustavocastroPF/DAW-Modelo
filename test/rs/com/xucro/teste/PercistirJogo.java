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
import rs.com.xucro.modelo.Jogo;

/**
 *
 * @author gustavo
 */
public class PercistirJogo {

    EntityManagerFactory emf;
    EntityManager em;

    public PercistirJogo() {
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
            
            Jogo j = new Jogo();
            
            j.setAutor(em.find(Autor.class, 5));
            j.setClassificacaoIndicativa("10 anos");
            j.setDataUpload(Calendar.getInstance());
            j.setDownloads(20000);
            j.setManual("manual.pdf");
            j.setNome("Aplicação teste2");
            j.setSinopse("Esta é uma aplicação de teste");
            j.setStatus(true);
            j.setTamanhoTotal(3000.0);
            j.setCategoria(em.find(Categoria.class, 1));
            j.setBits(16);
            j.setImagemCapa("capa.jpg");
            j.setNumeroPlayers(2);
            j.setOnline(true);
            j.setPremium(false);
            
            em.getTransaction().begin();
            em.persist(j);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}