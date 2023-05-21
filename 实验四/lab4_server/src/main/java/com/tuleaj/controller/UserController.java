package com.tuleaj.controller;

import com.tuleaj.domain.Response;
import com.tuleaj.domain.User;
import com.tuleaj.service.UserService;
import com.tuleaj.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @PostMapping("/login")
    public Response Login(@RequestBody User user) throws UnsupportedEncodingException {
        Response response = new Response();
        response.setCode(500);
        int result = userService.selectUser(user);
        if (result > 0){
            response.setCode(200);
            String token = JWTUtils.sign(user.getUsername(),user.getPassword());
            System.out.println(token);
            response.setToken(token);
        }
        return response;
    }
}
