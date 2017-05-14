package trmsystem.repository.springdatajpa.jpa;

import org.springframework.context.annotation.Profile;
import trmsystem.model.User;
import trmsystem.repository.springdatajpa.UserRepositoryOverride;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by lion on 10.05.17.
 */
@Profile("spring-data-jpa")
public class SpringDataUserRepositoryImpl implements UserRepositoryOverride {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete(User user) {
        String id = user.getId().toString();
        this.em.createQuery("DELETE FROM User user WHERE id=" + id).executeUpdate();
    }
}
