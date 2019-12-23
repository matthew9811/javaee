package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 评论持久层
 *
 * @author yan
 * @version 1.0.0
 * @see org.springframework.data.repository.Repository
 * @see org.springframework.data.repository.query.QueryByExampleExecutor
 * @see org.springframework.data.repository.PagingAndSortingRepository
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see org.springframework.data.jpa.repository.JpaSpecificationExecutor
 */
@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
}
