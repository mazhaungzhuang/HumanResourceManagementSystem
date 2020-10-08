package com.mzz.dao;

import com.mzz.po.Level;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mzz
 */
public interface LevelDao {
    /**
     * 查询
     * @return
     */
    @Select("select * from level where level_id=#{level_id}")
    List<Level> selectlevelOne();

}
