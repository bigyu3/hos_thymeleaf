package com.gty.hos.mapper;

import com.gty.hos.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
// 根据用户名查询
//    User findUserByName(@Param("username") String username);

}
