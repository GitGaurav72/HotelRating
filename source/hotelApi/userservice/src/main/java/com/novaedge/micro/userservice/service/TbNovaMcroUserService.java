package com.novaedge.micro.userservice.service;
import com.novaedge.micro.userservice.entity.TbNovaMcroUser;
import com.novaedge.micro.userservice.repository.TbNovaMcroUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TbNovaMcroUserService {

    public TbNovaMcroUser saveUser(TbNovaMcroUser user);
    public TbNovaMcroUser getUserById(String userId);
    public List<TbNovaMcroUser> getAllUsers();
    public void deleteUser(String userId);
}
