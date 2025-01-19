package com.tekarch.TafUserService.service;

import com.tekarch.TafUserService.dto.UserDTO;
import com.tekarch.TafUserService.service.interfaces.UserService;
import org.apache.catalina.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Value("${datastore.service.url}")
    private String datastoreServiceUrl;
    //private static final Logger logger= LogManager.getLogger(UserServiceImpl.class);

    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDTO registerUser(UserDTO user) {
        String url = datastoreServiceUrl + "/register";
        try {
            return restTemplate.postForObject(url, user, UserDTO.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Handle the error based on the status code
            throw new RuntimeException("Error registering user: " + e.getMessage());
        }
    }

    @Override
    public UserDTO getUser(Long userId) {
        String url = datastoreServiceUrl + "/" + userId;
        try {
            return restTemplate.getForObject(url, UserDTO.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("User not found: " + e.getMessage());
        }
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO user) {
        String url = datastoreServiceUrl + "/" + userId;
        try {
            restTemplate.put(url, user);
            return user;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new RuntimeException("Error updating user: " + e.getMessage());
        }
    }




}