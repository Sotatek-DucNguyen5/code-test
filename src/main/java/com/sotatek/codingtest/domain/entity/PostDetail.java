package com.sotatek.codingtest.domain.entity;

import com.sotatek.codingtest.domain.dto.PostDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "post_details")
@NoArgsConstructor
@AllArgsConstructor
public class PostDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "suburb_names")
    private String suburbNames;

    @Column(name = "postcodes")
    private String postcodes;

    public PostDetail(String suburbNames, String postcodes) {
        this.suburbNames = suburbNames;
        this.postcodes = postcodes;
    }

    public PostDetail(PostDetailDTO postDetailDTO) {
        this.suburbNames = postDetailDTO.getSuburbNames();
        this.postcodes = postDetailDTO.getPostcodes();
    }
}
