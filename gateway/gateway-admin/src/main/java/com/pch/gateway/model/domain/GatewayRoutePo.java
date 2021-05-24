package com.pch.gateway.model.domain;

import com.pch.common.base.BasePo;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * <P> 路由实体 </P>
 *
 * @Author: pch
 * @Date: 2021/2/18
 */
@Getter
@Setter
@Entity
@Table(name = "tb_gateway_route")
@EntityListeners({ AuditingEntityListener.class })
public class GatewayRoutePo extends BasePo {

    private static final long serialVersionUID = -4043749724295641961L;

    @Id
    private String id;

    @Column(length = 150)
    private String uri;

    @Column(length = 250)
    private String predicates;

    @Column(length = 250)
    private String filters;

    @Column(length = 50)
    private String description;

    private Integer orders = 0;

    private String status = "Y";

}
