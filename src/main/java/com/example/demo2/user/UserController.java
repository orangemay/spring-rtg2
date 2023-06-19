package com.example.demo2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.demo2.div.Div;
import com.example.demo2.div.DivRepository;

@RestController
@RequestMapping("/api/user")
public class UserController{

    Logger logger = LoggerFactory.getLogger(UserController.class);
    String DEFAULT_PICTURE = "default.png";

    @Autowired
    private UserRepository userRep;
    @Autowired
    private DivRepository divRep;

    // アクション  APIのエンドポイント
    @GetMapping("")
    public List<User> getUsers(){
        return userRep.findAll();
    }

    // GETパラメーター付きのアクション
    @GetMapping("{id}")
    public User getById(@PathVariable("id") int id){
        return userRep.findById(id).orElseThrow();
    }

    @PostMapping("create")
    public int createUserOne(@RequestBody User user){
        logger.warn(user.getName());
        logger.warn(user.getMail());

        // フロントから渡ってこないカラムについてデフォルト値をセット
        user.setJoinedAt(LocalDateTime.now());
        user.setPicture(DEFAULT_PICTURE);
        Div d1 = divRep.findById(1).orElseThrow();
        logger.warn(d1.getName());
        user.setDiv(d1);
        userRep.save(user);
        return user.getId();
    }

    // 編集
    @PostMapping("update")
    public int updateUser(@RequestBody User user){
        userRep.updateUserById(user.getId(), user.getName(), user.getMail());
        return 0;
    }

    //　削除. IDのみ入ってくる
    @PostMapping("delete")
    public int deleteUser(@RequestBody User user){
        userRep.deleteById(user.getId());
        return 0;
    }

}