package com.zed.service;

import com.zed.entity.Repair;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RepairService {


    /**
     * 查询所有报修信息
     * @return
     */
    List<Repair> selectRepair();

    /**
     * 管理员对报修信息进行修改
     * @param repair
     * @return
     */
    void editRepairInfo(Repair repair);

    /**
     * 学生添加报修信息
     * @param repair
     */
    void addRepairInfo(Repair repair);
}
