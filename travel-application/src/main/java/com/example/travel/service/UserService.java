package com.example.travel.service;

import com.example.travel.jpa.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    List<User> getUsersByStatus(int status);
    User getUserById(int userId);
    boolean saveUser(User user);
    boolean deleteUser(int userId);
    boolean updateUser(User user);
    Page<User> findPaginated(int pageNo, int pageSize);
    Page<User> findPaginatedShow(int pageNo,int pageSize);
    Page<User> findPaginatedHidden(int pageNo,int pageSize);
    boolean checkUserName(String userName);
}
