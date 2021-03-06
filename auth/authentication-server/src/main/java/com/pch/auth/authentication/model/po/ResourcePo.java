package com.pch.auth.authentication.model.po;

import com.pch.common.base.BasePo;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners({ AuditingEntityListener.class })
@Table(name = "tb_resource")
public class ResourcePo extends BasePo {

    private static final long serialVersionUID = 4285835478693487481L;

    /**
     * 代码
     */
    private String code;

    /**
     * 类型
     */
    private String type;

    /**
     * 名称
     */
    private String name;

    private String url;

    /**
     * 方法
     */
    private String method;

    /**
     * 简介
     */
    private String description;

}
