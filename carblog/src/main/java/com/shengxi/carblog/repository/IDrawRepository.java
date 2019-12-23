package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Draw;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 相册持久层
 *
 * @author yan
 * @version 1.0.3
 * @date 2019-12-23 12:00:57
 */
@Repository
public interface IDrawRepository extends JpaRepository<Draw, Integer> {


    /**
     * 分页查找对应的数据
     *
     * @param pagination :Pageable
     * @returnv list->Obj 获取出来的数据
     */
    List<Object> findDrawOfPagination(PageRequest pagination);
}
