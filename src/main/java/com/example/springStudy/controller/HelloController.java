package com.example.springStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(String user, Model model){
        model.addAttribute("user",user);
        return "hello";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Person hello(String name, Integer age){

        Person person = new Person();
        person.name = name;
        person.age = age;

        return person;
    }

    static class Person{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}
