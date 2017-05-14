package trmsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trmsystem.model.User;
import trmsystem.repository.UserRepository;
import trmsystem.service.UserService;

import java.util.Collection;

/**
 * Created by lion on 11.05.17.
 */

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(int id) throws DataAccessException {
        User user = null;
        try {
            user = userRepository.findById(id);
        } catch (ObjectRetrievalFailureException |EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<User> findAllUsers() throws DataAccessException {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) throws DataAccessException {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) throws DataAccessException {
        userRepository.delete(user);
    }
}
