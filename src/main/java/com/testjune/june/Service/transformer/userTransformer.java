package com.testjune.june.Service.transformer;

import com.testjune.june.dao.entity.User;
import com.testjune.june.dto.request.UserRequest;
import com.testjune.june.dto.response.userResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class userTransformer {

    public User toSaveUserEntity(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return user;
    }

    public userResponse toUserResponse(User user){
        userResponse response = new userResponse();
        BeanUtils.copyProperties(user,response);
        return response;
    }

    public List<userResponse> toUserResponseList(List<User> users) {
        return users.stream()
                .map(this::toUserResponse)
                .collect(Collectors.toList());
    }


}
