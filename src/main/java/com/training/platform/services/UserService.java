package com.training.platform.services;

import com.training.platform.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {

    List<User> findAll();

    Page<User> findAll(PageRequest pageRequest);

    Page<User> findAllByLimit(Integer start, Integer limit, String field);


}
