package com.example.userservice.service.Impl;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import com.example.config.Key;
import com.example.exception.GlobalException;
import com.example.userservice.algorithm.RSAUtil;
import com.example.userservice.db.dao.UserDao;
import com.example.userservice.db.entity.UserEntity;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;

    @Value("${server.port}")
    private Integer workerId;

    @Override
    @Transactional
    public String login(UserEntity userEntity) {
        try {
            if(userEntity.getAccount() == null || userEntity.getPassword() == null){
                throw new GlobalException("账号或密码不能为空");
            }else{
                HashMap map = new HashMap();
                map.put("account", userEntity.getAccount());
                if(userDao.selectUser(map) == 0){
                    throw new GlobalException("账号错误");
                }else {
                    String encodedData = userDao.getOther(map).get("password").toString();
                    Key key = new Key();
                    String decodedData = RSAUtil.privateDecrypt(encodedData, RSAUtil.getPrivateKey(key.getSkey()));
                    if(userEntity.getAccount().equals(decodedData)){
                        long id = (long) userDao.getOther(map).get("id");
                        StpUtil.login(id);
                        String token = StpUtil.getTokenInfo().getTokenValue();
                        return token;
                    }else {
                        throw new GlobalException("密码错误");
                    }
                }
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    @Transactional
    public long register(Map param) {
        HashMap mapTemp = new HashMap();
        if(param.get("account") != null){
            mapTemp.put("account", param.get("account"));
        }else {
            return 0L;
        }
        try {
            if(userDao.selectUser(mapTemp) != 0){
                throw new GlobalException("用户已存在");
            }
            else {
                if (param.get("password") != null) {
                    Snowflake snowflake = new Snowflake(workerId%2, 1);
                    long id = snowflake.nextId();
                    param.put("id", id);
                    Key key = new Key();
                    String encodedData = RSAUtil.publicEncrypt(param.get("password").toString(), RSAUtil.getPublicKey(key.getGkey()));
                    param.replace("password",encodedData);
                    if(userDao.insertuser(param)!=0){
                        return id;
                    }else {
                        return 0L;
                    }
                } else {
                    return 0L;
                }
            }
        }catch (Exception e){
            return 0L;
        }
    }
}
