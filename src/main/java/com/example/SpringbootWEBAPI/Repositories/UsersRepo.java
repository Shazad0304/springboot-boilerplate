package com.example.SpringbootWEBAPI.Repositories;

import com.example.SpringbootWEBAPI.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsersRepo extends JpaRepository<Users,UUID> {

    @Query(value = "select * from users where lower(email) = :email and password = :pass",nativeQuery = true)
    public Users getUserByCredentials(String email,String pass);

    @Query(value = "select * from users where user_id = :id",nativeQuery = true)
    public Users getById(UUID id);

}