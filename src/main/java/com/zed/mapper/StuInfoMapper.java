package com.zed.mapper;

import com.zed.entity.StuInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StuInfoMapper {

    /**
     * 查询所有学生信息
     * @return
     */
//    @Select("select * from t_stuInfo where sno = #{sno} and departmentId = #{DepartmentId} and name = #{name} and gender = #{gender} and tel = #{tel}")
    @Select("select * from t_stuinfo")
    List<StuInfo> selectStu();


    /**
     * 新增学生信息
     * @param stuInfo
     */
    @Insert("insert into t_stuInfo(sno,departmentId,name,major,gender,tel) values(#{sno},#{departmentId},#{name},#{major},#{gender},#{tel})")
    void add(StuInfo stuInfo);


    /**
     * 分页查询学生信息
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from t_stuinfo limit #{begin},#{size}")
    List<StuInfo> selectByPage(@Param("begin") int begin, @Param("size") int size);


    /**
     * 查询学生信息总记录数
     * @return
     */
    @Select("select count(*) from t_stuinfo")
    int selectTotalCount();

    /**
     * 分页条件查询学生信息
     * @param begin
     * @param size
     * @return
     */
    List<StuInfo> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size,@Param("stuInfo")StuInfo stuInfo);


    /**
     * 根据条件查询学生信息总记录数
     * @return
     */
    int selectTotalCountByCondition(StuInfo stuInfo);


    /**
     * 编辑学生信息
     * @param stuInfo
     * @return
     */
    List<StuInfo> editStuInfo(StuInfo stuInfo);

    void deleteById(int id);
}





