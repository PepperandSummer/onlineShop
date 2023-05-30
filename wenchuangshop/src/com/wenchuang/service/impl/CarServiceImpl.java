package com.wenchuang.service.impl;

import com.wenchuang.base.BaseDao;
import com.wenchuang.base.BaseServiceImpl;
import com.wenchuang.mapper.CarMapper;
import com.wenchuang.po.Car;
import com.wenchuang.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public BaseDao<Car> getBaseDao() {
        return carMapper;
    }
}
