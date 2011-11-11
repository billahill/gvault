/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.repository.jpa.Impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.parameters.settings;
import zm.hashcode.vault.repository.jpa.parameters.SettingsDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
/**
 *
 * @author Kraakbeen
 */
@Repository("settingsDAO")
@Transactional
public class SettingsDAOImpl implements SettingsDAO{

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public settings find(Long id) {
        return em.find(settings.class, id);
    }

    @Override
    public void persist(settings entity) {
        em.persist(entity);
    }

    @Override
    public void merge(settings entity) {
        em.merge(entity);
    }

    @Override
    public void remove(settings entity) {
        settings acc = em.find(settings.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<settings> findAll() {
        return (List<settings>) em.createQuery("SELECT a FROM settings a").getResultList();
    }

    @Override
    public List<settings> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from settings a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM settings a").getSingleResult();
    }

    @Override
    public settings getByPropertyName(String propertyName, String propertyValue) {
        List<settings> list = em.createQuery("SELECT e FROM  settings e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<settings> getEntitiesByProperName(String propertyName, String propertyValue) {
        List<settings> list = em.createQuery("SELECT e FROM  settings e WHERE e." + propertyName + "=?1").setParameter(1, propertyValue).getResultList();
        return list;
    }
}
