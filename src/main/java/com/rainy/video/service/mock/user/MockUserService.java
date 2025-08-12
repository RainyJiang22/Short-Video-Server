package com.rainy.video.service.mock.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableUser;
import com.rainy.video.table.User;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/7/18
 **/
public interface MockUserService extends IService<TableUser> {
    int delete(int id);

    int Update(User user);

    int insertUser(User user);

    List<User> ListUser();

    List<User> findUserByName(String name);
}
