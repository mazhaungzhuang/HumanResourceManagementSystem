package com.mzz.service;

import com.mzz.po.Emp;

import java.util.List;

/**
 * @author mzz
 * @Date 2020-10-06-15:28
 * @Version 1.0
 */
public interface EmpServlce {
    /**
     * 单个查询Dept
     * @return
     */
    List<Emp> selectdeptOne();
}
