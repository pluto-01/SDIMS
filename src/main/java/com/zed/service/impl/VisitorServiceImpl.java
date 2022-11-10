package com.zed.service.impl;


import com.zed.mapper.VisitorMapper;
import com.zed.entity.Visitor;
import com.zed.service.VisitorService;
import com.zed.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class VisitorServiceImpl implements VisitorService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询访客信息
     * @return
     */
    @Override
    public List<Visitor> selectVisitor() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        VisitorMapper mapper = sqlSession.getMapper(VisitorMapper.class);

        //调用方法
        List<Visitor> vsts = mapper.selectVisitor();

        //释放资源
        sqlSession.close();

        return vsts;
    }


    /**
     * 新增访客信息 --->访客登记功能
     * @param visitor
     */
    @Override
    public void addVisitor(Visitor visitor) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        VisitorMapper mapper = sqlSession.getMapper(VisitorMapper.class);

        mapper.addVisitor(visitor);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
