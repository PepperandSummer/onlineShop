package com.wenchuang.service.impl;

import com.wenchuang.base.BaseDao;
import com.wenchuang.base.BaseServiceImpl;
import com.wenchuang.mapper.PostMapper;
import com.wenchuang.po.Post;
import com.wenchuang.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends BaseServiceImpl<Post> implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public BaseDao<Post> getBaseDao() {
        return postMapper;
    }
}
