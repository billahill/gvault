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
import zm.hashcode.vault.model.people.Address;
import zm.hashcode.vault.repository.jpa.people.AddressDAO;

/**
 *
 * @author carlos
 */
@Repository("addressDAO")
@Transactional
public class AddressDAOJPAImpl implements AddressDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Address find(Long id) {
        return em.find(Address.class, id);
    }

    @Override
    public void persist(Address entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Address entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Address entity) {
        Address acc = em.find(Address.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>) em.createQuery("SELECT a FROM Address a").getResultList();
    }

    @Override
    public List<Address> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from Address a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM Address a").getSingleResult();
    }

    @Override
    public Address getByPropertyName(String propertyName, String propertyValue) {
        List<Address> list = em.createQuery("SELECT e FROM  Address e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Address> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<Address> list = em.createQuery("SELECT e FROM  Address e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}

