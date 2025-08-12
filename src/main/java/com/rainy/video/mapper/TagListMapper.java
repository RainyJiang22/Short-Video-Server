package com.rainy.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainy.video.table.TableTagList;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jacky
 * @date 2025/8/12
 **/
@Mapper
public interface TagListMapper extends BaseMapper<TableTagList> {
}
