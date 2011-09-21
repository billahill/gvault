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
import zm.hashcode.vault.model.metadata.StatusList;
import zm.hashcode.vault.repository.jpa.metadata.StatusListDAO;

/**
 *
 * @author carlos
 */
@Repository("statusListDAO")
@Transactional
public class StatusListDAOJPAImpl implements StatusListDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public StatusList find(Long id) {
        return em.find(StatusList.class, id);
    }

    @Override
    public void persist(StatusList entity) {
        em.persist(entity);
    }

    @Override
    public void merge(StatusList entity) {
        em.merge(entity);
    }

    @Override
    public void remove(StatusList entity) {
        StatusList acc = em.find(StatusList.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<StatusList> findAll() {
        return (List<StatusList>) em.createQuery("SELECT a FROM StatusList a").getResultList();
    }

    @Override
    public List<StatusList> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from StatusList a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM StatusList a").getSingleResult();
    }

    @Override
    public StatusList getByPropertyName(String propertyName, String propertyValue) {
        List<StatusList> list = em.createQuery("SELECT e FROM  StatusList e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<StatusList> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<StatusList> list = em.createQuery("SELECT e FROM  StatusList e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}


