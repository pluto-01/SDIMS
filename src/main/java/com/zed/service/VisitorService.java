package com.zed.service;

import com.zed.entity.Visitor;

import java.util.List;

public interface VisitorService {
    /**
     * 查询访客信息
     * @return
     */
    List<Visitor> selectVisitor();

    /**
     * 新增访客信息 --->访客登记功能
     * @param visitor
     */
    void addVisitor(Visitor visitor);
}
