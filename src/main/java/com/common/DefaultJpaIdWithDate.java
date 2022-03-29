package com.common;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class DefaultJpaIdWithDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @CreatedBy
    Long createdBy;

    @LastModifiedBy
    Long updatedBy;

    @CreatedDate
    LocalDateTime createdOn = LocalDateTime.now();

    @LastModifiedDate
    LocalDateTime updatedOn = LocalDateTime.now();
}
