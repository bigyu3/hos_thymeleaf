package com.gty.hos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gty.hos.common.Global;
import com.gty.hos.mapper.DoctorMapper;
import com.gty.hos.mapper.PatientMapper;
import com.gty.hos.pojo.Doctor;
import com.gty.hos.pojo.Patient;
import com.gty.hos.pojo.User;
import com.gty.hos.mapper.UserMapper;
import com.gty.hos.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gty.hos.vo.ActiveUser;
import com.gty.hos.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.interfaces.RSAKey;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bigyu
 * @since 2021-01-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private ResponseResult result;

    // 根据用户名查询
    @Override
    public User findUserByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.lambda().eq(User::getUsername, username);
        User user = userMapper.selectOne(wrapper);
        return user;
    }

    //根据idcard来查询 医生
    public Doctor findDoctorByIdCard(String idcard) {
        QueryWrapper<Doctor> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Doctor::getIdcard, idcard);
        Doctor doctor = doctorMapper.selectOne(wrapper);
        return doctor;
    }

    //根据idcard来查询 患者
    public Patient findPatientByIdCard(String idcard) {
        QueryWrapper<Patient> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Patient::getIdcard, idcard);
        Patient patient = patientMapper.selectOne(wrapper);
        return patient;
    }

    @Override
    public ResponseResult checkUser(User user, HttpSession session) {


        //拿到传入的用户名 调用 根据用户名查找 用户
        User sysUser = this.findUserByName(user.getUsername());//数据库的用户
        //判断是否查询为空
        if (sysUser == null) {
            result.setCode("201"); //用户不存在
            result.setMessage("用户名或者密码错误");
        } else {
            //判断密码是否正确 传入的user密码和 数据库里的user密码 一致
            if (user.getPassword().equals(sysUser.getPassword())) {
                result.setCode("202");
                result.setMessage(String.valueOf(sysUser.getRole())); //绑定登陆的职能
                //把用户信息绑定到session中
                session.setAttribute("user", sysUser);
            } else {
                result.setCode("203");//密码错误
                result.setMessage("用户名或者密码错误");
            }
        }


        return result;
    }

    @Override
    public ResponseResult registerUser(ActiveUser activeUser) {

        /*
         * 需要先 注册一个管理员 让管理员添加患者或医生 添加到数据库中doctor和patient
         * 后才能根据数据库里存在的idcard字段来把 患者或者医生注册成到user表中 role字段 1 管理员
         * 2 医生 3 患者
         * */
        //先查一下 医生或患者表里idcard 字段
        Doctor sysDoctor = this.findDoctorByIdCard(activeUser.getIdcard());
        Patient sysPatient = this.findPatientByIdCard(activeUser.getIdcard());
        //根据传入activeUser的名字查询在数据库有没有被注册过
        User sysUser = this.findUserByName(activeUser.getUsername());
        if (sysUser != null) { // 如果不为null 则在数据库中已存在
            result.setCode("101");
            result.setMessage("用户名已被使用!");
        }
        //注册的逻辑判断 没有idcard 身份证 属性就注册为管理员
        else if (activeUser.getIdcard().isEmpty() && sysUser == null) {//身份证为空并数据库中没有同名用户
            //注册一个新的用户到数据库
            sysUser = new User();
            sysUser.setUsername(activeUser.getUsername());
            sysUser.setPassword(activeUser.getPassword());
            //调用mp的insert 放到数据库
            int insert = userMapper.insert(sysUser);
            if (insert != 0) {
                result.setCode("102");
                result.setMessage("管理账号注册成功!");
            }
        } else if(sysDoctor != null ){//注册为医生
            if(sysDoctor.getUserId() == null){
                sysUser = new User();
                sysUser.setRole(2);
                sysUser.setUsername(activeUser.getUsername());
                sysUser.setPassword(activeUser.getPassword());
                userMapper.insert(sysUser);//插入到user表
                //更新医生表
                sysDoctor.setUserId(this.findUserByName(activeUser.getUsername()).getId());
                doctorMapper.updateById(sysDoctor);
                result.setCode("103");
                result.setMessage("医生账号注册成功!");
            }else{
                result.setCode("105");
                result.setMessage("身份证被占用!");
            }

        }else if(sysPatient !=null){ //注册为病人
            if(sysPatient.getUserId() == null){
                sysUser = new User();
                sysUser.setRole(3);
                sysUser.setUsername(activeUser.getUsername());
                sysUser.setPassword(activeUser.getPassword());
                userMapper.insert(sysUser);
                //更新病人表
                sysPatient.setUserId(this.findUserByName(activeUser.getUsername()).getId());
                patientMapper.updateById(sysPatient);
                result.setCode("104");
                result.setMessage("病人账号注册成功!");
            }else {
                result.setCode("105");
                result.setMessage("身份证被占用!");
            }
        }else {//身份证还没注册
            result.setCode("106");
            result.setMessage("你当前还不是医生或患者");
        }
        return result;
    }

    @Override
    public User findOne(Integer id) {
        return  userMapper.selectById(id);
    }

    @Override
    public IPage<User> findList(Integer pageNo, Integer pageSize, String username) {
        Page<User> page = new Page<>(pageNo,pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(User::getUsername,username);
        IPage<User> userIPage = userMapper.selectPage(page, wrapper);

        return userIPage;
    }

    @Override
    public ResponseResult deleteUser(Integer id) {
        int i = userMapper.deleteById(id);
        if(i!=0){//删除成功
            result.setCode(Global.DEL_CODE_SUCCESS);
            result.setMessage(Global.DEL_MSG_SUCCESS);
        }else {//删除失败
            result.setCode(Global.DEL_CODE_ERROR);
            result.setMessage(Global.DEL_MSG_ERROR);
        }
        return result;
    }

    @Override
    public ResponseResult updateUser(User user) {
        int i = userMapper.updateById(user);
        if(i>0){
            //更新成功
            result.setCode(Global.SAVE_CODE_SUCCESS);
            result.setMessage(Global.SAVE_MSG_SUCCESS);
        }else {
            result.setCode(Global.SAVE_CODE_ERROR);
            result.setMessage(Global.SAVE_MSG_ERROR);
        }
        return result;
    }

    @Override
    public ResponseResult insertUser(User user) {


        int i = userMapper.insert(user);
        if(i>0){
            //更新成功
            result.setCode(Global.SAVE_CODE_SUCCESS);
            result.setMessage(Global.SAVE_MSG_SUCCESS);
        }else {
            result.setCode(Global.SAVE_CODE_ERROR);
            result.setMessage(Global.SAVE_MSG_ERROR);
        }
        return result;
    }


}
