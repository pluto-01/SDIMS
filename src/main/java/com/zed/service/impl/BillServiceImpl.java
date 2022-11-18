package com.zed.service.impl;

import com.zed.entity.Bill;
import com.zed.entity.Item;
import com.zed.mapper.BillMapper;
import com.zed.mapper.ItemMapper;
import com.zed.mapper.PropertyMapper;
import com.zed.mapper.StuInfoMapper;
import com.zed.service.BillService;
import com.zed.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BillServiceImpl implements BillService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Bill> selectBill() {
            //获取SqlSession对象
            SqlSession sqlSession = factory.openSession();

            //获取UserMapper对象
            BillMapper mapper = sqlSession.getMapper(BillMapper.class);

            //调用方法
            List<Bill> bills = mapper.selectBill();

            //释放资源
            sqlSession.close();

            return bills;
    }

    @Override
    public List<Bill> selectBillByCondition(Bill bill) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        //调用方法
        List<Bill> bills = mapper.selectBillByCondition(bill);

        //释放资源
        sqlSession.close();

        return bills;
    }

    @Override
    public List<Bill> selectDeptBill(String name, String date) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        //调用方法
        List<Bill> bills = mapper.selectDeptBill(name,date);

        //释放资源
        sqlSession.close();

        return bills;
    }

    @Override
    public List<Bill> selectAllBill(String name) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        //调用方法
        List<Bill> bills = mapper.selectAllBill(name);

        //释放资源
        sqlSession.close();

        return bills;
    }

    @Override
    public void editBill(Bill bill) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        mapper.editBill(bill);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void addBill(Bill bill) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        mapper.addBill(bill);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
