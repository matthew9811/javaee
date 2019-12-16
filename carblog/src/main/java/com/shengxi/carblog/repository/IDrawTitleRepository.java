package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.DrawTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrawTitleRepository extends JpaRepository<DrawTitle, Integer> {
}
