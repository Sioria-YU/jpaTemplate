package com.project.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
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
