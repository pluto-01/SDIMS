package com.zed.service;

import com.zed.entity.Page;
import com.zed.entity.StuInfo;


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


    void editStuInfo(StuInfo stuInfo);

    void deleteStuInfo(int id);
}

