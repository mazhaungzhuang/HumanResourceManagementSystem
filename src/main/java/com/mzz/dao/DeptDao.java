package com.mzz.dao;

import com.mzz.po.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptDao {

    /**
     * @return
     */
    @Select("select * from dept where dept_id=#{dept_id}")
    List<Dept> selectdeptOne();



}
