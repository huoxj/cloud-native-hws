package io.daocloud.adminservice.service;

import io.daocloud.adminservice.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import io.daocloud.adminservice.feign.UserFeign;

@Service
public class UserService {

    @Autowired
    private UserFeign userFeign;

    public Object add(UserVO userVO) {
        if(userVO.getName() == null || userVO.getPwd() == null) return "创建失败！";
        return userFeign.add(userVO);
    }

    public String port() {
        return userFeign.port();
    }
}
