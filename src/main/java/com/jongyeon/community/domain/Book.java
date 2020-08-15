package com.jongyeon.community.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table
@Getter
public class Book {
    @Id
    @GeneratedValue
    private Integer idx;
    @Column
    private String title;
    @Column
    private LocalDateTime publishedAt;

    @Builder
    public Book(String title, LocalDateTime publishedAt){
        this.title=title;
        this.publishedAt=publishedAt;
    }
}
