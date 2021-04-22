package com.pch.auth.authentication.service.impl;

import com.pch.auth.authentication.model.dto.RoleDto;
import com.pch.auth.authentication.model.po.RolePo;
import com.pch.auth.authentication.repository.RoleRepository;
import com.pch.auth.authentication.service.RoleService;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: admin
 * @Date: 2021/2/24
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDto findById(Long id) {
        Optional<RolePo> rolePoOptional = roleRepository.findById(id);
        RoleDto roleDto = new RoleDto();
        rolePoOptional.ifPresent(rolePo -> BeanUtils.copyProperties(rolePo, roleDto));
        return roleDto;
    }

    @Override
    @Transactional
    public Long save(RoleDto roleDto) {
        RolePo rolePo = new RolePo();
        BeanUtils.copyProperties(roleDto, rolePo);
        RolePo save = roleRepository.save(rolePo);
        return save.getId();
    }
}
