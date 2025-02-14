package com.rainy.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainy.video.table.TableUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/2/12
 **/

@Mapper
public interface UserMapper extends BaseMapper<TableUser> {

    @Select("select * from table_user,table_user_follow where table_user_follow.user_id = #{userId} and table_user_follow.has_follow=1 AND table_user_follow.follow_user_id = table_user.user_id order by table_user_follow.id desc limit #{pageCount} offset #{offset}")
    List<TableUser> queryFans(@Param("userId") long userId, @Param("offset") int offset, @Param("pageCount") int pageCount);

    @Select("select * from table_user,table_user_follow where table_user_follow.follow_user_id = #{userId} and table_user_follow.has_follow=1 AND table_user_follow.user_id = table_user.user_id order by table_user_follow.id desc limit #{pageCount} offset #{offset}")
    List<TableUser> queryFollows(@Param("userId") long userId, @Param("offset") int offset, @Param("pageCount") int pageCount);

}
