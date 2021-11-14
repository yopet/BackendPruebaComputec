package com.crud.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.prueba.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
