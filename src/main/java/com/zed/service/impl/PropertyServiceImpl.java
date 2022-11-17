package com.zed.service.impl;

import com.zed.entity.Property;
import com.zed.entity.Visitor;
import com.zed.mapper.PropertyMapper;
import com.zed.mapper.VisitorMapper;
import com.zed.service.PropertyService;
import com.zed.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PropertyServiceImpl implements PropertyService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Property> selectProperty() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        PropertyMapper mapper = sqlSession.getMapper(PropertyMapper.class);

        //调用方法
        List<Property> props = mapper.selectProperty();

        //释放资源
        sqlSession.close();

        return props;
    }

    @Override
    public void addProperty(Property property) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        PropertyMapper mapper = sqlSession.getMapper(PropertyMapper.class);

        mapper.addProperty(property);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
