package com.zed.mapper;

import com.zed.entity.Property;
import com.zed.entity.Visitor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PropertyMapper {

    /**
     * 查询所有财产信息
     *
     * @return
     */
    @Select("select * from t_property")
    List<Property> selectProperty();


    /**
     * 新增财产信息
     *
     * @param property
     */
    @Insert("insert into t_property values(#{propertyNum},#{propertyName},#{propertyCount})")
    void addProperty(Property property);
}
