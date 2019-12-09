package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chuling
 * @date 16点33分
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface IManagerRepository extends JpaRepository<Manager, Integer> {

//    Manager getManagerByU(Integer integer);
}
