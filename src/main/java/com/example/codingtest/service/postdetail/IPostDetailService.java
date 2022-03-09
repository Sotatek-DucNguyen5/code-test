package com.example.codingtest.service.postdetail;

import com.example.codingtest.domain.dto.PostDetailDTO;
import com.example.codingtest.domain.entity.PostDetail;
import com.example.codingtest.service.IBaseService;

import java.util.List;

public interface IPostDetailService extends IBaseService<PostDetailDTO> {
    List<PostDetailDTO> findAllByPostcode(List<Long> postcodes);
}
