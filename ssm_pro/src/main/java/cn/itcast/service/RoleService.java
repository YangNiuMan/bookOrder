package cn.itcast.service;

import cn.itcast.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll(Integer page,Integer pageSize);

    void save(Role role);

    Role findByRoleId(Integer roleId);

    void addPermissionToRole(Integer roleId, Integer[] ids);

    int findTotal();

    void delete(Integer roleId);

    List<Role> search(String sous, Integer page, Integer pageSize);

    int findCount(String sous);

    void updated(Integer roleId, String roleName, String roleDesc);

    Role findById(Integer roleId);
}
