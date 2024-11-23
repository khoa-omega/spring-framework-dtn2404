package com.vti.blog_app.repository;

import com.vti.blog_app.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository
        extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
    // 1. Method name
    // Prefix: findBy, countBy, deleteBy, existsBy

    // SELECT * FROM comment WHERE email = ?
    List<Comment> findByEmail(String email);

    // SELECT * FROM comment WHERE id >= ? AND id <= ?
    List<Comment> findByIdGreaterThanEqualAndIdLessThanEqual(Long minId, Long maxId);

    Page<Comment> findByPostId(Long postId, Pageable pageable);

    // DELETE FROM comment WHERE email = ?
    void deleteByEmail(String email);

    // 2. @Query

    // HQL: Index
    // @Query("DELETE FROM Comment WHERE post.id = ?1")
    // void deleteAllByPostId(Long postId);

    // HQL: Name parameter
    // @Query("DELETE FROM Comment WHERE post.id = :postId")
    // void deleteAllByPostId(@Param("postId") Long postId);

    // SQL
    @Query(
            value = "DELETE FROM comment WHERE post_id = :postId",
            nativeQuery = true
    )
    @Modifying // Nếu làm thay đổi dữ liệu trong db
    @Transactional
    void deleteAllByPostId(@Param("postId") Long postId);
}
