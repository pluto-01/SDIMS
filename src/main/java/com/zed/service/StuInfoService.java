package com.zed.service;

import com.zed.entity.Page;
import com.zed.entity.StuInfo;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface StuInfoService {
    /**
     * 查询所有学生信息
     * @return
     */
      List<StuInfo> selectStu();


    /**
     * 新增学生信息
     * @param stuInfo
     */
    void add(StuInfo stuInfo);


    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize  每页展示条数
     * @return
     */
    Page<StuInfo> selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param stuInfo
     * @return
     */
    Page<StuInfo> selectByPageAndCondition(int currentPage,int pageSize,StuInfo stuInfo);


    /**
     * 编辑学生信息
     * @param stuInfo
     * @return
     */
    void editStuInfo(StuInfo stuInfo);

    /**
     * 根据从前端获取的id删除对应行信息
     * @param id
     */
    void deleteStuInfo(int id);

    /**
     * 查询宿舍楼中所有宿舍的电话号码
     * @return
     */
    List<StuInfo> selectDepartmentTel();

    /**
     * 根据宿舍号查询对于宿舍电话号码
     * @param stuInfo
     * @return
     */
    List<StuInfo> selectTelByCondition(StuInfo stuInfo);
}

