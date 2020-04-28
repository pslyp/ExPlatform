package com.training.platform.controllers.admin;

import com.training.platform.entities.User;
import com.training.platform.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = { 5, 10, 20 };

    @GetMapping("")
    public String index(Model model,
                        @RequestParam("pageSize") Optional<Integer> pageSize,
                        @RequestParam("page") Optional<Integer> page) throws Exception {

//        Page<User> users = userService.findAll(PageRequest.of(evalPage, evalPageSize, Sort.by(Sort.Direction.DESC, "id")));

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        List<User> users = userService.findAll();
        model.addAttribute("items", users);

        return "admin/user/lists";
    }

    @GetMapping("/demo")
    public String demo() {
        return "admin/sample";
    }

}
