package com.example.jwt.service.role;

import com.example.jwt.model.Role;
import com.example.jwt.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
