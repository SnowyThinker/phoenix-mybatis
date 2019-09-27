package org.snowman.phoenix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Item implements Serializable {
    private Long id;
    private String sku;
    private String itemName;
    private Long stockQuantity;
    private Integer category1;
    private Integer category2;
    private String supplier;
    private String warehouse;
}
