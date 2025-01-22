package com.novaedge.micro.userservice.serviceImpl;

import com.novaedge.micro.userservice.entity.TbNovaMcroUser;
import com.novaedge.micro.userservice.exception.ResoureceNotFoundException;
import com.novaedge.micro.userservice.repository.TbNovaMcroUserRepository;
import com.novaedge.micro.userservice.service.TbNovaMcroUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TbNovaMcroUserServiceImpl implements TbNovaMcroUserService{

    @Autowired
    private TbNovaMcroUserRepository userRepository;

    // Create or update a user
    @Override
    public TbNovaMcroUser saveUser(TbNovaMcroUser user) {
    	user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    // Find user by ID
    @Override
    public TbNovaMcroUser getUserById(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(()-> new ResoureceNotFoundException("User with given id is not present on server !! :"+ userId));
    }

    // Find all users
    @Override
    public List<TbNovaMcroUser> getAllUsers() {
        return userRepository.findAll();
    }

    // Delete user by ID
    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
