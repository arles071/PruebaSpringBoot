package com.tiendalibros.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendalibros.com.entitys.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
