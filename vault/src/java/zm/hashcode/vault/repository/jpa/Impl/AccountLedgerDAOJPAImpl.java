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
import zm.hashcode.vault.model.account.AccountLedger;
import zm.hashcode.vault.repository.jpa.account.AccountLedgerDAO;

/**
 *
 * @author carlos
 */
@Repository("accountLedgerDAO")
@Transactional
public class AccountLedgerDAOJPAImpl implements AccountLedgerDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public AccountLedger find(Long id) {
        return em.find(AccountLedger.class, id);
    }

    @Override
    public void persist(AccountLedger entity) {
        em.persist(entity);
    }

    @Override
    public void merge(AccountLedger entity) {
        em.merge(entity);
    }

    @Override
    public void remove(AccountLedger entity) {
        AccountLedger acc = em.find(AccountLedger.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<AccountLedger> findAll() {
        return (List<AccountLedger>) em.createQuery("SELECT a FROM AccountLedger a").getResultList();
    }

    @Override
    public List<AccountLedger> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from AccountLedger a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM AccountLedger a").getSingleResult();
    }

    @Override
    public AccountLedger getByPropertyName(String propertyName, String propertyValue) {
        List<AccountLedger> list = em.createQuery("SELECT e FROM  AccountLedger e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<AccountLedger> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<AccountLedger> list = em.createQuery("SELECT e FROM  AccountLedger e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}

