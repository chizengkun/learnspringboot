package com.ksyun.springtest.restful.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

//JSONUtil

@MappedSuperclass
@DynamicUpdate
@DynamicInsert
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "create_time")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date creation;

    @Column(name = "update_time")
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date updateTime;

    private Boolean deleted = false;

    public boolean getDeleted() {
        if (deleted == null) {
            return false;
        } else {
            return deleted.booleanValue();
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}