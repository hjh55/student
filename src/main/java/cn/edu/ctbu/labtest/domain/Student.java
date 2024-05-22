package cn.edu.ctbu.labtest.domain;


import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 学生实体
 */
@Entity(name = "tb_student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     *密码
     */
    private String password;

    /**
     * 性别，1男，2女，3未知
     */
    private Integer sex;

    /**
     * 学生成绩
     */
    private Integer score;

    /**
     * 学生学号
     */
    private Integer studentid;

}
