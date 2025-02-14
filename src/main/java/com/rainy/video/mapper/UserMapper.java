package com.rainy.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainy.video.table.TableUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jacky
 * @date 2025/2/12
 **/

@Mapper
public interface UserMapper extends BaseMapper<TableUser> {

}
