package com.example.demo.service;

import com.example.demo.dto.request.RoleRequest;
import com.example.demo.dto.respone.RoleResponse;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor // tạo hàm tạo với tất cả các thuộc tính
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)// makeFinal = true để nếu k khai báo gì thì tự động các fiel là private final
@Slf4j
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
       return roleRepository.findAll()
               .stream()
               .map(role -> roleMapper.toRoleResponse(role))
               .toList();
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
