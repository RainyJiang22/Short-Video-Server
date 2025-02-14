package com.rainy.video.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainy.video.mapper.UserMapper;
import com.rainy.video.service.user.UserService;
import com.rainy.video.table.TableUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/2/12
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TableUser> implements UserService {

    @Override
    public TableUser queryUser(long userId) {
        QueryWrapper<TableUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.last("limit 1");
        List<TableUser> list = list(queryWrapper);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public TableUser queryUserByQQOpenId(String qqOpenId) {
        QueryWrapper<TableUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("qq_open_id", qqOpenId);
        queryWrapper.last("limit 1");
        List<TableUser> list = list(queryWrapper);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int insert(TableUser user) {
        return update(user);
    }

    @Override
    public int update(TableUser user) {
        return saveOrUpdate(user) ? 1 : 0;
    }

    @Override
    public int delete(long userId) {
        //delete from table_user where id = {$id}
        QueryWrapper<TableUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return getBaseMapper().delete(queryWrapper);
    }
}
