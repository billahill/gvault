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
import zm.hashcode.vault.model.metadata.CurrencyList;
import zm.hashcode.vault.repository.jpa.metadata.CurrencyListDAO;

/**
 *
 * @author carlos
 */
@Repository("currencyListDAO")
@Transactional
public class CurrencyListDAOJPAImpl implements CurrencyListDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public CurrencyList find(Long id) {
        return em.find(CurrencyList.class, id);
    }

    @Override
    public void persist(CurrencyList entity) {
        em.persist(entity);
    }

    @Override
    public void merge(CurrencyList entity) {
        em.merge(entity);
    }

    @Override
    public void remove(CurrencyList entity) {
        CurrencyList acc = em.find(CurrencyList.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<CurrencyList> findAll() {
        return (List<CurrencyList>) em.createQuery("SELECT a FROM CurrencyList a").getResultList();
    }

    @Override
    public List<CurrencyList> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from CurrencyList a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM CurrencyList a").getSingleResult();
    }

    @Override
    public CurrencyList getByPropertyName(String propertyName, String propertyValue) {
        List<CurrencyList> list = em.createQuery("SELECT e FROM  CurrencyList e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<CurrencyList> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<CurrencyList> list = em.createQuery("SELECT e FROM  CurrencyList e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}


