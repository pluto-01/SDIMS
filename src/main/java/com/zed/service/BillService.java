package com.zed.service;

import com.zed.entity.Bill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillService {
    /**
     * 查询所有宿舍所有费用记录
     * @return
     */
    List<Bill> selectBill();

    /**
     * 管理员通过条件查询宿舍费用记录
     * @param bill
     * @return
     */
    List<Bill> selectBillByCondition(Bill bill);

    /**
     * 学生端查询本宿舍本月费用记录
     * @param name
     * @param date
     * @return
     */
    List<Bill> selectDeptBill(String name,String date);

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
    void editBill(Bill bill);

    /**
     * 管理员新增费用记录
     * @param bill
     */
    void addBill(Bill bill);
}
