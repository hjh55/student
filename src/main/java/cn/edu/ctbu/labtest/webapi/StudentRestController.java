package cn.edu.ctbu.labtest.webapi;


import cn.edu.ctbu.labtest.core.PageUtils;
import cn.edu.ctbu.labtest.domain.Student;
import cn.edu.ctbu.labtest.service.impl.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/webapi/student")
public class StudentRestController {

    @Autowired
    private StudentImplService studentImplService;

    /**
     * 读取的url：/webapi/student/list
     *
     * @return
     */
    @GetMapping("/list")
    public List<Student> getAll() {
        List<Student> student = studentImplService.findAll();


        return student;
    }

    /**
     * 读取的url：/webapi/student/get/id
     *
     * @return
     */
    @GetMapping("/get/{id}")
    public Student get(@PathVariable Long id) {
        Student student = studentImplService.getById(id);

        student.setPassword("");

        return student;
    }


    /**
     * 新增学生的方法./webapi/student/insert
     *
     * @param student
     * @return
     */
    @PostMapping("/insert")
    public Student insert(Student student) {

        Student student1 = studentImplService.insert(student);

        return student1;
    }


    /**
     * 更新学生的方法./webapi/student/update
     *
     * @param student
     * @return
     */
    @PutMapping("/update")
    public Student update(Student student) {

        Student oldstudent = studentImplService.getById(student.getId());

        if (StringUtils.isEmpty(student.getPassword())) {
            //没有新密码，那么就是旧密码
            student.setPassword(oldstudent.getPassword());
        }

        student = studentImplService.update(student);

        return student;
    }


    /**
     * 删除学生的方法./webapi/student/delete
     *
     * @param
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {

        studentImplService.delete(id);
    }



    /**
     * 查询学生信息的方法./webapi/student/search/name
     *
     * @param name
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public Student search(@PathVariable String name) {
//        Student student=studentService.getByName(name);
        if (name == null) {
            return null;
        }
        try {
            Student student = studentImplService.getByName(name);
            return student;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getByPage")
    public PageUtils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "3") Integer size,
                               @RequestParam(value = "name", defaultValue = "") String name) {
        Page<Student> studentPage;
        if (StringUtils.isEmpty(name)) {
            Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
            studentPage = studentImplService.findAll(pageable);
        } else {
            Student student = new Student();
            student.setName(name);
            Pageable pageable = PageRequest.of(0, 3, Sort.by("id").descending());
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Student> example = Example.of(student, matcher);

            studentPage = studentImplService.findAll(example, pageable);


        }
        PageUtils pageUtils = new PageUtils(studentPage.getContent(), studentPage.getTotalElements());
        return pageUtils;
    }


}
