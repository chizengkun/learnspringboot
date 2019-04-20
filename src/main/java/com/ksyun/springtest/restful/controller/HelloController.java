package com.ksyun.springtest.restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.ksyun.springtest.restful.entity.Person;
import com.ksyun.springtest.restful.repository.PersonRepository;

@RestController
public class HelloController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/add")
    public String addPerson() {
        Person p = new Person("中文测试", 34, "地址内容测试");

        personRepository.save(p);
        return "save success";
    }

}