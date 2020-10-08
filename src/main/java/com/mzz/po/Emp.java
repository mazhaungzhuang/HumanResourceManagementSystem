package com.mzz.po;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Emp {
    private int emp_id;
    private String emp_name;
    private BigDecimal emp_wage;
    private Dept dept_id;
    private Level level_id;
}
