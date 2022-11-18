package com.zed.mapper;

import com.zed.entity.Bill;
import com.zed.entity.Property;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillMapper {

    /**
     * 管理员查询所有宿舍所有费用记录
     * @return
     */
    @Select("select * from t_bill")
    List<Bill> selectBill();


    /**
     * 学生端查询本宿舍本月费用记录
     * @param name
     * @param date
     * @return
     */
    List<Bill> selectDeptBill(@Param("name") String name, @Param("date") String date);

    /**
     * 学生端查询本宿舍所有费用记录
     * @param name
     * @return
     */
    List<Bill> selectAllBill(String name);


    /**
     * 管理员编辑费用记录
     * @param bill
     * @return
     */
    List<Bill> editBill(Bill bill);

    /**
     * 管理员新增费用记录
     * @param bill
     */
    @Insert("insert into t_bill (departmentId, waterbill, elecbill, date) values(#{departmentId},#{waterBill},#{elecBill},#{date})")
    void addBill(Bill bill);


    /**
     * 管理员通过条件查询宿舍费用记录
     * @param bill
     * @return
     */
    List<Bill> selectBillByCondition(Bill bill);
}
