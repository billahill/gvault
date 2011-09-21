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
import zm.hashcode.vault.model.account.Account;
import zm.hashcode.vault.repository.jpa.account.AccountDAO;
/**
 *
 * @author carlos
 */
@Repository("accountDAO")
@Transactional
public class AccountDAOJPAImpl implements AccountDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Account find(Long id) {
        return em.find(Account.class, id);
    }

    @Override
    public void persist(Account entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Account entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Account entity) {
        Account acc = em.find(Account.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) em.createQuery("SELECT a FROM Account a").getResultList();
    }

    @Override
    public List<Account> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from Account a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM Account a").getSingleResult();
    }

    @Override
    public Account getByPropertyName(String propertyName, String propertyValue) {
        List<Account> list = em.createQuery("SELECT e FROM  Account e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Account> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<Account> list = em.createQuery("SELECT e FROM  Account e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}

