package com.wanchenyang.demo07jpa.repository;

import com.wanchenyang.demo07jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long>
{
    User findByUserName(String username);
    User findByUserNameOrEmail(String username,String email);

    @Query("select u from User u")
    Page<User> findAll(Pageable pageable);

    @Modifying
    @Query("update User set userName = ?1 where id=?2")
    int modifyById(String userName,Long id);

    @Modifying
    @Query("delete from User where id =?1")
    void deleteById(Long id);

}
