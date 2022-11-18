package com.zed.mapper;

import com.zed.entity.Visitor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VisitorMapper {
    /**
     * 查询所有访客信息
     *
     * @return
     */
    @Select("select * from t_visit")
    List<Visitor> selectVisitor();


    /**
     * 新增访客信息 --->访客登记功能
     *
     * @param visitor
     */
    @Insert("insert into t_visit values(#{visitor},#{gender},#{reason},#{tel},#{date})")
    void addVisitor(Visitor visitor);
}
