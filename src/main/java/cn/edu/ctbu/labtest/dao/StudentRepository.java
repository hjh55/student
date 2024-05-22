package cn.edu.ctbu.labtest.dao;

import cn.edu.ctbu.labtest.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 学生仓库接口
 */

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from tb_student s where s.name like ?1")
    public Student getByName(String name);


}
