package com.shop;

import com.shop.item.Book;
import com.shop.item.Movie;
import com.shop.member.Member;
import com.shop.team.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try{
            tx.begin();
            Movie movie = new Movie();
            movie.setActor("FFFF");
            movie.setDirector("FASDFADF");
            movie.setName("FASFsa");
            movie.setPrice(412431234L);
            entityManager.persist(movie);

            entityManager.flush();
            entityManager.clear();

            Movie findMovie = entityManager.find(Movie.class,movie.getId());


            tx.commit();
        }
        catch (Exception e){
            System.out.println(e);
            tx.rollback();
        }finally {
        }
    }
}
