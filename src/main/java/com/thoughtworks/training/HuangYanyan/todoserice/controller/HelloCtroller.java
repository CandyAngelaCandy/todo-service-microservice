package com.thoughtworks.training.huangyanyan.todoserice.controller;

import com.thoughtworks.training.huangyanyan.todoserice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloCtroller {

    @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    public String hello(
            @PathVariable String name,
            Model model) {

        model.addAttribute("person", helloService.find(name));

        return "hello";
    }
}
