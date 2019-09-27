package org.snowman.phoenix.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.snowman.phoenix.entity.Item;

import java.util.List;

@Mapper
public interface ItemMapper {

    Integer save(Item item);

    Item queryById(Long id);

    Item queryBySku(String sku);

    List<Item> queryByCategory1(Integer category1);
}
