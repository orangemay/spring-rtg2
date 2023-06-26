package com.example.demo2.user;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(value="select * from users", nativeQuery = true)
    List<User> findAll();

    @Query(value="select * from users where name = ?1", nativeQuery = true)
    List<User> findByName(String name);

    @Query(value="select * from users limit ?1 offset ?2", nativeQuery = true)
    List<User> getUsersByPageNo(int limit, int offset);

    @Transactional
    @Modifying
    @Query(value="update users set name = ?2, mail = ?3 where id = ?1", nativeQuery = true)
    void updateUserById(int id, String name, String mail);

}