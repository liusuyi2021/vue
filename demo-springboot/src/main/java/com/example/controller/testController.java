package com.example.controller;

import com.example.pojo.School;
import com.example.pojo.Student;
import com.example.pojo.User;
import com.example.utils.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName testController
 * @Description:
 * @Author 刘苏义
 * @Date 2024/1/12 22:07
 * @Version 1.0
 */
@RestController
public class testController {
    static List<School> schools;
    static List<Student> students;
    static {
        schools = new ArrayList<>();
        schools.add(new School(1L, "哈尔滨", 0L, true));
        schools.add(new School(2L,"南岗区",1L,false));
        schools.add(new School(3L,"香坊区",1L,false));
        schools.add(new School(4L,"道外区",1L,false));
        students=new ArrayList<>();
        students.add(new Student(1L,"张三",1L));
        students.add(new Student(2L,"李四",2L));
        students.add(new Student(3L,"王五",2L));
        students.add(new Student(4L,"刘二",3L));
    }

    @PostMapping("/login")
    AjaxResult login(@RequestBody User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456"))
            return AjaxResult.Success(user);
        else
            return AjaxResult.Error("用户名或密码错误");
    }

    @GetMapping("/schools")
    AjaxResult getSchoolById(@RequestParam(defaultValue = "1") Long pid) {
        return AjaxResult.Success(schools.stream().filter(s -> s.getParentId().equals(pid)).collect(Collectors.toList()));

    }
    @GetMapping("/students")
    AjaxResult getStudentById(@RequestParam(defaultValue = "1") Long sid) {
        return AjaxResult.Success(students.stream().filter(s -> s.getSid().equals(sid)).collect(Collectors.toList()));

    }
}
