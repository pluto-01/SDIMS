package com.zed.service.impl;

import com.zed.mapper.StuInfoMapper;
import com.zed.pojo.Page;
import com.zed.pojo.StuInfo;
import com.zed.service.StuInfoService;
import com.zed.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StuInfoServiceImpl implements StuInfoService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<StuInfo> selectStu() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        StuInfoMapper mapper = sqlSession.getMapper(StuInfoMapper.class);

        //调用方法
        List<StuInfo> stus = mapper.selectStu();

        //释放资源
        sqlSession.close();

        return stus;
    }


    @Override
    public void add(StuInfo stuInfo) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        StuInfoMapper mapper = sqlSession.getMapper(StuInfoMapper.class);

        mapper.add(stuInfo);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public Page<StuInfo> selectByPage(int currentPage, int pageSize) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        StuInfoMapper mapper = sqlSession.getMapper(StuInfoMapper.class);

        //计算开始索引
        int begin = (currentPage - 1) * pageSize;

        //查询当前页数据
        List<StuInfo> rows = mapper.selectByPage(begin, pageSize);

        //查询总记录数
        int totalCount = mapper.selectTotalCount();

        //封装page对象
        Page<StuInfo> page = new Page<>();
        page.setRows(rows);
        page.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();

        return page;
    }

    @Override
    public Page<StuInfo> selectByPageAndCondition(int currentPage, int pageSize, StuInfo stuInfo) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        StuInfoMapper mapper = sqlSession.getMapper(StuInfoMapper.class);

        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //计算查询条目数量
        int size = pageSize;

        //处理模糊查询表达式
        String sno = stuInfo.getSno();
        if (sno != null && sno.length() > 0) {
            stuInfo.setSno("%" + sno + "%");
        }
        String departmentId = stuInfo.getDepartmentId();
        if (departmentId != null && departmentId.length() > 0) {
            stuInfo.setDepartmentId("%" + departmentId + "%");
        }
//        String name = stuInfo.getName();
//        if (name != null & name.length() > 0) {
//            stuInfo.setName("%" + name + "%");
//        }
        //查询当前页数据
        List<StuInfo> rows = mapper.selectByPageAndCondition(begin, size, stuInfo);

        //查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(stuInfo);

        //封装page对象
        Page<StuInfo> page = new Page<>();
        page.setRows(rows);
        page.setTotalCount(totalCount);

        sqlSession.close();

        return page;
    }

    @Override
    public void editStuInfo(StuInfo stuInfo) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        StuInfoMapper mapper = sqlSession.getMapper(StuInfoMapper.class);

        mapper.editStuInfo(stuInfo);
        //提交事务
        sqlSession.commit();

        sqlSession.close();

    }

    @Override
    public void deleteStuInfo(int id) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper对象
        StuInfoMapper mapper = sqlSession.getMapper(StuInfoMapper.class);

        mapper.deleteById(id);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

}
