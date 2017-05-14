package trmsystem.repository.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.Repository;
import trmsystem.model.User;
import trmsystem.repository.UserRepository;

/**
 * Created by lion on 10.05.17.
 */
@Profile("spring-data-jpa")
public interface SpringDataUserRepository
       extends UserRepository, Repository<User, Integer>, UserRepositoryOverride {
}
