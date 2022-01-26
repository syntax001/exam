package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Assistant;
import utils.EMF_Creator;


public class Populator {
    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Assistant assistant = new Assistant("Dorthe Svendsen", "Danish", 5, 145);
        Assistant assistantTwo = new Assistant("Kurt Verner", "Norwegian", 13, 160);

        em.getTransaction().begin();

        em.persist(assistant);
        em.persist(assistantTwo);
        em.getTransaction().commit();
    }

    public static void main(String[] args) {
        populate();
    }
}