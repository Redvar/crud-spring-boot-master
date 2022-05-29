package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String name) {

        return entityManager.createQuery("from Role where name = :name", Role.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.createQuery("from Role where id = :id", Role.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }
}
