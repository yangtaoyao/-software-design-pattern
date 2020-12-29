package com.yty.pattern.builder;

import com.yty.entity.Student;
import com.yty.utils.JsonUtil;

public class BuilderExample {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder().setCpu("cpu").setRam("123").build();
        System.out.println(JsonUtil.objertToString(computer));

        Student student = Student.builder().grade("grade").schoolName("schoolName").build();
        System.out.println(JsonUtil.objertToString(student));
    }
}
