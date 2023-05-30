package com.wenchuang.service.impl;

import com.wenchuang.base.BaseDao;
import com.wenchuang.base.BaseServiceImpl;
import com.wenchuang.mapper.EventsMapper;
import com.wenchuang.po.Events;
import com.wenchuang.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsServiceImpl extends BaseServiceImpl<Events> implements EventsService {
    @Autowired
    private EventsMapper eventsMapper;
    @Override
    public BaseDao<Events> getBaseDao() {
        return eventsMapper;
    }
}
