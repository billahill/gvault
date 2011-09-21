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
import zm.hashcode.vault.model.people.Roles;
import zm.hashcode.vault.repository.jpa.people.RolesDAO;

/**
 *
 * @author carlos
 */
@Repository("rolesDAO")
@Transactional
public class RolesDAOJPAImpl implements RolesDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Roles find(Long id) {
        return em.find(Roles.class, id);
    }

    @Override
    public void persist(Roles entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Roles entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Roles entity) {
        Roles acc = em.find(Roles.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<Roles> findAll() {
        return (List<Roles>) em.createQuery("SELECT a FROM Roles a").getResultList();
    }

    @Override
    public List<Roles> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from Roles a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM Roles a").getSingleResult();
    }

    @Override
    public Roles getByPropertyName(String propertyName, String propertyValue) {
        List<Roles> list = em.createQuery("SELECT e FROM  Roles e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Roles> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<Roles> list = em.createQuery("SELECT e FROM  Roles e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}


