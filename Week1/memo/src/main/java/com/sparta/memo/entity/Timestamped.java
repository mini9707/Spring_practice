package com.sparta.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {

    @CreatedDate
    @Column(updatable = false) // updatable = false -> 업데이트 불가
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate // 조회한 entity 객체 값을 변경할 때 변경 시간이 저장 (처음에 생성될 때도 저장됨)
    @Column
    @Temporal(TemporalType.TIMESTAMP) //
    private LocalDateTime modifiedAt;

    // DB 시간타입
    // DATE : 2023-01-01
    // TIME : 20:21:14
    // TIMESTAMP : 2023-01-01 20:21:14.1616464
}