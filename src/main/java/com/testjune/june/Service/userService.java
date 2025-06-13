package com.testjune.june.Service;

import com.testjune.june.Service.transformer.userTransformer;
import com.testjune.june.dao.entity.User;
import com.testjune.june.dao.repository.UserRepository;
import com.testjune.june.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service

public class userService {
    private final UserRepository userRepository;
    private final userTransformer userTransformer;

    public User saveUser(UserRequest userRequest){
        User user=userTransformer.toSaveUserEntity(userRequest);
        User savedUser = userRepository.save(user);

        return savedUser;

    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }


}

