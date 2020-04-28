package com.training.platform.services;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(PageRequest pageRequest) {
        Page<User> users = userRepository.findAll(pageRequest);
        return users;
    }

    @Override
    public Page<User> findAllByLimit(Integer start, Integer limit, String field) {
        PageRequest page = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, field));
        return userRepository.findAll(page);
    }

}
