package com.wanchenyang.demo08jpathymeleaf.Repository;

import com.wanchenyang.demo08jpathymeleaf.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



/**
 * @program: demo08jpathymeleaf
 * @author: wan chenyang
 * @create: 2019-06-23 08:41
 * @description: 编写我们需要的 SQL 和分页查询。
 * 继承 JpaRepository 类会自动实现很多内置的方法，
 * 包括增、删、改、查，也可以根据方法名来自动生成相
 * 关 SQL。
 * @version: 1.0
 */
public interface UserRepository extends JpaRepository<User,Long>
{
    @Query("select u from User u")
    Page<User> findList(Pageable pageable);

    User findById(long id);
    User findByUserName(String userName);
    void deleteById(Long id);
    User findByUserNameAndPassWord(String userName,String passWord);

}
