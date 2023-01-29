package com.example.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.datastore.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
