package com.training.platform.services;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public Map<String, String> getCities() {
        Map<String, String> cities = new HashMap<>();
        cities.put("bangkok", "bangkok");
        cities.put("nakornpathom", "nakornpathom");

        return cities;
    }

    @Override
    public User save(Map<String, String> inputs) throws Exception {
        try {
            User user = new User();

            user.setName(inputs.get("name"));
            user.setSurname(inputs.get("surname"));
            user.setEmail(inputs.get("email"));
            user.setPassword(inputs.get("password"));
            user.setAge(Integer.parseInt(inputs.get("age")));
            user.setAddress(inputs.get("address"));
            user.setCity(inputs.get("city"));
            user.setMobile(inputs.get("mobile"));
            user.setActive(1);
            user.setCreateedAt((java.sql.Date) new Date());

            return userRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
    }

}
