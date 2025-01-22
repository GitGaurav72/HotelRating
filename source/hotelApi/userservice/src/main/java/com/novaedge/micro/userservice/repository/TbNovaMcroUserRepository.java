package com.novaedge.micro.userservice.repository;

import com.novaedge.micro.userservice.entity.TbNovaMcroUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbNovaMcroUserRepository extends JpaRepository<TbNovaMcroUser, String> {

	
	Optional<TbNovaMcroUser> findByUserId(String userId);
}
