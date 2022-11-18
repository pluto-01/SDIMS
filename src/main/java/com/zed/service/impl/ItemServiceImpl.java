package com.zed.service.impl;

import com.zed.entity.Item;
import com.zed.entity.Visitor;
import com.zed.mapper.ItemMapper;
import com.zed.mapper.VisitorMapper;
import com.zed.service.ItemService;
import com.zed.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Item> selectItemIn() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);

        //调用方法
        List<Item> items = mapper.selectItemIn();

        //释放资源
        sqlSession.close();

        return items;
    }

    @Override
    public void addItemIn(Item item) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);

        mapper.addItemIn(item);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public List<Item> selectItemOut() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);

        //调用方法
        List<Item> items = mapper.selectItemOut();

        //释放资源
        sqlSession.close();

        return items;
    }

    @Override
    public void addItemOut(Item item) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);

        mapper.addItemOut(item);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
