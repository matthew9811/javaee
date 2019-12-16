package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer> {
}
