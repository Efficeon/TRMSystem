package trmsystem.service;

import org.springframework.dao.DataAccessException;
import trmsystem.model.User;

import java.util.Collection;

/**
 * Created by lion on 11.05.17.
 */
public interface UserService {
    User findUserById(int id) throws DataAccessException;
    Collection<User> findAllUsers() throws DataAccessException;
    void saveUser(User user) throws DataAccessException;
    void deleteUser(User user) throws DataAccessException;
}
