package web.dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import jakarta.transaction.Transactional;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.model.User;
import web.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoHibernateImpl implements UserDao {

    private EntityManagerFactory emf;

    public UserDaoHibernateImpl() {
        emf = HibernateUtil.getEntityManagerFactory();
    }

    public void addUser(User u) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(u);
        et.commit();
        // System.out.println("--- DEBUG: ADDED USER" + u.getName() + u.getCountry());
    }

    public User getUser(long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        User u = em.find(User.class, id);
        et.commit();
        return u;
    }

    public void removeUser(long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        User u = new User(id);
        User result = em.find(User.class, u.getId());
        em.remove(result);
        et.commit();
        // System.out.println("--DEBUG: REMOVED USER " + result.getName());
    }

    public void updateUser(User u) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(u);
        et.commit();
        // System.out.println("--DEBUG: UPDATED USER " + u.getName());
    }

    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        List<User> results = null;

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);

        TypedQuery<User> tq = em.createQuery(all);
        results = tq.getResultList();

        // System.out.println("--DEBUG: found users - " + results.size());

        if (results == null || results.size() == 0) {
            return new ArrayList<>();
        } else {
            return results;
        }
    }
}
