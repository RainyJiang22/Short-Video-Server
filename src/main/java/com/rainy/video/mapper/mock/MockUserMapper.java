package com.rainy.video.mapper.mock;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainy.video.table.TableUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jacky
 * @date 2025/7/18
 **/

@Mapper
public interface MockUserMapper extends BaseMapper<TableUser> {
}
