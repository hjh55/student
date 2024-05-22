package cn.edu.ctbu.labtest.controller;

import cn.edu.ctbu.labtest.domain.Student;
import cn.edu.ctbu.labtest.service.impl.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class StudentController {

    @Autowired
    StudentImplService studentImplService;

    @RequestMapping("/student/list")
    public String list(Model model){


        List<Student> students= studentImplService.findAll();
        model.addAttribute("data",students);
        return "list";
//        return "/student/list";
    }


    @RequestMapping("/list")
    public String getByName(Model model, String name) {
        Student students = studentImplService.getByName(name);
        model.addAttribute("data", students);
        return "/list";
    }
}
