package com.eppen.internalserver.models;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @Column(nullable = false, columnDefinition = "int(11) UNSIGNED COMMENT '自增长ID'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(100) COMMENT '备注创建人'")
    private String createdBy;

    @Column(columnDefinition = "varchar(100) COMMENT '备注修改人'")
    private String updatedBy;

    /*
      所以这里需要insertable = false,updatable = false，这样jpa更新插入时就不会去更新这个字段了，而是完全由数据库维护。
    */
    @CreationTimestamp
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private LocalDateTime createdAt;

    @Column(nullable = false, insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = false, columnDefinition="TINYINT DEFAULT 1 COMMENT '删除标记、1-在用 2-停用'")
    private Long delFlag;
}
