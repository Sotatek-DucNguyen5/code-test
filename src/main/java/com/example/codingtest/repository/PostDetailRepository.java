package com.example.codingtest.repository;

import com.example.codingtest.domain.entity.PostDetail;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDetailRepository extends JpaRepository<PostDetail, Long> {

    List<PostDetail> findByPostcodesInOrderBySuburbNames(List<Long> postcodes);
}
