package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Manager;
import com.shengxi.carblog.pojo.weak.bigTable.UserBlogLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chuling
 * @date 16点33分
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface IManagerRepository extends JpaRepository<Manager, Integer> {
    /**
     * 根据id修改状态
     *
     * @param id     要修改的id
     * @param status 要修改的状态值
     * @return 修改的条数
     */
    @Modifying
    @Query(value = "UPDATE `manager` SET `status` = :status WHERE id = :id", nativeQuery = true)
    int updateStatus(@Param("id") Integer id, @Param("status") String status);
}
