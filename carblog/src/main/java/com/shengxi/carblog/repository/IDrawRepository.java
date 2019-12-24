package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Draw;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 相册持久层
 *
 * @author yan
 * @version 1.0.3
 * @date 2019-12-23 12:00:57
 */
@Repository
public interface IDrawRepository extends JpaRepository<Draw, Integer>, JpaSpecificationExecutor<Draw> {


}
