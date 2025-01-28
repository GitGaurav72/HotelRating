package com.novaedge.micro.userservice.serviceImpl;

import com.novaedge.micro.userservice.entity.TbNovaMcroUser;
import com.novaedge.micro.userservice.exception.ResoureceNotFoundException;
import com.novaedge.micro.userservice.repository.TbNovaMcroUserRepository;
import com.novaedge.micro.userservice.service.TbNovaMcroUserService;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TbNovaMcroUserServiceImpl implements TbNovaMcroUserService{

    @Autowired
    private TbNovaMcroUserRepository userRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    private Logger logger = LoggerFactory.getLogger(TbNovaMcroUserServiceImpl.class);

    // Create or update a user
    @Override
    public TbNovaMcroUser saveUser(TbNovaMcroUser user) {
    	user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    // Find user by ID
    @Override
    public TbNovaMcroUser getUserById(String userId) {
    	TbNovaMcroUser tbNovaMcroUser = userRepository.findByUserId(userId).orElseThrow(()-> new ResoureceNotFoundException("User with given id is not present on server !! :"+ userId));
    	ArrayList forObject = restTemplate.getForObject("http://192.168.13.205:8083/api/ratings/user/"+tbNovaMcroUser.getUserId(), ArrayList.class);
    	logger.info("{}",forObject);
    	tbNovaMcroUser.setRatings(forObject);
    	
        return tbNovaMcroUser;
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
