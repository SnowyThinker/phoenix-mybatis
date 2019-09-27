package org.snowman.phoenix.mapper;

import org.snowman.phoenix.entity.Item;

import java.util.List;

public interface ItemMapper {

    Integer save(Item item);

    Item queryById(Long id);

    Item queryBySku(String sku);

    List<Item> queryByCategory1(Integer category1);
}
