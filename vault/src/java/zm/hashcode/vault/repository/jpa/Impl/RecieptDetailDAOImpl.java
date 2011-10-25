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
import zm.hashcode.vault.model.metadata.RecieptDetail;
import zm.hashcode.vault.repository.jpa.metadata.RecieptDetailDAO;

/**
 *
 * @author David
 */
@Repository("recieptDetailDAO")
@Transactional
public class RecieptDetailDAOImpl  implements RecieptDetailDAO{

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
     @Override
    public RecieptDetail find(Long id) {
        return em.find(RecieptDetail.class, id);
    }

    @Override
    public void persist(RecieptDetail entity) {
        em.persist(entity);
    }

    @Override
    public void merge(RecieptDetail entity) {
        em.merge(entity);
    }

    @Override
    public void remove(RecieptDetail entity) {
        RecieptDetail acc = em.find(RecieptDetail.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<RecieptDetail> findAll() {
        return (List<RecieptDetail>) em.createQuery("SELECT a FROM RecieptDetail a").getResultList();
    }

    @Override
    public List<RecieptDetail> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from RecieptDetail a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM RecieptDetail a").getSingleResult();
    }

    @Override
    public RecieptDetail getByPropertyName(String propertyName, String propertyValue) {
        List<RecieptDetail> list = em.createQuery("SELECT e FROM  RecieptDetail e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<RecieptDetail> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<RecieptDetail> list = em.createQuery("SELECT e FROM  RecieptDetail e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
    
}
