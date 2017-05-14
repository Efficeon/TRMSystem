package trmsystem.repository;

import org.springframework.dao.DataAccessException;
import trmsystem.model.User;

import java.util.Collection;

/**
 * Created by lion on 10.05.17.
 */
public interface UserRepository {

    User findById(int id) throws DataAccessException;

    Collection<User> findAll() throws DataAccessException;

    void save(User user) throws DataAccessException;

    void delete(User user) throws DataAccessException;

}
