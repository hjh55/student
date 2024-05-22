package cn.edu.ctbu.labtest.service.impl;

import cn.edu.ctbu.labtest.dao.StudentRepository;
import cn.edu.ctbu.labtest.domain.Student;
import cn.edu.ctbu.labtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImplService implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    /**
     * 读取所有的学生数据
     *
     * @return
     */
    public List<Student> findAll() {

        return studentRepository.findAll();

    }


    /**
     * 插入学生
     *
     * @param student
     * @return
     */
    public Student insert(Student student) {

        return studentRepository.save(student);
    }

    /**
     * 更新学生
     *
     * @param student
     * @return
     */
    public Student update(Student student) {

        return studentRepository.save(student);
    }

    public void delete(Student student) {

        studentRepository.delete(student);
    }

    public void delete(Long id) {
        Student student = new Student();
        student.setId(id);

        studentRepository.delete(student);

    }


    public Student getById(Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        return student;
    }

    public void deleteById(Long id) {

        studentRepository.deleteById(id);
    }

    public Student getByName(String name) {
        Student student = studentRepository.getByName(name);
        return student;
    }

    @Override
    public Page<Student> findAll(Example<Student> student, Pageable pageable) {
        return studentRepository.findAll(student, pageable);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

}
