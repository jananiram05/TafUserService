package com.tekarch.TafUserService.service.interfaces;

import com.tekarch.TafUserService.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO user);

    UserDTO getUser(Long userId);

    UserDTO updateUser(Long userId, UserDTO user);

}