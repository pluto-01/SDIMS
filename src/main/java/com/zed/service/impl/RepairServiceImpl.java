package com.zed.service.impl;

import com.zed.entity.Property;
import com.zed.entity.Repair;
import com.zed.mapper.PropertyMapper;
import com.zed.mapper.RepairMapper;
import com.zed.mapper.StuInfoMapper;
import com.zed.mapper.VisitorMapper;
import com.zed.service.RepairService;
import com.zed.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class RepairServiceImpl implements RepairService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Repair> selectRepair() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        RepairMapper mapper = sqlSession.getMapper(RepairMapper.class);

        //调用方法
        List<Repair> repairs = mapper.selectRepair();

        //释放资源
        sqlSession.close();

        return repairs;
    }

    @Override
    public void editRepairInfo(Repair repair) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        RepairMapper mapper = sqlSession.getMapper(RepairMapper.class);

        mapper.editRepairInfo(repair);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void addRepairInfo(Repair repair) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        RepairMapper mapper = sqlSession.getMapper(RepairMapper.class);

        mapper.addRepairInfo(repair);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void editRepairInfoByWorker(Repair repair) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        RepairMapper mapper = sqlSession.getMapper(RepairMapper.class);

        mapper.editRepairInfoByWorker(repair);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
