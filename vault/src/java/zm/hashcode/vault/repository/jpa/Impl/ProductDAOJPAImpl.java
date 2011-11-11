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
import zm.hashcode.vault.model.product.product;
import zm.hashcode.vault.repository.jpa.product.ProductDAO;
/**
 *
 * @author Kraakbeen
 */
@Repository("productDAO")
@Transactional
public class ProductDAOJPAImpl implements ProductDAO{
    
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public product find(Long id) {
        return em.find(product.class, id);
    }

    @Override
    public void persist(product entity) {
        em.persist(entity);
    }

    @Override
    public void merge(product entity) {
        em.merge(entity);
    }

    @Override
    public void remove(product entity) {
        product acc = em.find(product.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<product> findAll() {
        return (List<product>) em.createQuery("SELECT a FROM product a").getResultList();
    }

    @Override
    public List<product> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from product a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM product a").getSingleResult();
    }

    @Override
    public product getByPropertyName(String propertyName, String propertyValue) {
        List<product> list = em.createQuery("SELECT e FROM  product e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<product> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<product> list = em.createQuery("SELECT e FROM  product e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}
