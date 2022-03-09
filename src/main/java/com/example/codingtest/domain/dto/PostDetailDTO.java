package com.example.codingtest.domain.dto;

import com.example.codingtest.domain.entity.PostDetail;
import lombok.Data;

@Data
public class PostDetailDTO {
    private Long id;

    private String suburbNames;

    private Long postcodes;

    public PostDetailDTO build(PostDetail postDetail) {
        this.id = postDetail.getId();
        this.suburbNames = postDetail.getSuburbNames();
        this.postcodes = postDetail.getPostcodes();
        return this;
    }
}
