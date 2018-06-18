package com.eppen.internalserver.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@javax.persistence.Table(name = "eppen_internal_server_table")
public class InternalTable extends BaseModel {


    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT '名字'")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(255) COMMENT 'uuid'")
    private String uuid;

}
