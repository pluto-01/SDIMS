package com.zed.service;

import com.zed.entity.Property;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PropertyService {

    /**
     * 查询所有财产信息
     * @return
     */
    List<Property> selectProperty();

    /**
     * 新增财产信息
     * @param property
     */
    void addProperty(Property property);
}
