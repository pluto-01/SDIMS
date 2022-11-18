package com.zed.mapper;

import com.zed.entity.Repair;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RepairMapper {

    /**
     * 查询所有报修信息
     *
     * @return
     */
    @Select("select * from t_repair")
    List<Repair> selectRepair();

    /**
     * 管理员对报修信息进行修改
     *
     * @param repair
     * @return
     */
    void editRepairInfo(Repair repair);

    /**
     * 学生添加报修信息
     *
     * @param repair
     */
    @Insert("insert into t_repair(departmentId, propertyNum, startdate, reason) values(#{departmentId},#{propertyNum},#{startDate},#{reason})")
    void addRepairInfo(Repair repair);

    /**
     * 职工编辑报修状态
     * @param repair
     */
    void editRepairInfoByWorker(Repair repair);
}
