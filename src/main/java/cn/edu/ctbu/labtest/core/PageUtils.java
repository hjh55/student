package cn.edu.ctbu.labtest.core;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:xuxuduoduomei
 * @Date:2021/12/6 15:59
 */
@Data
public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    private int total;
    private List<?> rows;

    public PageUtils(List<?> rows, Long total) {
        this.rows = rows;
        this.total = total.intValue();
    }

    public PageUtils(List<?> rows, int total) {
        this.rows = rows;
        this.total = total;
    }
}
