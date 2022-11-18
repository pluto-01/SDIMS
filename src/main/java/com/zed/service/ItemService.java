package com.zed.service;

import com.zed.entity.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemService {


    /**
     * 查询所有进楼物品信息
     *
     * @return
     */
    @Select("select * from t_itemin")
    List<Item> selectItemIn();

    /**
     * 新增进楼物品登记信息
     *
     * @param item
     */
    @Insert("insert into t_itemin values(#{stuName},#{itemName},#{date},#{notes})")
    void addItemIn(Item item);

    /**
     * 查询所有出楼物品信息
     *
     * @return
     */
    @Select("select * from t_itemOut")
    List<Item> selectItemOut();

    /**
     * 新增进楼物品登记信息
     *
     * @param item
     */
    @Insert("insert into t_itemOut values(#{stuName},#{itemName},#{date},#{notes})")
    void addItemOut(Item item);
}
