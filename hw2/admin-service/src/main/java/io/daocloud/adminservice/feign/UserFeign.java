package io.daocloud.adminservice.feign;

import io.daocloud.adminservice.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-service")
public interface UserFeign {
    @PostMapping("/user")
    UserVO add(UserVO userVO);

    @GetMapping("/port")
    String port();
}
