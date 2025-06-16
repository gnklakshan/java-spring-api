package com.testjune.june.Service;

import com.testjune.june.Service.transformer.userTransformer;
import com.testjune.june.dao.entity.User;
import com.testjune.june.dao.repository.UserRepository;
import com.testjune.june.dto.request.UserRequest;
import com.testjune.june.dto.response.userResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class userService {
    private final UserRepository userRepository;
    private final userTransformer userTransformer;

    public User updateUser(String id, UserRequest userRequest){
        User user=userTransformer.toSaveUserEntity(userRequest);
        user.setId(Long.valueOf(id));
        User savedUser = userRepository.save(user);

        return savedUser;

    }

    public List<userResponse> getUserList(){
        var users = userRepository.findAll();
        return userTransformer.toUserResponseList(users);
    }

    public ResponseEntity<userResponse> getUserById(Long id){
        var user = userRepository.findById(id).orElse(null);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userTransformer.toUserResponse(user));
    }

    public String newUser(UserRequest userRequest){
        User savedUser = userRepository.save(userTransformer.toSaveUserEntity(userRequest));
        return savedUser.getId().toString();
            }


}

