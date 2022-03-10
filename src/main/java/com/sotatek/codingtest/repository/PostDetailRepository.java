package com.sotatek.codingtest.repository;

import com.sotatek.codingtest.domain.entity.PostDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDetailRepository extends JpaRepository<PostDetail, Long> {

    List<PostDetail> findByPostcodesInOrderBySuburbNames(List<String> postcodes);
}
