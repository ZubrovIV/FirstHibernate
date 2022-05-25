package org.example;


import org.example.model.Director;
import org.example.model.Film;
import org.example.model.Item;
import org.example.model.Person;
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
                .addAnnotatedClass(Item.class).addAnnotatedClass(Director.class).addAnnotatedClass(Film.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = new Person("Goga", 25);
            Item item = new Item("Item1");
            Item item1 = new Item("Item2");
            Item item2 = new Item("Item3");
            person.addItem(item);
            person.addItem(item1);
            person.addItem(item2);

            session.save(person);
            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }


    }
}
