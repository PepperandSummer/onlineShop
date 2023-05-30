package com.wenchuang.service.impl;

import com.wenchuang.base.BaseDao;
import com.wenchuang.base.BaseServiceImpl;
import com.wenchuang.mapper.ItemMapper;
import com.wenchuang.po.Item;
import com.wenchuang.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public BaseDao<Item> getBaseDao() {
        return itemMapper;
    }
}
