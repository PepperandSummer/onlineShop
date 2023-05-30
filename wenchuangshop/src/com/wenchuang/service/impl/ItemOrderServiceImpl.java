package com.wenchuang.service.impl;

import com.wenchuang.base.BaseDao;
import com.wenchuang.base.BaseServiceImpl;
import com.wenchuang.mapper.ItemOrderMapper;
import com.wenchuang.po.ItemOrder;
import com.wenchuang.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderServiceImpl extends BaseServiceImpl<ItemOrder> implements ItemOrderService {

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Override
    public BaseDao<ItemOrder> getBaseDao() {
        return itemOrderMapper;
    }
}
