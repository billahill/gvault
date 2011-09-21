/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.repository.jpa.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.people.Contacts;
import zm.hashcode.vault.repository.jpa.people.ContactsDAO;

/**
 *
 * @author carlos
 */
@Repository("contactsDAO")
@Transactional
public class ContactsDAOJPAImpl implements ContactsDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Contacts find(Long id) {
        return em.find(Contacts.class, id);
    }

    @Override
    public void persist(Contacts entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Contacts entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Contacts entity) {
        Contacts acc = em.find(Contacts.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<Contacts> findAll() {
        return (List<Contacts>) em.createQuery("SELECT a FROM Contacts a").getResultList();
    }

    @Override
    public List<Contacts> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from Contacts a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM Contacts a").getSingleResult();
    }

    @Override
    public Contacts getByPropertyName(String propertyName, String propertyValue) {
        List<Contacts> list = em.createQuery("SELECT e FROM  Contacts e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Contacts> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<Contacts> list = em.createQuery("SELECT e FROM  Contacts e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}


