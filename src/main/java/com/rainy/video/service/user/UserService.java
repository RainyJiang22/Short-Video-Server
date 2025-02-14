package com.rainy.video.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainy.video.table.TableUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<TableUser> queryFans(@Param("userId") long userId, @Param("offset") int offset, @Param("pageCount") int pageCount);

    List<TableUser> queryFollows(@Param("userId") long userId, @Param("offset") int offset, @Param("pageCount") int pageCount);


}
