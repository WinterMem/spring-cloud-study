package com.pch.auth.authentication.repository;

import com.pch.auth.authentication.model.po.PermissionPo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: pch
 * @Date: 2021/2/24
 */
public interface PermissionRepository extends JpaRepository<PermissionPo, Long> {

    @Query("select p from PermissionPo p where p.id in (:permissionIds)")
    List<PermissionPo> findByPermissionIds(@Param("permissionIds") List<Long> permissionIds);
}
