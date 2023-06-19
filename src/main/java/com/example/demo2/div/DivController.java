package com.example.demo2.div;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/div")
public class DivController{

    @Autowired
    private DivRepository rep;

    // アクション  APIのエンドポイント
    @GetMapping("")
    public List<Div> getAllDiv(){
        return rep.findAll();
    }

}