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
import zm.hashcode.vault.model.metadata.Reciept;
import zm.hashcode.vault.repository.jpa.metadata.RecieptDAO;


/**
 *
 * @author David
 */
@Repository("recieptDAO")
@Transactional
public class RecieptDAOJPAImpl implements RecieptDAO{

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
     @Override
    public Reciept find(Long id) {
        return em.find(Reciept.class, id);
    }

    @Override
    public void persist(Reciept entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Reciept entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Reciept entity) {
        Reciept acc = em.find(Reciept.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<Reciept> findAll() {
        return (List<Reciept>) em.createQuery("SELECT a FROM Reciept a").getResultList();
    }

    @Override
    public List<Reciept> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from Reciept a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM Reciept a").getSingleResult();
    }

    @Override
    public Reciept getByPropertyName(String propertyName, String propertyValue) {
        List<Reciept> list = em.createQuery("SELECT e FROM  Reciept e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Reciept> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<Reciept> list = em.createQuery("SELECT e FROM  Reciept e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
    
}
