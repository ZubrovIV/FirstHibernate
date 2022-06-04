package org.example;


import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class).addAnnotatedClass(Director.class).addAnnotatedClass(Film.class)
                .addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Movie movie = new Movie("NameOfFirstMovie",1994);
            Actor actor = new Actor("FirstActor",25);
            Actor actor1 = new Actor("SecondActor",40);

            movie.setActors(new ArrayList<>(List.of(actor1,actor)));

            actor.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            session.save(movie);
            session.save(actor);
            session.save(actor1);


            session.getTransaction().commit();


        }
        }


    }

