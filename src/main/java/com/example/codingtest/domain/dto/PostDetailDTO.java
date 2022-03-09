package com.example.codingtest.domain.dto;

import com.example.codingtest.domain.entity.PostDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailDTO {
    private Long id;

    private String suburbNames;

    private Long postcodes;
    public PostDetailDTO(PostDetail postDetail) {
        this.id = postDetail.getId();
        this.suburbNames = postDetail.getSuburbNames();
        this.postcodes = postDetail.getPostcodes();
    }
}
