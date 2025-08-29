package com.fjtneo4j.demo.service;

import com.fjtneo4j.demo.entity.User;
import com.fjtneo4j.demo.repository.UserRepository;
import com.fjtneo4j.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        // 1. 业务逻辑：数据验证、去重等
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists: " + userDto.getEmail());
        }

        // 2. 将 DTO 转换为 Entity
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        // 3. 调用 Repository 保存数据
        User savedUser = userRepository.save(user);

        // 4. 将保存后的 Entity 转换为 DTO 返回
        return new UserDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    public Optional<UserDto> getUserById(Long id) {
        // 1. 调用 Repository 获取 Entity
        Optional<User> userOptional = userRepository.findById(id);

        // 2. 将 Entity 转换为 DTO
        return userOptional.map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()));
    }

    public List<UserDto> getAllUsers() {
        // 1. 调用 Repository 获取所有 Entity
        List<User> users = userRepository.findAll();

        // 2. 使用 Stream API 将 Entity 列表转换为 DTO 列表
        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    // 更多业务方法，如 updateUser, deleteUser 等
}
