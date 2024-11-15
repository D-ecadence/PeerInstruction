package com.zch1001.pi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  // 标记为实体类
public class Teacher {

    @Id  // 主键字段
    private Long id;

    private String name;

    private String email;

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
