package com.example.codingtest.domain.entity;

import com.example.codingtest.domain.dto.PostDetailDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "post_details")
public class PostDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "suburb_names")
    private String suburbNames;

    @Column(name = "postcodes")
    private Long postcodes;

    public PostDetail build(PostDetailDTO postDetailDTO) {
        this.id = postDetailDTO.getId();
        this.suburbNames = postDetailDTO.getSuburbNames();
        this.postcodes = postDetailDTO.getPostcodes();
        return this;
    }
}
