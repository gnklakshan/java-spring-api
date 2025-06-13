package com.testjune.june.Service.transformer;

import com.testjune.june.dao.entity.User;
import com.testjune.june.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class userTransformer {

    public User toSaveUserEntity(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return user;
    }

}
