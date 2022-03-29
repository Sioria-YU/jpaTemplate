package com.common;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;

@MappedSuperclass
@Data
public class DefaultJpaId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @CreatedBy
    Long createdBy;

    @LastModifiedBy
    Long updatedBy;
}
