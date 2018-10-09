package com.yushu.model;

import javax.persistence.*;

@Table(name = "hs_cardkind")
public class HsCardkind {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ''
     */
    @Column(name = "Name")
    private String name;

    /**
     * @return Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取''
     *
     * @return Name - ''
     */
    public String getName() {
        return name;
    }

    /**
     * 设置''
     *
     * @param name ''
     */
    public void setName(String name) {
        this.name = name;
    }
}