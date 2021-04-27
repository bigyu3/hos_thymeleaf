package com.gty.hos.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gty.hos.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gty.hos.vo.ActiveUser;
import com.gty.hos.vo.ResponseResult;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
public interface IUserService extends IService<User> {


    /*
     *
     * 根据用户名查询
     *
     * */
    User findUserByName(String username);

    /*
     * 校验登陆  参数 user session  返回 RR
     *
     * */

    ResponseResult checkUser(User user, HttpSession session);

    /*
     *校验注册
     *
     * */

    ResponseResult registerUser(ActiveUser activeUser);

    /*
    * 根据主键id查询
    * */
    User findOne(Integer id);
    /*
    * 分页查询
    * */
    IPage<User> findList(Integer pageNo , Integer pageSize,String username);

    /*
    * 删除用户
    * */
    ResponseResult deleteUser(Integer id);
    /*
    * 更新用户
    * */
    ResponseResult updateUser(User user);
    /*
    * 增加用户
    * */
    ResponseResult insertUser(User user);// 有问题 没写完  还需要判断医生的逻辑

}
