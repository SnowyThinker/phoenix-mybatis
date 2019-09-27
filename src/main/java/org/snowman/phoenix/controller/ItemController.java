package org.snowman.phoenix.controller;

import org.snowman.phoenix.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "item/batchadd")
    public Map<String, Object> batchAdd() {
        itemService.batchAdd();
        return new HashMap<String, Object>();
    }
}
