package com.shopme.admin.users;

import org.springframework.data.repository.CrudRepository;

import com.shopme.common.entity.Roles;

public interface RoleRepository extends CrudRepository<Roles, Integer>{

}
