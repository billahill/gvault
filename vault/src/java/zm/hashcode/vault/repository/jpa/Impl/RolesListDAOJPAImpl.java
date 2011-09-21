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
import zm.hashcode.vault.model.metadata.RolesList;
import zm.hashcode.vault.repository.jpa.metadata.RolesListDAO;

/**
 *
 * @author Boniface Kabaso
 */
@Repository("rolesListDAO")
@Transactional
public class RolesListDAOJPAImpl implements RolesListDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public RolesList find(Long id) {
        return em.find(RolesList.class, id);
    }

    @Override
    public void persist(RolesList entity) {
        em.persist(entity);
    }

    @Override
    public void merge(RolesList entity) {
        em.merge(entity);
    }

    @Override
    public void remove(RolesList entity) {
        RolesList acc = em.find(RolesList.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<RolesList> findAll() {
        return (List<RolesList>) em.createQuery("SELECT a FROM RolesList a").getResultList();
    }

    @Override
    public List<RolesList> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a from RolesList a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(a) FROM RolesList a").getSingleResult();
    }

    @Override
    public RolesList getByPropertyName(String name, String value) {
        List<RolesList> list = em.createQuery("SELECT e FROM  RolesList e WHERE e." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<RolesList> getEntitiesByProperName(String name, String value) {
        List<RolesList> list = em.createQuery("SELECT e FROM  RolesList e WHERE e." + name + "=?1").setParameter(1, value).getResultList();
        return list;
    }
}
