package com.example.travel.service.Impl;

import com.example.travel.jpa.Customer;
import com.example.travel.jpa.User;
import com.example.travel.repository.CustomerRepository;
import com.example.travel.repository.UserRepository;
import com.example.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        try{
            List<User> users = userRepository.getAllUsers();
            return users;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUsersByStatus(int status) {
        try{
            List<User> users = userRepository.findUsersByStatus(status);
            return users;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int userId) {
        try{
            User user = userRepository.findById(userId).get();
            return user;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        try{
            User user = userRepository.findById(userId).get();
            userRepository.delete(user);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try{
            userRepository.save(user);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<User> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.userRepository.findPaginateUsersStatus(pageable);
    }

    @Override
    public Page<User> findPaginatedShow(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.userRepository.findPaginateUsersStatusShow(pageable);
    }

    @Override
    public Page<User> findPaginatedHidden(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.userRepository.findPaginateUsersStatusHidden(pageable);
    }

    @Override
    public boolean checkUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user==null)
        {
            return true;
        }else{
            return false;
        }
    }
}
