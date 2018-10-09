package store;

import PetClinic.Pet;
import models.PetModelHibernate;
import models.User;
import models.UserModelHibernate;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.OptimisticLockException;
import java.util.ArrayList;

public class HibernateStorage implements Storage {
    private SessionFactory factory;

    public HibernateStorage() {
    factory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * @return list of User class from PostgreSQL
     */
    @Override
    public ArrayList<User> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query queryPet = session.createQuery("from PetModelHibernate ");
            Query queryUser = session.createQuery("from UserModelHibernate ");

            ArrayList<User> list = new ArrayList<>();
            for (UserModelHibernate userModelHibernate : (ArrayList<UserModelHibernate>)queryUser.list()) {
                Pet pet = getPetById((ArrayList<PetModelHibernate>) queryPet.list(), userModelHibernate.getId()).toPet();
                User user = new User(userModelHibernate,pet);
                list.add(user);
            }

            return list;
        } finally {
            tx.commit();
            session.close();
            factory.close();
        }

    }

    /**
     * @param petList list of pet from table like PetModelHibernate class
     * @param id user id that use from search
     * @return pet like Pet class with user id or null
     */
    private PetModelHibernate getPetById(ArrayList<PetModelHibernate> petList, int id){
        for (PetModelHibernate pet : petList) {
            if (pet.getClientId()==id)
                return pet;
        }
        return null;
    }

    /**
     * Add User to PostgreSQL
     * @param user User to be add
     */
    @Override
    public void add(User user) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            UserModelHibernate userModelHibernate = user.getUserModelHibernate();
            session.save(userModelHibernate);
            PetModelHibernate petModelHibernate = user.getPetModelHibernate(userModelHibernate.getId());
            session.save(petModelHibernate);
        } finally {
            session.getTransaction().commit();
            session.close();
            factory.close();
        }


    }

    /**
     * Edit User in table PostgreSQL
     * @param user User to be edit
     */
    @Override
    public void edit(User user) {
        Session session = factory.openSession();
        session.beginTransaction();
        try{
            Query queryPet = session.createQuery("from PetModelHibernate ");
            UserModelHibernate userModelHibernate = user.getUserModelHibernate();
            session.update(userModelHibernate);
            PetModelHibernate petModelHibernate = getPetById((ArrayList<PetModelHibernate>) queryPet.list(),userModelHibernate.getId());
            session.update(petModelHibernate);
        } finally {
            session.getTransaction().commit();
            session.close();
            factory.close();
        }
    }

    /**
     * Delete User by id
     * @param id param to be use for delete User
     */
    @Override
    public void delete(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            Query queryPet = session.createQuery("from PetModelHibernate ");
            PetModelHibernate petModelHibernate = getPetById((ArrayList<PetModelHibernate>) queryPet.list(),id);
            if (petModelHibernate != null)
            session.delete(petModelHibernate);
            UserModelHibernate userModelHibernate = new UserModelHibernate();
            userModelHibernate.setId(id);
            session.delete(userModelHibernate);
        } catch  (OptimisticLockException a ){
            System.err.println("Maybe wrong ID");
            a.printStackTrace();
        } finally {
        session.getTransaction().commit();
        session.close();
        factory.close();
     }
    }

    /**
     * @param id param to be use for search User
     * @return User by id
     */
    @Override
    public User get(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            UserModelHibernate userModelHibernate = session.get(UserModelHibernate.class, id);
            Query queryPet = session.createQuery("from PetModelHibernate ");
            PetModelHibernate petModelHibernate = getPetById((ArrayList<PetModelHibernate>)queryPet.list(),id);
            return new User(userModelHibernate,petModelHibernate.toPet());
        } finally {
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    }

    /**
     *
     * @param login user's name
     * @return User were name = login
     */
    @Override
    public User findByLogin(String login) {
        ArrayList<User> list = values();
        for (User user : list) {
            if (user.getName().compareTo(login)==0)
                return user;
        }
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
    }
}
