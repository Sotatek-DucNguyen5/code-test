package com.sotatek.codingtest.domain.dto;

import com.sotatek.codingtest.domain.entity.PostDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailDTO {
    private String suburbNames;

    private String postcodes;

    public PostDetailDTO(PostDetail postDetail) {
        this.suburbNames = postDetail.getSuburbNames();
        this.postcodes = postDetail.getPostcodes();
    }
}
