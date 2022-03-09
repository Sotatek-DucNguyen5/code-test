package com.example.codingtest.repository;

import com.example.codingtest.domain.entity.PostDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDetailRepository extends JpaRepository<PostDetail, Long> {
    @Query(value = "SELECT * FROM post_details WHERE postcodes >= ?1 AND postcodes <= ?2", nativeQuery = true)
    List<PostDetail> findAllByPostcode(@Param(value = "1") String firstPostcodes,@Param(value = "2") String secondPostcodes);
}
