package trmsystem.repository.springdatajpa;

import org.springframework.context.annotation.Profile;
import trmsystem.model.User;

/**
 * Created by lion on 10.05.17.
 */

@Profile("spring-data-jpa")
public interface UserRepositoryOverride {
    public void delete(User user);
}
