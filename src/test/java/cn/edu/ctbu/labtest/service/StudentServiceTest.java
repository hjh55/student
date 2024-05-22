package cn.edu.ctbu.labtest.service;

import cn.edu.ctbu.labtest.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {


    @Autowired
    StudentService studentService;

    @Test
    public void findAll() {

        List<Student> studentList=studentService.findAll();

        Assert.assertNotNull(studentList);
        System.out.println(studentList);
    }

    @Test
    public void save() {

        Student student=new Student();
        student.setName("王五");
        student.setPassword("000");
        student.setScore(87);
        student.setSex(1);

        Student student1=studentService.insert(student);

        assertNotNull(student1.getId());


    }

    @Test
    public void update() {

        Student student=studentService.getById(3L);

        student.setName("赵六");

        studentService.update(student);
    }

    @Test
    public void deleteById(){

        studentService.deleteById(1L);
    }

    @Test
    public void getById(){

        Student student = studentService.getById(1L);
        System.out.println(student);
    }
}