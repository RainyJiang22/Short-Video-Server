package com.rainy.video.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Jacky
 * @date 2024/12/6
 **/
public interface UserService extends IService<TableUser> {

    TableUser queryUser(@Param("userId") long userId);

    TableUser queryUserByQQOpenId(@Param("qqOpenId") String qqOpenId);

    int insert(@Param("user") TableUser user);

    int update(@Param("user") TableUser user);

    int delete(@Param("userId") long userId);


}
