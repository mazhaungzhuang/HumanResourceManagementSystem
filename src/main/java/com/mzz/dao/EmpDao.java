package com.mzz.dao;

import com.mzz.po.Emp;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpDao {
    /**
     *
     * @return
     */
    @Select("SELECT * FROM Emp")
    @Results(id ="empResult",value = {
            @Result( id = true ,property = "emp_id",column = "emp_id"),
            @Result( property = "emp_name",column = "emp_name"),
            @Result( property = "emp_wage",column = "emp_wage"),
            @Result( property = "dept_id",column = "dept_id",one = @One(select ="com.mzz.dao.DeptDao.selectdeptOne")),
            @Result( property = "level_id",column = "level_id",one = @One(select ="com.mzz.dao.LevelDao.selectlevelOne")),
    })

    List<Emp> selectAll();
}
