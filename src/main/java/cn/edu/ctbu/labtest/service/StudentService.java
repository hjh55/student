package cn.edu.ctbu.labtest.service;

import cn.edu.ctbu.labtest.dao.StudentRepository;
import cn.edu.ctbu.labtest.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    /**
     * 读取所有的学生数据
     *
     * @return
     */
    public List<Student> findAll();


    /**
     * 插入学生
     *
     * @param student
     * @return
     */
    public Student insert(Student student);

    /**
     * 更新学生
     *
     * @param student
     * @return
     */
    public Student update(Student student);

    public void delete(Student student);

    public void delete(Long id);



    public Student getById(Long id);

    public void deleteById(Long id);

    public Student getByName(String name);

    Page<Student> findAll(Pageable pageable);

    Page<Student> findAll(Example<Student> student, Pageable pageable);


}
