package com.rainy.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainy.video.table.TableTagList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jacky
 * @date 2025/8/12
 **/
@Mapper
public interface TagListMapper extends BaseMapper<TableTagList> {
    @Select("select * from table_tag_list,table_tag_list_like " +
            "where table_tag_list.tag_id>${tagId} "+
            "and table_tag_list.tag_id=table_tag_list_like.tag_id " +
            "and table_tag_list_like.user_id =${userId} " +
            "and table_tag_list_like.has_like=true")
    List<TableTagList> queryLikedTagList(@Param("tagId") long tagId, @Param("userId") long userId);

    @Select("select * from table_tag_list where table_tag_list.tag_id>${tagId}")
    List<TableTagList> queryAllTagList(@Param("tagId") long tagId, @Param("userId") long userId);
}
