package com.pch.gateway.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pch.common.base.BasePo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <P> 路由实体 </P>
 *
 * @Author: pch
 * @Date: 2021/2/18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_gateway_route")
public class GatewayRoutePo implements Serializable {

    private static final long serialVersionUID = -4043749724295641961L;
    @TableId
    private String routeId;
    private String uri;
    private String predicates;
    private String filters;
    private String description;
    private Integer orders = 0;
    private String status = "Y";

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String modifyBy;

    @TableField(fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;
}