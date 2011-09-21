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
import zm.hashcode.vault.model.metadata.AccountTypeList;
import zm.hashcode.vault.repository.jpa.metadata.AccountTypeListDAO;

/**
 *
 * @author carlos
 */
@Repository("accountTypeListDAO")
@Transactional
public class AccountTypeListDAOJPAImpl implements AccountTypeListDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public AccountTypeList find(Long id) {
        return em.find(AccountTypeList.class, id);
    }

    @Override
    public void persist(AccountTypeList entity) {
        em.persist(entity);
    }

    @Override
    public void merge(AccountTypeList entity) {
        em.merge(entity);
    }

    @Override
    public void remove(AccountTypeList entity) {
        AccountTypeList acc = em.find(AccountTypeList.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<AccountTypeList> findAll() {
        return (List<AccountTypeList>) em.createQuery("SELECT a FROM AccountTypeList a").getResultList();
    }

    @Override
    public List<AccountTypeList> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from AccountTypeList a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM AccountTypeList a").getSingleResult();
    }

    @Override
    public AccountTypeList getByPropertyName(String propertyName, String propertyValue) {
        List<AccountTypeList> list = em.createQuery("SELECT e FROM  AccountTypeList e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<AccountTypeList> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<AccountTypeList> list = em.createQuery("SELECT e FROM  AccountTypeList e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}


