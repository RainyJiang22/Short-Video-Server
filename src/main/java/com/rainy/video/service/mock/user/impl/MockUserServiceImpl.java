package com.rainy.video.service.mock.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.mock.MockUserMapper;
import com.rainy.video.service.mock.user.MockUserService;
import com.rainy.video.table.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/7/18
 **/
@Primary
@Service
public class MockUserServiceImpl extends ServiceImpl<MockUserMapper, TableUser> implements MockUserService {
    @Override
    public int delete(int id) {
        return 0;
    }


    @Override
    public int Update(User user) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public List<User> ListUser() {
        return null;
    }

    @Override
    public List<User> findUserByName(String name) {
        return null;
    }
}

